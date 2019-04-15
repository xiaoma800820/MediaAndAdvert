package com.xiaoma.service.core.impl;

import com.xiaoma.bean.bo.SysAdvertInfoExample;
import com.xiaoma.bean.bo.SysAdvertPutPlanExample;
import com.xiaoma.bean.bo.SysAdvertShowTypeExample;
import com.xiaoma.bean.dto.*;
import com.xiaoma.bean.po.*;
import com.xiaoma.bean.vo.*;
import com.xiaoma.exception.GlobalException;
import com.xiaoma.service.base.*;
import com.xiaoma.service.core.AdvertCoreService;
import com.xiaoma.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 广告核心业务实现类
 * @author mmh
 * @date 2019/3/20
 */
@Slf4j
@Service
public class AdvertCoreServiceImpl implements AdvertCoreService {

    @Autowired
    private AdvertInfoService advertInfoService;
    @Autowired
    private AdvertShowTypeService advertShowTypeService;
    @Autowired
    private AdvertPutPlanService advertPutPlanService;
    @Autowired
    private UserAdvertiserService userAdvertiserService;
    @Autowired
    private PlanRechargeService planRechargeService;
    @Autowired
    private RedisClient redisClient;


    @Override
    public RetInfo advertInfoAdd(AdvertInfoAddParam param) {
        log.info("===advertInfoAdd begin===" + param);
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validParamStrNotNull(param.getAdvertiserId());
        ParamCheckUtil.validParamStrNotNull(param.getAdvertName());
        ParamCheckUtil.validParamStrNotNull(param.getAdvertShowType());
        ParamCheckUtil.validParamStrNotNull(param.getAdvertUrl());
        RetInfo retInfo = new RetInfo();
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            int totalNum = advertInfoService.countAdvertInfo(null);
            String advertIdPrefix = "GG";
            String advertCode = CommonConstant.getCodeId(advertIdPrefix,4,totalNum);
            SysAdvertInfo advertInfo = new SysAdvertInfo();
            advertInfo.setAdvertId(advertCode);
            advertInfo.setAdvertiserId(param.getAdvertiserId());
            advertInfo.setAdvertiserPhone(param.getAdvertiserPhone());
            advertInfo.setAdvertName(param.getAdvertName());
            //1是投放中，0是空闲
            advertInfo.setAdvertStatus(CommonConstant.STANDARD_ZERO);
            advertInfo.setCreateTime(new Date());
            advertInfo.setAdvertUrl(param.getAdvertUrl());
            advertInfo.setAdvertShowType(param.getAdvertShowType());
            advertInfoService.saveAdvertInfo(advertInfo);
            retInfo.setResultCodes(ResultCodes.SUCCESS);
        }catch (RuntimeException e){
            e.printStackTrace();
            retInfo.setResultCodes(ResultCodes.FAILED);
            retInfo.setMessage("系统异常");
        }finally {
            lock.unlock();
        }
        log.info("===advertInfoAdd end===" + param);
        return retInfo;
    }

    @Override
    public RetInfo advertInfoUpdate(AdvertInfoEditParam param) {
        log.info("===advertInfoUpdate begin ===" + param);
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validParamStrNotNull(param.getAdvertId());
        SysAdvertInfo advertInfo = new SysAdvertInfo();
        BeanUtils.copyProperties(param,advertInfo);
        advertInfo.setUpdateTime(new Date());
        advertInfoService.updateAdvertInfoById(advertInfo);
        RetInfo retInfo = new RetInfo();
        retInfo.setResultCodes(ResultCodes.SUCCESS);
        log.info("===advertInfoUpdate end ===");
        return retInfo;
    }

    @Override
    public RetInfo queryAdvertList(AdvertListQryParam param) {
        log.info("===queryAdvertList begin===" + param);
        RetInfo retInfo = new RetInfo();
        SysAdvertInfoExample example = new SysAdvertInfoExample();
        SysAdvertInfoExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(param.getAdvertiserPhone())){
            criteria.andAdvertiserPhoneLike(param.getAdvertiserPhone());
        }
        if (!StringUtils.isEmpty(param.getAdvertName())){
            criteria.andAdvertNameLike(param.getAdvertName());
        }
        int totalRow = advertInfoService.countAdvertInfo(example);
        if (totalRow > CommonConstant.STANDARD_ZERO){
            PageUtil pageUtil = new PageUtil(param.getPageSize(), param.getPageNo());
            pageUtil.setTotalCount(totalRow);
            example.setOrderByClause(" create_time DESC " + pageUtil.getLimitCriterion());
            List<SysAdvertInfo> sysAdvertInfoList = advertInfoService.queryAdvertInfoList(example);
            if (sysAdvertInfoList != null && !sysAdvertInfoList.isEmpty()){
                List<String> showTypeIds = new ArrayList<>(10);
                for (SysAdvertInfo advertInfo : sysAdvertInfoList){
                    showTypeIds.add(advertInfo.getAdvertShowType());
                }
                Map<String,String> showTypeMap = queryAndConvertShowType(showTypeIds);
                List<AdvertInfoVO> advertInfoVOS = new ArrayList<>(sysAdvertInfoList.size());
                for (SysAdvertInfo advertInfo : sysAdvertInfoList){
                    AdvertInfoVO advertInfoVO = new AdvertInfoVO();
                    BeanUtils.copyProperties(advertInfo,advertInfoVO);
                    advertInfoVO.setShowName(showTypeMap.get(advertInfo.getAdvertShowType()));
                    advertInfoVOS.add(advertInfoVO);
                }
                retInfo.setResultCodes(ResultCodes.SUCCESS);
                retInfo.setData(advertInfoVOS);
                retInfo.setPages(pageUtil.getTotalPages());
            }else {
                retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
            }
        }else {
            retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
        }
        log.info("===queryAdvertList end===");
        return retInfo;
    }

    @Transactional
    @Override
    public RetInfo advertPutPlanAdd(AdvertPutPlanParam param) {
        log.info("===advertPutPlanAdd begin ===" + param);
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validParamStrNotNull(param.getAdvertId());
        ParamCheckUtil.validParamStrNotNull(param.getBillingType());
        ParamCheckUtil.validParamObjectNull(param.getPrice());
        ParamCheckUtil.validParamObjectNull(param.getQuota());
        ParamCheckUtil.validParamObjectNull(param.getExpansivity());
        RetInfo retInfo = new RetInfo();
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            SysAdvertInfo sysAdvertInfo = advertInfoService.queryAdvertInfoById(param.getAdvertId());
            int totalNum = advertPutPlanService.countByExample(null);
            String planCode = CommonConstant.getCodeId("GGGF",4,totalNum);
            SysAdvertPutPlan advertPutPlan = new SysAdvertPutPlan();
            advertPutPlan.setAdvertPlanId(planCode);
            advertPutPlan.setAdvertId(param.getAdvertId());
            advertPutPlan.setBillingType(param.getBillingType());
            advertPutPlan.setCreateTime(new Date());
            //0是空闲，1是投放中，2是已停止
            advertPutPlan.setStatus(CommonConstant.STANDARD_ZERO);
            advertPutPlan.setExpansivity(param.getExpansivity().setScale(1, BigDecimal.ROUND_HALF_UP));
            advertPutPlan.setPrice(param.getPrice().setScale(3, BigDecimal.ROUND_HALF_UP));
            advertPutPlan.setQuota(param.getQuota().setScale(2, BigDecimal.ROUND_HALF_UP));
            advertPutPlan.setSettleExpansivity(advertPutPlan.getExpansivity());
            advertPutPlan.setBalance(new BigDecimal(0));
            advertPutPlan.setAdvertiserId(sysAdvertInfo.getAdvertiserId());
            advertPutPlan.setAdvertiserPhone(sysAdvertInfo.getAdvertiserPhone());
            advertPutPlanService.saveAdvertPutPlanInfo(advertPutPlan);
            //跟新广告状态信息
            SysAdvertInfo sysAdvertInfoTemp = new SysAdvertInfo();
            sysAdvertInfoTemp.setAdvertId(param.getAdvertId());
            //0是空闲，1是投放中
            sysAdvertInfoTemp.setAdvertStatus(CommonConstant.STANDARD_ONE);
            sysAdvertInfoTemp.setUpdateTime(new Date());
            advertInfoService.updateAdvertInfoById(sysAdvertInfoTemp);
            retInfo.setResultCodes(ResultCodes.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            throw new GlobalException(ResultCodes.FAILED);
        }finally {
            lock.unlock();
        }
        log.info("===advertPutPlanAdd end ===");
        return retInfo;
    }

    @Override
    public RetInfo queryAdvertPutPlanList(AdvertPlanQryListParam param) {
        log.info("===queryAdvertPutPlanList begin===" + param);
        List<String> advertIds = null;
        if (param != null && !StringUtils.isEmpty(param.getAdvertName())){
            //查询出来广告名称对应的广告di
            advertIds = queryAndConvertAdvertIds(param.getAdvertName(),null);
        }
        SysAdvertPutPlanExample example = new SysAdvertPutPlanExample();
        SysAdvertPutPlanExample.Criteria criteria = example.createCriteria();
        if (advertIds != null){
            criteria.andAdvertIdIn(advertIds);
        }
        if (!StringUtils.isEmpty(param.getBillingType())){
            criteria.andBillingTypeEqualTo(param.getBillingType());
        }
        int totalRow = advertPutPlanService.countByExample(example);
        RetInfo retInfo = new RetInfo();
        if (totalRow > CommonConstant.STANDARD_ZERO){
            PageUtil pageUtil = new PageUtil(param.getPageSize(),param.getPageNo());
            pageUtil.setTotalCount(totalRow);
            example.setOrderByClause(" create_time DESC " + pageUtil.getLimitCriterion());
            List<SysAdvertPutPlan> advertPutPlanList = advertPutPlanService.queryListByExample(example);
            if (advertPutPlanList != null && !advertPutPlanList.isEmpty()){
                List<String> advertIdsTemp = new ArrayList<>();
                advertPutPlanList.forEach(sysAdvertPutPlan -> {
                    advertIdsTemp.add(sysAdvertPutPlan.getAdvertId());
                });
                Map<String,String> advertMap = queryAndConvertAdvertMap(advertIdsTemp);
                List<AdvertPutPlanVO> advertPutPlanVOS = new ArrayList<>(advertPutPlanList.size());
                for (SysAdvertPutPlan advertPutPlan : advertPutPlanList){
                    AdvertPutPlanVO advertPutPlanVO = new AdvertPutPlanVO();
                    BeanUtils.copyProperties(advertPutPlan,advertPutPlanVO);
                    advertPutPlanVO.setAdvertName(advertMap.get(advertPutPlan.getAdvertId()));
                    advertPutPlanVOS.add(advertPutPlanVO);
                }
                retInfo.setResultCodes(ResultCodes.SUCCESS);
                retInfo.setData(advertPutPlanVOS);
                retInfo.setPages(pageUtil.getTotalPages());
            }else {
                retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
            }
        }else {
            retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
        }
        log.info("===queryAdvertPutPlanList end===");
        return retInfo;
    }

    @Override
    public RetInfo updatePutPlanStatus(PutPlanStatusParam param) {
        log.info("===updatePutPlanStatus begin===" + param);
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validParamStrNotNull(param.getAdvertPlanId());
        ParamCheckUtil.validValueBetweenZeroToTwo(param.getStatus());
        SysAdvertPutPlan sysAdvertPutPlan = new SysAdvertPutPlan();
        sysAdvertPutPlan.setAdvertPlanId(param.getAdvertPlanId());
        sysAdvertPutPlan.setStatus(param.getStatus());
        sysAdvertPutPlan.setUpdateTime(new Date());
        advertPutPlanService.updateAdvertPutPlan(sysAdvertPutPlan);
        RetInfo retInfo = new RetInfo();
        retInfo.setResultCodes(ResultCodes.SUCCESS);
        log.info("===updatePutPlanStatus emd===");
        return retInfo;
    }

    @Override
    public RetInfo updateExpansivity(PlanExpansivityParam param) {
        log.info("===updateExpansivity begin===" + param);
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validParamStrNotNull(param.getAdvertPlanId());
        RetInfo retInfo = new RetInfo();
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            SysAdvertPutPlan sysAdvertPutPlanDB = advertPutPlanService.queryPutPlanById(param.getAdvertPlanId());
            SysAdvertPutPlan sysAdvertPutPlan = new SysAdvertPutPlan();
            sysAdvertPutPlan.setAdvertPlanId(param.getAdvertPlanId());
            sysAdvertPutPlan.setExpansivity(param.getExpansivity().setScale(1,BigDecimal.ROUND_HALF_UP));
            sysAdvertPutPlan.setUpdateTime(new Date());
            String todayYMD = XmDateUtil.dateFormat(new Date(),XmDateUtil.DATE_FORMAT_YMD);
            if (StringUtils.isEmpty(sysAdvertPutPlanDB.getUpdateYMD())){
                sysAdvertPutPlan.setSettleExpansivity(sysAdvertPutPlanDB.getExpansivity());
                sysAdvertPutPlan.setUpdateYMD(todayYMD);
            }else {
                String updateYMD = sysAdvertPutPlanDB.getUpdateYMD();
                if (!todayYMD.equals(updateYMD)){
                    sysAdvertPutPlan.setSettleExpansivity(sysAdvertPutPlanDB.getExpansivity());
                    sysAdvertPutPlan.setUpdateYMD(todayYMD);
                }
            }
            advertPutPlanService.updateAdvertPutPlan(sysAdvertPutPlan);
            retInfo.setResultCodes(ResultCodes.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            retInfo.setResultCodes(ResultCodes.FAILED);
        }finally {
            lock.unlock();
        }
        log.info("===updateExpansivity end===");
        return retInfo;
    }

    @Override
    public RetInfo advertListByAdvertiser(AdvertiserAdvertListParam param, String token) {
        log.info("===advertListByAdvertiser begin===" + param);
        RetInfo retInfo = new RetInfo();
        TokenUserVO tokenUserVO = (TokenUserVO) redisClient.get(token,TokenUserVO.class);
        SysAdvertInfoExample example = new SysAdvertInfoExample();
        SysAdvertInfoExample.Criteria criteria = example.createCriteria();
        criteria.andAdvertiserIdEqualTo(tokenUserVO.getUserId());
        if (!StringUtils.isEmpty(param.getAdvertName())){
            criteria.andAdvertNameLike(param.getAdvertName());
        }
        int totalRow = advertInfoService.countAdvertInfo(example);
        if (totalRow > CommonConstant.STANDARD_ZERO){
            PageUtil pageUtil = new PageUtil(param.getPageSize(), param.getPageNo());
            pageUtil.setTotalCount(totalRow);
            example.setOrderByClause(" create_time DESC " + pageUtil.getLimitCriterion());
            List<SysAdvertInfo> sysAdvertInfoList = advertInfoService.queryAdvertInfoList(example);
            if (sysAdvertInfoList != null && !sysAdvertInfoList.isEmpty()){
                List<String> showTypeIds = new ArrayList<>(10);
                for (SysAdvertInfo advertInfo : sysAdvertInfoList){
                    showTypeIds.add(advertInfo.getAdvertShowType());
                }
                Map<String,String> showTypeMap = queryAndConvertShowType(showTypeIds);
                List<AdvertiserAdvertVO> advertiserAdvertVOS = new ArrayList<>(sysAdvertInfoList.size());
                for (SysAdvertInfo advertInfo : sysAdvertInfoList){
                    AdvertiserAdvertVO advertInfoVO = new AdvertiserAdvertVO();
                    BeanUtils.copyProperties(advertInfo,advertInfoVO);
                    advertInfoVO.setShowName(showTypeMap.get(advertInfo.getAdvertShowType()));
                    advertiserAdvertVOS.add(advertInfoVO);
                }
                retInfo.setResultCodes(ResultCodes.SUCCESS);
                retInfo.setData(advertiserAdvertVOS);
                retInfo.setPages(pageUtil.getTotalPages());
            }else {
                retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
            }
        }else {
            retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
        }
        log.info("===advertListByAdvertiser end===");
        return retInfo;
    }

    @Override
    public RetInfo putPlanByAdvertiser(AdvertiserAdvertListParam param, String token) {
        log.info("===putPlanByAdvertiser begin===" + param);
        TokenUserVO tokenUserVO = (TokenUserVO) redisClient.get(token,TokenUserVO.class);
        List<String> advertIds = null;
        if (param != null && !StringUtils.isEmpty(param.getAdvertName())){
            //查询出来广告名称对应的广告di
            advertIds = queryAndConvertAdvertIds(param.getAdvertName(),tokenUserVO.getUserId());
        }
        SysAdvertPutPlanExample example = new SysAdvertPutPlanExample();
        SysAdvertPutPlanExample.Criteria criteria = example.createCriteria();
        if (advertIds != null){
            criteria.andAdvertIdIn(advertIds);
        }
        int totalRow = advertPutPlanService.countByExample(example);
        RetInfo retInfo = new RetInfo();
        if (totalRow > CommonConstant.STANDARD_ZERO){
            PageUtil pageUtil = new PageUtil(param.getPageSize(),param.getPageNo());
            pageUtil.setTotalCount(totalRow);
            example.setOrderByClause(" create_time DESC " + pageUtil.getLimitCriterion());
            List<SysAdvertPutPlan> advertPutPlanList = advertPutPlanService.queryListByExample(example);
            if (advertPutPlanList != null && !advertPutPlanList.isEmpty()){
                List<String> advertIdsTemp = new ArrayList<>();
                advertPutPlanList.forEach(sysAdvertPutPlan -> {
                    advertIdsTemp.add(sysAdvertPutPlan.getAdvertId());
                });
                Map<String,String> advertMap = queryAndConvertAdvertMap(advertIdsTemp);
                List<AdvertiserPutPlanVO> advertiserPutPlanVOS = new ArrayList<>(advertPutPlanList.size());
                for (SysAdvertPutPlan advertPutPlan : advertPutPlanList){
                    AdvertiserPutPlanVO advertPutPlanVO = new AdvertiserPutPlanVO();
                    BeanUtils.copyProperties(advertPutPlan,advertPutPlanVO);
                    advertPutPlanVO.setAdvertName(advertMap.get(advertPutPlan.getAdvertId()));
                    advertiserPutPlanVOS.add(advertPutPlanVO);
                }
                retInfo.setResultCodes(ResultCodes.SUCCESS);
                retInfo.setData(advertiserPutPlanVOS);
                retInfo.setPages(pageUtil.getTotalPages());
            }else {
                retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
            }
        }else {
            retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
        }
        log.info("===putPlanByAdvertiser end===");
        return retInfo;
    }

    @Transactional
    @Override
    public RetInfo advertiserRechargePlan(PlanRechargeParam param, String token) {
        log.info("===advertiserRechargePlan begin===" + param);
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validParamStrNotNull(param.getPlanId());
        ParamCheckUtil.validValueNotNullAndThanEqualZero(param.getTimes());
        RetInfo retInfo = new RetInfo();
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            SysAdvertPutPlan advertPutPlan = advertPutPlanService.queryPutPlanById(param.getPlanId());
            /*
             * 1、计算更新广告计划余额
             * 判断增加量小于等于余 额
             */
            BigDecimal quota = advertPutPlan.getQuota();
            BigDecimal addAmount = quota.multiply(new BigDecimal(param.getTimes())).setScale(2,BigDecimal.ROUND_HALF_UP);
            TokenUserVO tokenUserVO = (TokenUserVO) redisClient.get(token,TokenUserVO.class);
            SysUserAdvertisers advertisers = userAdvertiserService.queryAdvertiserById(tokenUserVO.getUserId());
            Date currTime = new Date();
            long addBalance = addAmount.multiply(new BigDecimal(100)).longValue();
            if (advertisers.getAccountBalance() < addBalance){
                log.error("===增加金额应<= 广告主余额===");
                retInfo.setResultCodes(ResultCodes.FAILED);
                retInfo.setMessage("投放金额应<= 广告主帐号余额");
            }else {
                BigDecimal beforeBalance = advertPutPlan.getBalance();
                BigDecimal afterAmount = beforeBalance.add(addAmount).setScale(2,BigDecimal.ROUND_HALF_UP);

                SysAdvertPutPlan advertPutPlanTemp = new SysAdvertPutPlan();
                advertPutPlanTemp.setAdvertPlanId(advertPutPlan.getAdvertPlanId());
                advertPutPlanTemp.setBalance(afterAmount);
                advertPutPlanTemp.setUpdateTime(currTime);
                advertPutPlanTemp.setStatus(CommonConstant.STANDARD_ONE);
                advertPutPlanService.updateAdvertPutPlan(advertPutPlanTemp);
                /*
                 * 2、更细广告主余额
                 */
                SysUserAdvertisers advertisersRecord = new SysUserAdvertisers();
                advertisersRecord.setUpdateTime(currTime);
                advertisersRecord.setAdvertiserId(tokenUserVO.getUserId());
                advertisersRecord.setAccountBalance(advertisers.getAccountBalance() - addBalance);
                userAdvertiserService.updateAdvertisersById(advertisersRecord);

                /*
                 * 3、计算新增充值记录
                 */
                SysPlanRecharge planRecharge = new SysPlanRecharge();
                planRecharge.setPlanRechargeNo(String.valueOf(currTime.getTime()));
                planRecharge.setCreateTime(currTime);
                planRecharge.setAdvertPlanId(advertPutPlan.getAdvertPlanId());
                planRecharge.setAdvertId(advertPutPlan.getAdvertId());
                planRecharge.setCreator(tokenUserVO.getUserId());
                planRecharge.setTimes(param.getTimes());
                planRecharge.setBelongType(CommonConstant.STANDARD_ONE);
                planRecharge.setQuota(quota);
                planRecharge.setBeforeBalance(beforeBalance);
                planRecharge.setAfterBalance(afterAmount);
                planRechargeService.savePlanRecharge(planRecharge);
                retInfo.setResultCodes(ResultCodes.SUCCESS);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new GlobalException(ResultCodes.FAILED);
        }finally {
            lock.unlock();
        }
        log.info("===advertiserRechargePlan end===");
        return retInfo;
    }

    @Override
    public RetInfo mediaPlanQryAdvertPlan(MediaAdvertPlanParam param) {
        log.info("===mediaPlanQryAdvertPlan begin===" + param);
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validParamStrNotNull(param.getBillingType());
        ParamCheckUtil.validParamStrNotNull(param.getShowCode());
        RetInfo retInfo = new RetInfo();
        SysAdvertPutPlanExample example = new SysAdvertPutPlanExample();
        SysAdvertPutPlanExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(CommonConstant.STANDARD_ONE);
        criteria.andBillingTypeEqualTo(param.getBillingType());
        List<SysAdvertPutPlan> advertPutPlans = advertPutPlanService.queryListByExample(example);
        if (advertPutPlans != null && advertPutPlans.size() > 0){
            List<String> advertIds = new ArrayList<>(advertPutPlans.size());
            advertPutPlans.forEach( sysAdvertPutPlan -> advertIds.add(sysAdvertPutPlan.getAdvertId()));
            SysAdvertInfoExample example1 = new SysAdvertInfoExample();
            SysAdvertInfoExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andAdvertIdIn(advertIds);
            criteria1.andAdvertShowTypeEqualTo(param.getShowCode());
            List<SysAdvertInfo> advertInfoList = advertInfoService.queryAdvertInfoList(example1);
            if (advertInfoList != null && advertInfoList.size() > 0){
                List<AdvertSimpleVO> advertSimpleVOS = new ArrayList<>();
                advertInfoList.forEach(sysAdvertInfo -> {
                    AdvertSimpleVO advertSimpleVO = new AdvertSimpleVO();
                    advertSimpleVO.setAdvertId(sysAdvertInfo.getAdvertId());
                    advertSimpleVO.setAdvertName(sysAdvertInfo.getAdvertName());
                    advertSimpleVOS.add(advertSimpleVO);
                });
                retInfo.setResultCodes(ResultCodes.SUCCESS);
                retInfo.setData(advertSimpleVOS);
            }else {
                retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
            }
        }else {
            retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
        }
        log.info("===mediaPlanQryAdvertPlan end===");
        return retInfo;
    }

    private Map<String,String> queryAndConvertShowType(List<String> showTypeIds){
        if (showTypeIds == null || showTypeIds.size() == 0){
            return null;
        }
        SysAdvertShowTypeExample example = new SysAdvertShowTypeExample();
        example.setDistinct(true);
        SysAdvertShowTypeExample.Criteria criteria = example.createCriteria();
        criteria.andShowCodeIn(showTypeIds);
        List<SysAdvertShowType> sysAdvertShowTypeList = advertShowTypeService.queryByExample(example);
        Map<String,String> showTypeMap = new HashMap<>(16);
        for (SysAdvertShowType sysAdvertShowType : sysAdvertShowTypeList){
            showTypeMap.put(sysAdvertShowType.getShowCode(),sysAdvertShowType.getShowName());
        }
        return showTypeMap;
    }

    private List<String> queryAndConvertAdvertIds(String advertName,String advertiserId){
        SysAdvertInfoExample example = new SysAdvertInfoExample();
        SysAdvertInfoExample.Criteria criteria = example.createCriteria();
        criteria.andAdvertNameLike(advertName);
        if (!StringUtils.isEmpty(advertiserId)){
            criteria.andAdvertiserIdEqualTo(advertiserId);
        }
        List<SysAdvertInfo> advertInfoList = advertInfoService.queryAdvertInfoList(example);
        List<String> advertIds = null;
        if (advertInfoList != null && !advertInfoList.isEmpty()){
            advertIds = new ArrayList<>();
            for (SysAdvertInfo advertInfo : advertInfoList){
                advertIds.add(advertInfo.getAdvertId());
            }
        }
        return advertIds;
    }

    private Map<String,String> queryAndConvertAdvertMap(List<String> advertIds){
        if (advertIds == null || advertIds.size() == 0){
            return null;
        }
        SysAdvertInfoExample example = new SysAdvertInfoExample();
        example.setDistinct(true);
        SysAdvertInfoExample.Criteria criteria = example.createCriteria();
        criteria.andAdvertIdIn(advertIds);
        List<SysAdvertInfo> sysAdvertInfoList = advertInfoService.queryAdvertInfoList(example);
        Map<String,String> advertInfoMap = new HashMap<>(16);
        for (SysAdvertInfo sysAdvertInfo : sysAdvertInfoList){
            advertInfoMap.put(sysAdvertInfo.getAdvertId(),sysAdvertInfo.getAdvertName());
        }
        return advertInfoMap;
    }
}
