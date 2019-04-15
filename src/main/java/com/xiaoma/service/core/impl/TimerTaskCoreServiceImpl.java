package com.xiaoma.service.core.impl;

import com.xiaoma.bean.bo.*;
import com.xiaoma.bean.po.*;
import com.xiaoma.service.base.*;
import com.xiaoma.service.core.TimerTaskCoreService;
import com.xiaoma.utils.CommonConstant;
import com.xiaoma.utils.PageUtil;
import com.xiaoma.utils.XmDateUtil;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

/**
 * 定时任务器
 * @author mmh
 * @date 2019/4/8
 */
@Slf4j
@Service
public class TimerTaskCoreServiceImpl implements TimerTaskCoreService {

    @Autowired
    private PlayRecordService playRecordService;
    @Autowired
    private AdvertPutPlanService advertPutPlanService;
    @Autowired
    private AdvertInfoService advertInfoService;
    @Autowired
    private SettleService settleService;
    @Autowired
    private MediaPutPlanService mediaPutPlanService;
    @Autowired
    private MediaAdvertPutService mediaAdvertPutService;


    /**
     * 广告主结算: 结算按单次点击计费和按千次点击计费
     * 一个计划一个结算单按播放次数
     * 按广告id、显示类型分组统计
     * 查询多少广告每个广告播放量
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void advertiserSettleTask() {
        log.info("===advertiserSettleTask begin===");
        List<SysAdvertAdvertiserBO> advertAdvertiserBOS = playRecordService.countQryAdvertAdvertiser();
        if (advertAdvertiserBOS != null && !advertAdvertiserBOS.isEmpty()){
            List<String> advertIDS = new ArrayList<>(advertAdvertiserBOS.size());
            //存储广告播放了多少次
            Map<String,Integer> advertIdNumMap = new HashMap<>(16);
            advertAdvertiserBOS.forEach(sysAdvertAdvertiserBO -> {
                advertIDS.add(sysAdvertAdvertiserBO.getAdvertId());
                advertIdNumMap.put(sysAdvertAdvertiserBO.getAdvertId(),sysAdvertAdvertiserBO.getPlayNum());
            });
            SysAdvertPutPlanExample example = new SysAdvertPutPlanExample();
            SysAdvertPutPlanExample.Criteria criteria = example.createCriteria();
            criteria.andAdvertIdIn(advertIDS);
            List<SysAdvertPutPlan> sysAdvertPutPlans = advertPutPlanService.queryListByExample(example);
            //计算广告和广告计划是1：1用户存储广告计算记录
            List<SysAccountSettleRecord> settleRecords = new ArrayList<>(sysAdvertPutPlans.size());
            log.info("===循环计算广告计划结算金额开始===" + sysAdvertPutPlans.size());
            for (SysAdvertPutPlan advertPutPlan : sysAdvertPutPlans){
                SysAccountSettleRecord settleRecord = new SysAccountSettleRecord();
                //状态是已结算
                settleRecord.setStatus(CommonConstant.STANDARD_ONE);
                //广告名称
                settleRecord.setAdvertName(advertPutPlan.getAdvertName());
                settleRecord.setBillingType(advertPutPlan.getBillingType());
                Date createTime = new Date();
                String billNo = createTime.getTime() + "" +CommonConstant.getRandRangeNumBer(3);
                settleRecord.setBillNo(billNo);
                settleRecord.setCreateTime(createTime);
                settleRecord.setCreateYmd(XmDateUtil.dateFormat(createTime,XmDateUtil.DATE_FORMAT_YMD));
                settleRecord.setUserId(advertPutPlan.getAdvertiserId());
                settleRecord.setUserName(advertPutPlan.getAdvertiserPhone());
                BigDecimal currentAmount = new BigDecimal(0.00);//膨胀扣量
                BigDecimal actualAmount = new BigDecimal(0.00);//实际扣量
                int playNum = advertIdNumMap.get(advertPutPlan.getAdvertId());
                if ("cpc".equals(advertPutPlan.getBillingType())){
                    //单次点击收费//计算当前:
                    currentAmount = advertPutPlan.getPrice().multiply(advertPutPlan.getSettleExpansivity()).multiply(new BigDecimal(playNum)).setScale(2,BigDecimal.ROUND_HALF_UP);
                    actualAmount = advertPutPlan.getPrice().multiply(new BigDecimal(playNum)).setScale(2,BigDecimal.ROUND_HALF_UP);
                }else if ("cpm".equals(advertPutPlan.getBillingType())){
                    //按点击千次收费不足1000按1千收费
                    int times = playNum % 1000 == 0 ? playNum/1000 : 1 + playNum/1000;
                    currentAmount = advertPutPlan.getPrice().multiply(advertPutPlan.getSettleExpansivity()).multiply(new BigDecimal(times)).setScale(2,BigDecimal.ROUND_HALF_UP);
                    actualAmount = advertPutPlan.getPrice().multiply(new BigDecimal(times)).setScale(2,BigDecimal.ROUND_HALF_UP);
                }
                settleRecord.setConsumptionNum(actualAmount);
                settleRecord.setPrice(advertPutPlan.getPrice());
                settleRecord.setExpansivity(currentAmount);
                settleRecord.setSettleAmount(currentAmount);
                settleRecord.setSettleType("广告投放");
                settleRecords.add(settleRecord);
            }
            log.info("===循环计算广告计划结算金额结束===");
            //批量查询结算记录
            settleService.batchSaveRecord(settleRecords);
        }else {
            log.info("query no data advert play is end");
        }
        log.info("===advertiserSettleTask end===");
    }

    /**
     * 媒体主结算:单次点击收费和按千次收费
     * 余额部分已在点击的时候扣掉
     * 这里只生成结算单
     * 分组查询出来广告、计划、播放量
     * 存储媒体计划id,//存储计划对应数量
     * 广告Ids
     * 状态是未结算
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void mediaOwnerSettleTask() {
        log.info("===mediaOwnerSettleTask begin ===");
        List<SysAdvertMediaBO> advertMediaBOS = playRecordService.countQryAdvertMedia();
        if (advertMediaBOS != null && !advertMediaBOS.isEmpty()){
            List<String> planIds = new ArrayList<>(advertMediaBOS.size());
            List<String> advertIDS = new ArrayList<>(advertMediaBOS.size());
            advertMediaBOS.forEach(sysAdvertMediaBO -> {
                planIds.add(sysAdvertMediaBO.getPlanId());
                advertIDS.add(sysAdvertMediaBO.getAdvertId());
            });
            SysMediaPutPlanExample example = new SysMediaPutPlanExample();
            SysMediaPutPlanExample.Criteria criteria = example.createCriteria();
            criteria.andMediaPlanIdIn(planIds);
            List<SysMediaPutPlan> putPlans = mediaPutPlanService.queryMediaPutPlan(example);
            Map<String,SysMediaPutPlan> putPlanMap = new HashMap<>(16);
            putPlans.forEach( sysMediaPutPlan -> {
                putPlanMap.put(sysMediaPutPlan.getMediaPlanId(),sysMediaPutPlan);
            });
            SysAdvertInfoExample example1 = new SysAdvertInfoExample();
            SysAdvertInfoExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andAdvertIdIn(advertIDS);
            List<SysAdvertInfo> advertInfoList = advertInfoService.queryAdvertInfoList(example1);
            Map<String,SysAdvertInfo> advertInfoMap = new HashMap<>(16);
            advertInfoList.forEach(sysAdvertInfo -> advertInfoMap.put(sysAdvertInfo.getAdvertId(),sysAdvertInfo));
            log.info("===媒体主结算单计算开始===" + advertMediaBOS.size());
            //计算广告和广告计划是1：1用户存储广告计算记录
            List<SysAccountSettleRecord> settleRecords = new ArrayList<>(advertMediaBOS.size());
            for (SysAdvertMediaBO advertMediaBO : advertMediaBOS){
                SysMediaPutPlan mediaPutPlan = putPlanMap.get(advertMediaBO.getPlanId());
                if ("cpt".equals(mediaPutPlan.getBillingType())){
                    continue;
                }
                SysAccountSettleRecord settleRecord = new SysAccountSettleRecord();
                settleRecord.setStatus(CommonConstant.STANDARD_ZERO);
                settleRecord.setAdvertName(advertInfoMap.get(advertMediaBO.getAdvertId()).getAdvertName());
                settleRecord.setBillingType(mediaPutPlan.getBillingType());
                Date createTime = new Date();
                String billNo = createTime.getTime() + "" +CommonConstant.getRandRangeNumBer(3);
                settleRecord.setBillNo(billNo);
                settleRecord.setCreateTime(createTime);
                settleRecord.setCreateYmd(XmDateUtil.dateFormat(createTime,XmDateUtil.DATE_FORMAT_YMD));
                settleRecord.setUserId(mediaPutPlan.getMediaOwnerId());
                settleRecord.setUserName(mediaPutPlan.getMediaPhone());
                BigDecimal currentAmount = new BigDecimal(0.00);//膨胀扣量
                BigDecimal actualAmount = new BigDecimal(0.00);//实际扣量
                int playNum = advertMediaBO.getPlayNum();
                if ("cpc".equals(mediaPutPlan.getBillingType())){
                    //单次点击收费,计算当前:
                    currentAmount = mediaPutPlan.getPrice().multiply(mediaPutPlan.getSettleExpansivity()).multiply(new BigDecimal(playNum)).setScale(2,BigDecimal.ROUND_HALF_UP);
                    actualAmount = mediaPutPlan.getPrice().multiply(new BigDecimal(playNum)).setScale(2,BigDecimal.ROUND_HALF_UP);
                }else if ("cpm".equals(mediaPutPlan.getBillingType())){
                    //按点击千次收费不足1000按1千收费
                    int times = playNum % 1000 == 0 ? playNum/1000 : 1 + playNum/1000;
                    currentAmount = mediaPutPlan.getPrice().multiply(mediaPutPlan.getSettleExpansivity()).multiply(new BigDecimal(times)).setScale(2,BigDecimal.ROUND_HALF_UP);
                    actualAmount = mediaPutPlan.getPrice().multiply(new BigDecimal(times)).setScale(2,BigDecimal.ROUND_HALF_UP);
                }
                settleRecord.setConsumptionNum(actualAmount);
                settleRecord.setPrice(mediaPutPlan.getPrice());
                settleRecord.setExpansivity(currentAmount);
                settleRecord.setSettleAmount(currentAmount);
                settleRecord.setSettleType("佣金结算");
                settleRecords.add(settleRecord);
            }
            log.info("===媒体主结算单计算结束===");
            //批量查询结算记录
            settleService.batchSaveRecord(settleRecords);
        }else {
            log.info("===query no data media settle is end===");
        }
        log.info("===mediaOwnerSettleTask end ===");
    }

    /**
     * 查询所有广告计划是按CPT计费和投放中的
     * 余额大于计费额的直接扣除更新，生成结算单
     * 余额小于计费额的直接停止计划，更新计划状态
     * 停止余额不足的广告
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void advertiserSettleExecuteCPT() {
        log.info("===查询广告主的广告计划计费形式是按天的，直接每天凌晨扣掉 begin===");
        SysAdvertPutPlanExample example = new SysAdvertPutPlanExample();
        SysAdvertPutPlanExample.Criteria criteria = example.createCriteria();
        criteria.andBillingTypeEqualTo("cpt");
        criteria.andStatusEqualTo(CommonConstant.STANDARD_ONE);
        List<SysAdvertPutPlan> advertPutPlans = advertPutPlanService.queryListByExample(example);
        if (advertPutPlans != null && !advertPutPlans.isEmpty()){
            //用于存放结算的单数据
            List<SysAccountSettleRecord> settleRecords = new ArrayList<>();
            //用于存放余额不足的计划
            List<SysAdvertPutPlan> unBillingPutPlans = new ArrayList<>();
            List<SysAdvertPutPlan> billingPutPlans = new ArrayList<>();
            for (SysAdvertPutPlan advertPutPlan : advertPutPlans){
                if (advertPutPlan.getBalance().compareTo(advertPutPlan.getPrice()) == -1){
                    unBillingPutPlans.add(advertPutPlan);
                }else {
                    SysAccountSettleRecord settleRecord = new SysAccountSettleRecord();
                    //状态是已结算
                    settleRecord.setStatus(CommonConstant.STANDARD_ONE);
                    //广告名称
                    settleRecord.setAdvertName(advertPutPlan.getAdvertName());
                    settleRecord.setBillingType(advertPutPlan.getBillingType());
                    Date createTime = new Date();
                    String billNo = createTime.getTime() + "" +CommonConstant.getRandRangeNumBer(3);
                    settleRecord.setBillNo(billNo);
                    settleRecord.setCreateTime(createTime);
                    settleRecord.setCreateYmd(XmDateUtil.dateFormat(createTime,XmDateUtil.DATE_FORMAT_YMD));
                    settleRecord.setUserId(advertPutPlan.getAdvertiserId());
                    settleRecord.setUserName(advertPutPlan.getAdvertiserPhone());
                    //按天收费
                    BigDecimal currentAmount = advertPutPlan.getPrice().multiply(advertPutPlan.getSettleExpansivity()).setScale(2,BigDecimal.ROUND_HALF_UP);
                    BigDecimal actualAmount = advertPutPlan.getPrice().setScale(2,BigDecimal.ROUND_HALF_UP);
                    settleRecord.setConsumptionNum(actualAmount);
                    settleRecord.setPrice(advertPutPlan.getPrice());
                    settleRecord.setExpansivity(currentAmount);
                    settleRecord.setSettleAmount(currentAmount);
                    settleRecord.setSettleType("广告投放");
                    settleRecords.add(settleRecord);
                    billingPutPlans.add(advertPutPlan);
                }
                //批量查询结算记录
                settleService.batchSaveRecord(settleRecords);
                for (SysAdvertPutPlan putPlan : billingPutPlans){
                    SysAdvertPutPlan putPlanTemp = new SysAdvertPutPlan();
                    putPlanTemp.setAdvertPlanId(putPlan.getAdvertPlanId());
                    putPlanTemp.setUpdateTime(new Date());
                    BigDecimal oldBalance = putPlan.getBalance();
                    BigDecimal subBalance = putPlan.getPrice();
                    putPlanTemp.setBalance(oldBalance.subtract(subBalance));
                    log.info("===更新计划扣减余额>" + putPlanTemp);
                    advertPutPlanService.updateAdvertPutPlan(putPlanTemp);
                }
                for (SysAdvertPutPlan putPlan : unBillingPutPlans){
                    SysAdvertPutPlan putPlanTemp = new SysAdvertPutPlan();
                    putPlanTemp.setAdvertPlanId(putPlan.getAdvertPlanId());
                    putPlanTemp.setUpdateTime(new Date());
                    putPlanTemp.setStatus(CommonConstant.STANDARD_TWO);
                    log.info("===更新计划余额不足停止投放" + putPlanTemp);
                    advertPutPlanService.updateAdvertPutPlan(putPlanTemp);
                }
            }
        }else {
            log.info("===广告投放中计划按天计费未查到数据===" + DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        }
        log.info("===查询广告主的广告计划计费形式是按天的，直接每天凌晨扣掉 end===");
    }


    /**
     * 查询所有媒体计划是按CPT计费和投放中的
     * 余额大于计费额的直接扣除更新，生成结算单
     * 余额小于计费额的直接停止计划，更新计划状态
     * 停止余额不足的广告
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void mediaOwnerSettleExecuteCPT() {
        log.info("===查询媒体主按天计费形式的媒体投放计划，直接每天凌晨扣掉 begin===");
        SysMediaPutPlanExample example = new SysMediaPutPlanExample();
        SysMediaPutPlanExample.Criteria criteria = example.createCriteria();
        criteria.andBillingTypeEqualTo("cpt");
        criteria.andStatusEqualTo(CommonConstant.STANDARD_ONE);
        List<SysMediaPutPlan> mediaPutPlanList = mediaPutPlanService.queryMediaPutPlan(example);
        if (mediaPutPlanList != null && !mediaPutPlanList.isEmpty()){
            //用于存放结算的单数据
            List<SysAccountSettleRecord> settleRecords = new ArrayList<>();
            //用于存放余额不足的计划
            List<SysMediaPutPlan> unBillingPutPlans = new ArrayList<>();
            List<SysMediaPutPlan> billingPutPlans = new ArrayList<>();
            for (SysMediaPutPlan mediaPutPlan : mediaPutPlanList){
                if (mediaPutPlan.getBalance().compareTo(mediaPutPlan.getPrice()) == -1){
                    unBillingPutPlans.add(mediaPutPlan);
                }else {
                    List<SysMediaAdvertPut> mediaAdvertPuts = mediaAdvertPutService.queryByPlanId(mediaPutPlan.getMediaPlanId());
                    if (mediaAdvertPuts == null || mediaAdvertPuts.isEmpty()){
                        unBillingPutPlans.add(mediaPutPlan);
                    }else {
                        SysAccountSettleRecord settleRecord = new SysAccountSettleRecord();
                        //状态是未结算
                        settleRecord.setStatus(CommonConstant.STANDARD_ZERO);
                        //广告名称
                        String advertName = "";
                        for (SysMediaAdvertPut advertPut : mediaAdvertPuts){
                            advertName = advertName + advertPut.getAdvertName();
                        }
                        settleRecord.setAdvertName(advertName);
                        settleRecord.setBillingType(mediaPutPlan.getBillingType());
                        Date createTime = new Date();
                        String billNo = createTime.getTime() + "" +CommonConstant.getRandRangeNumBer(3);
                        settleRecord.setBillNo(billNo);
                        settleRecord.setCreateTime(createTime);
                        settleRecord.setCreateYmd(XmDateUtil.dateFormat(createTime,XmDateUtil.DATE_FORMAT_YMD));
                        settleRecord.setUserId(mediaPutPlan.getMediaOwnerId());
                        settleRecord.setUserName(mediaPutPlan.getMediaPhone());
                        //按天收费
                        BigDecimal currentAmount = mediaPutPlan.getPrice().multiply(mediaPutPlan.getSettleExpansivity()).setScale(2,BigDecimal.ROUND_HALF_UP);
                        BigDecimal actualAmount = mediaPutPlan.getPrice().setScale(2,BigDecimal.ROUND_HALF_UP);
                        settleRecord.setConsumptionNum(actualAmount);
                        settleRecord.setPrice(mediaPutPlan.getPrice());
                        settleRecord.setExpansivity(currentAmount);
                        settleRecord.setSettleAmount(currentAmount);
                        settleRecord.setSettleType("佣金结算");
                        settleRecords.add(settleRecord);
                        billingPutPlans.add(mediaPutPlan);
                    }
                }
                //批量查询结算记录
                settleService.batchSaveRecord(settleRecords);
                for (SysMediaPutPlan putPlan : billingPutPlans){
                    SysMediaPutPlan putPlanTemp = new SysMediaPutPlan();
                    putPlanTemp.setMediaPlanId(putPlan.getMediaPlanId());
                    putPlanTemp.setUpdateTime(new Date());
                    BigDecimal oldBalance = putPlan.getBalance();
                    BigDecimal subBalance = putPlan.getPrice();
                    putPlanTemp.setBalance(oldBalance.subtract(subBalance));
                    log.info("===更新计划扣减余额>" + putPlanTemp);
                    mediaPutPlanService.updateMediaPutPlan(putPlanTemp);
                }
                for (SysMediaPutPlan putPlan : unBillingPutPlans){
                    SysMediaPutPlan putPlanTemp = new SysMediaPutPlan();
                    putPlanTemp.setMediaPlanId(putPlan.getMediaPlanId());
                    putPlanTemp.setUpdateTime(new Date());
                    putPlanTemp.setStatus(CommonConstant.STANDARD_TWO);
                    log.info("===更新计划余额不足停止投放" + putPlanTemp);
                    mediaPutPlanService.updateMediaPutPlan(putPlanTemp);
                }
            }
        }else {
            log.info("===媒体投放中计划按天计费未查到数据===" + DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
        }
        log.info("===查询媒体主按天计费形式的媒体投放计划，直接每天凌晨扣掉 end===");
    }
}
