package com.xiaoma.service.core.impl;

import com.xiaoma.bean.bo.*;
import com.xiaoma.bean.dto.*;
import com.xiaoma.bean.po.*;
import com.xiaoma.bean.vo.MediaAdvertVO;
import com.xiaoma.bean.vo.MediaInfoVO;
import com.xiaoma.bean.vo.TokenUserVO;
import com.xiaoma.exception.GlobalException;
import com.xiaoma.service.base.*;
import com.xiaoma.service.core.MediaCoreService;
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
 * 媒体主核心业务实现
 * @author mmh
 * @date 2019/3/25
 */
@Slf4j
@Service
public class MediaCoreServiceImpl implements MediaCoreService {


    @Autowired
    private MediaInfoService mediaInfoService;
    @Autowired
    private MediaTypeService mediaTypeService;
    @Autowired
    private AdvertShowTypeService advertShowTypeService;
    @Autowired
    private MediaPutPlanService mediaPutPlanService;
    @Autowired
    private MediaAdvertPutService mediaAdvertPutService;
    @Autowired
    private RedisClient redisClient;
    @Autowired
    private PlanRechargeService planRechargeService;
    @Autowired
    private AdvertInfoService advertInfoService;
    @Autowired
    private PlayRecordService playRecordService;
    @Autowired
    private AdvertPutPlanService advertPutPlanService;


    @Override
    public RetInfo saveMediaInfo(MediaInfoAddParam param) {
        log.info("===saveMediaInfo begin===" + param);
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validParamStrNotNull(param.getAdvertPosition());
        ParamCheckUtil.validParamStrNotNull(param.getMediaOwnerId());
        ParamCheckUtil.validParamStrNotNull(param.getMediaName());
        ParamCheckUtil.validParamStrNotNull(param.getMediaPhone());
        ParamCheckUtil.validParamStrNotNull(param.getAdvertShowType());
        ParamCheckUtil.validParamNotNullAndThanZero(param.getMediaTypeId());
        RetInfo retInfo = new RetInfo();
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            int totalNum = mediaInfoService.countByExmple(null);
            SysMediaInfo mediaInfo = new SysMediaInfo();
            String userId = CommonConstant.getCodeId("MT", 4, totalNum);
            BeanUtils.copyProperties(param,mediaInfo);
            mediaInfo.setMediaId(userId);
            mediaInfo.setCreateTime(new Date());
            //0是空闲中，1是投放中
            mediaInfo.setStatus(CommonConstant.STANDARD_ZERO);
            mediaInfoService.saveMediaInfo(mediaInfo);
            retInfo.setResultCodes(ResultCodes.SUCCESS);
        }catch (RuntimeException e){
            e.printStackTrace();
            retInfo.setResultCodes(ResultCodes.FAILED);
        }finally {
            lock.unlock();
        }
        log.info("===saveMediaInfo end===");
        return retInfo;
    }

    @Override
    public RetInfo queryMediaInfoList(MediaQryListParam param) {
        log.info("===queryMediaInfoList begin===" + param);
        SysMediaInfoExample example = new SysMediaInfoExample();
        SysMediaInfoExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(param.getMediaPhone())){
            criteria.andMediaPhoneLike(param.getMediaPhone());
        }
        if (!StringUtils.isEmpty(param.getMediaName())){
            criteria.andMediaNameLike(param.getMediaName());
        }
        int totalRow = mediaInfoService.countByExmple(example);
        RetInfo retInfo = new RetInfo();
        if (totalRow > CommonConstant.STANDARD_ZERO){
            PageUtil pageUtil = new PageUtil(param.getPageSize(),param.getPageNo());
            pageUtil.setTotalCount(totalRow);
            example.setOrderByClause(" create_time DESC " + pageUtil.getLimitCriterion());
            List<SysMediaInfo> mediaInfoList = mediaInfoService.queryMediaInfoList(example);
            if (mediaInfoList != null && !mediaInfoList.isEmpty()){
                List<Long> mediaTypeIds = new ArrayList<>();
                List<String> showTypeIds = new ArrayList<>();
                mediaInfoList.forEach(sysMediaInfo -> {
                    mediaTypeIds.add(sysMediaInfo.getMediaTypeId());
                    showTypeIds.add(sysMediaInfo.getAdvertShowType());
                });
                Map<String,String> mediaTypeMap = queryAndConvertMediaType(mediaTypeIds);
                Map<String,String> showTypeMap = queryAndConvertShowType(showTypeIds);
                List<MediaInfoVO> mediaInfoVOList = new ArrayList<>(mediaInfoList.size());
                for (SysMediaInfo sysMediaInfo : mediaInfoList){
                    MediaInfoVO mediaInfoVO = new MediaInfoVO();
                    BeanUtils.copyProperties(sysMediaInfo,mediaInfoVO);
                    mediaInfoVO.setMediaTypeName(mediaTypeMap.get(sysMediaInfo.getMediaTypeId()));
                    mediaInfoVO.setShowTypeName(showTypeMap.get(sysMediaInfo.getAdvertShowType()));
                    mediaInfoVOList.add(mediaInfoVO);
                }
                retInfo.setResultCodes(ResultCodes.SUCCESS);
                retInfo.setData(mediaInfoVOList);
                retInfo.setPages(pageUtil.getTotalPages());
            }else {
                retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
            }
        }else {
            retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
        }
        log.info("===queryMediaInfoList end===");
        return retInfo;
    }

    @Transactional
    @Override
    public RetInfo mediaPutPlanAdd(MediaPutPlanParam param) {
        log.info("===mediaPutPlanAdd begin==" + param);
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validParamStrNotNull(param.getMediaId());
        ParamCheckUtil.validParamStrNotNull(param.getMediaName());
        ParamCheckUtil.validParamStrNotNull(param.getBillingType());
        ParamCheckUtil.validParamObjectNull(param.getExpansivity());
        ParamCheckUtil.validParamObjectNull(param.getPrice());
        ParamCheckUtil.validParamObjectNull(param.getQuota());
        ParamCheckUtil.validObjectListNull(param.getMediaAdvertPuts());
        RetInfo retInfo = new RetInfo();
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            SysMediaInfo dbMediaInfo = mediaInfoService.queryMediaInfoByMediaId(param.getMediaId());
            int totalNum = mediaPutPlanService.countMediaPlan(null);
            String planCode = CommonConstant.getCodeId("MTTF",4,totalNum);
            SysMediaPutPlan mediaPutPlan = new SysMediaPutPlan();
            mediaPutPlan.setMediaPlanId(planCode);
            mediaPutPlan.setMediaId(param.getMediaId());
            mediaPutPlan.setMediaName(param.getMediaName());
            mediaPutPlan.setBillingType(param.getBillingType());
            mediaPutPlan.setCreateTime(new Date());
            mediaPutPlan.setExpansivity(param.getExpansivity().setScale(1,BigDecimal.ROUND_HALF_UP));
            mediaPutPlan.setSettleExpansivity(param.getExpansivity().setScale(1,BigDecimal.ROUND_HALF_UP));
            mediaPutPlan.setPrice(param.getPrice().setScale(3,BigDecimal.ROUND_HALF_UP));
            mediaPutPlan.setQuota(param.getQuota().setScale(2,BigDecimal.ROUND_HALF_UP));
            mediaPutPlan.setStatus(CommonConstant.STANDARD_ZERO);
            mediaPutPlan.setBalance(new BigDecimal(0.00));
            mediaPutPlan.setMediaOwnerId(dbMediaInfo.getMediaOwnerId());
            mediaPutPlan.setMediaPhone(dbMediaInfo.getMediaPhone());
            mediaPutPlanService.saveMediaPutPlanInfo(mediaPutPlan);
            SysMediaInfo sysMediaInfo = new SysMediaInfo();
            sysMediaInfo.setStatus(CommonConstant.STANDARD_ONE);
            sysMediaInfo.setUpdateTime(new Date());
            sysMediaInfo.setMediaId(param.getMediaId());
            mediaInfoService.updateMediaInfo(sysMediaInfo);
            List<MediaAdvertPut> mediaAdvertPuts = param.getMediaAdvertPuts();
            List<SysMediaAdvertPut> mediaAdvertPutList = new ArrayList<>(mediaAdvertPuts.size());

            mediaAdvertPuts.forEach(mediaAdvertPut -> {
                SysAdvertInfo sysAdvertInfo = advertInfoService.queryAdvertInfoById(mediaAdvertPut.getAdvertId());
                SysMediaAdvertPut sysMediaAdvertPut = new SysMediaAdvertPut();
                BeanUtils.copyProperties(mediaAdvertPut,sysMediaAdvertPut);
                sysMediaAdvertPut.setCreateTime(new Date());
                sysMediaAdvertPut.setStatus(CommonConstant.STANDARD_ONE);
                sysMediaAdvertPut.setMediaPlanId(planCode);
                sysMediaAdvertPut.setAdvertUrl(sysAdvertInfo.getAdvertUrl());
                sysMediaAdvertPut.setAdvertShowType(sysAdvertInfo.getAdvertShowType());
                mediaAdvertPutList.add(sysMediaAdvertPut);
            });
            mediaAdvertPutService.batchSaveMediaAdvertPut(mediaAdvertPutList);
            retInfo.setResultCodes(ResultCodes.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            throw new GlobalException(ResultCodes.FAILED);
        }finally {
            lock.unlock();
        }
        log.info("===mediaPutPlanAdd end==");
        return retInfo;
    }

    @Override
    public RetInfo queryMediaPutPlanList(MediaPlanQryListParam param) {
        log.info("===queryMediaPutPlanList begin===" + param);
        SysMediaPutPlanExample example = new SysMediaPutPlanExample();
        SysMediaPutPlanExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(param.getMediaName())){
            criteria.andMediaNameLike(param.getMediaName());
        }
        if (!StringUtils.isEmpty(param.getBillingType())){
            criteria.andBillingTypeLike(param.getBillingType());
        }
        int totalRow = mediaPutPlanService.countMediaPlan(example);
        RetInfo retInfo = new RetInfo();
        if (totalRow > CommonConstant.STANDARD_ZERO){
            PageUtil pageUtil = new PageUtil(param.getPageSize(),param.getPageNo());
            pageUtil.setTotalCount(totalRow);
            example.setOrderByClause(" create_time DESC " + pageUtil.getLimitCriterion());
            List<SysMediaPutPlan> mediaPutPlans = mediaPutPlanService.queryMediaPutPlan(example);
            if (mediaPutPlans != null && !mediaPutPlans.isEmpty()){
                retInfo.setResultCodes(ResultCodes.SUCCESS);
                retInfo.setData(mediaPutPlans);
                retInfo.setPages(pageUtil.getTotalPages());
            }else {
                retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
            }
        }else {
            retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
        }
        log.info("===queryMediaPutPlanList end===");
        return retInfo;
    }

    @Override
    public RetInfo updatePutPlanStatus(MediaPlanStatusParam param) {
        log.info("===updatePutPlanStatus begin ===" + param);
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validParamStrNotNull(param.getMediaPlanId());
        ParamCheckUtil.validValueBetweenZeroToTwo(param.getStatus());
        SysMediaPutPlan sysMediaPutPlan = new SysMediaPutPlan();
        sysMediaPutPlan.setMediaPlanId(param.getMediaPlanId());
        sysMediaPutPlan.setStatus(param.getStatus());
        sysMediaPutPlan.setUpdateTime(new Date());
        mediaPutPlanService.updateMediaPutPlan(sysMediaPutPlan);
        RetInfo retInfo = new RetInfo();
        retInfo.setResultCodes(ResultCodes.SUCCESS);
        log.info("===updatePutPlanStatus end ===");
        return retInfo;
    }

    @Override
    public RetInfo updateExpansivity(MediaExpansivityParam param) {
        log.info("===updateMediaExpansivity begin ===" + param);
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validParamStrNotNull(param.getMediaPlanId());
        RetInfo retInfo = new RetInfo();
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            SysMediaPutPlan sysMediaPutPlanDB = mediaPutPlanService.queryMediaPutPlan(param.getMediaPlanId());
            SysMediaPutPlan sysMediaPutPlan = new SysMediaPutPlan();
            sysMediaPutPlan.setMediaPlanId(param.getMediaPlanId());
            sysMediaPutPlan.setSettleExpansivity(sysMediaPutPlanDB.getExpansivity());
            sysMediaPutPlan.setExpansivity(param.getExpansivity());
            sysMediaPutPlan.setUpdateTime(new Date());
            String todayYMD = XmDateUtil.dateFormat(new Date(),XmDateUtil.DATE_FORMAT_YMD);
            if (StringUtils.isEmpty(sysMediaPutPlanDB.getUpdateYMD())){
                sysMediaPutPlan.setSettleExpansivity(sysMediaPutPlanDB.getExpansivity());
                sysMediaPutPlan.setUpdateYMD(todayYMD);
            }else {
                String updateYMD = sysMediaPutPlanDB.getUpdateYMD();
                if (!todayYMD.equals(updateYMD)){
                    sysMediaPutPlan.setSettleExpansivity(sysMediaPutPlanDB.getExpansivity());
                    sysMediaPutPlan.setUpdateYMD(todayYMD);
                }
            }
            mediaPutPlanService.updateMediaPutPlan(sysMediaPutPlan);
            retInfo.setResultCodes(ResultCodes.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            retInfo.setResultCodes(ResultCodes.FAILED);
        }finally {
            lock.unlock();
        }
        log.info("===updateMediaExpansivity end ===");
        return retInfo;
    }

    @Transactional
    @Override
    public RetInfo mediaPlanRecharge(PlanRechargeParam param,String token) {
        log.info("===mediaPlanRecharge begin===" + param);
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validParamStrNotNull(param.getPlanId());
        ParamCheckUtil.validValueNotNullAndThanEqualZero(param.getTimes());
        RetInfo retInfo = new RetInfo();
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            SysMediaPutPlan sysMediaPutPlan = mediaPutPlanService.queryMediaPutPlan(param.getPlanId());
            /*
             * 1、计算更新媒体计划余额
             * 判断增加量小于等于余 额
             */
            BigDecimal quota = sysMediaPutPlan.getQuota();
            BigDecimal addAmount = quota.multiply(new BigDecimal(param.getTimes())).setScale(2,BigDecimal.ROUND_HALF_UP);
            Date currTime = new Date();
            long addBalance = addAmount.multiply(new BigDecimal(100)).longValue();
            BigDecimal beforeBalance = sysMediaPutPlan.getBalance();
            BigDecimal afterAmount = beforeBalance.add(addAmount).setScale(2,BigDecimal.ROUND_HALF_UP);
            SysMediaPutPlan mediaPutPlan = new SysMediaPutPlan();
            mediaPutPlan.setUpdateTime(currTime);
            mediaPutPlan.setMediaPlanId(param.getPlanId());
            mediaPutPlan.setBalance(afterAmount);
            mediaPutPlan.setStatus(CommonConstant.STANDARD_ONE);
            mediaPutPlanService.updateMediaPutPlan(mediaPutPlan);
            /*
             * 2、计算新增充值记录
             */
            TokenUserVO tokenUserVO = (TokenUserVO) redisClient.get(token,TokenUserVO.class);
            SysPlanRecharge planRecharge = new SysPlanRecharge();
            planRecharge.setPlanRechargeNo(String.valueOf(currTime.getTime()));
            planRecharge.setCreateTime(currTime);
            planRecharge.setAdvertPlanId(sysMediaPutPlan.getMediaPlanId());
            planRecharge.setAdvertId(sysMediaPutPlan.getMediaId());
            planRecharge.setCreator(tokenUserVO.getUserId());
            planRecharge.setTimes(param.getTimes());
            planRecharge.setBelongType(CommonConstant.STANDARD_TWO);
            planRecharge.setQuota(quota);
            planRecharge.setBeforeBalance(beforeBalance);
            planRecharge.setAfterBalance(afterAmount);
            planRechargeService.savePlanRecharge(planRecharge);
            retInfo.setResultCodes(ResultCodes.SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            throw new GlobalException(ResultCodes.FAILED);
        }finally {
            lock.unlock();
        }
        log.info("===mediaPlanRecharge end===");
        return retInfo;
    }

    @Override
    public RetInfo mediaQueryAdvertList(MediaQryAdvertListParam param) {
        log.info("===mediaQueryAdvertList begin===" + param);
        RetInfo retInfo = new RetInfo();
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validParamStrNotNull(param.getShowCode());
        /*
         * 根据media_key 和 广告类型
         * 查询对应的媒体
         */
        SysMediaInfoExample example = new SysMediaInfoExample();
        SysMediaInfoExample.Criteria criteria = example.createCriteria();
        criteria.andAdvertShowTypeEqualTo(param.getShowCode());
        criteria.andStatusEqualTo(CommonConstant.STANDARD_ONE);
        criteria.andMediaKeyEqualTo(param.getAccessId());
        List<SysMediaInfo> sysMediaInfos = mediaInfoService.queryMediaInfoList(example);
        if (sysMediaInfos != null && !sysMediaInfos.isEmpty()){
            List<String> mediaIds = new ArrayList<>(sysMediaInfos.size());
            sysMediaInfos.forEach(sysMediaInfo -> mediaIds.add(sysMediaInfo.getMediaId()));
            SysMediaPutPlanExample planExample = new SysMediaPutPlanExample();
            SysMediaPutPlanExample.Criteria planCriteria = planExample.createCriteria();
            planCriteria.andMediaIdIn(mediaIds);
            planCriteria.andStatusEqualTo(CommonConstant.STANDARD_ONE);
            List<SysMediaPutPlan> mediaPutPlanList = mediaPutPlanService.queryMediaPutPlan(planExample);
            if (mediaPutPlanList != null && !mediaPutPlanList.isEmpty()){
                List<String> planIds = new ArrayList<>(mediaPutPlanList.size());
                mediaPutPlanList.forEach( sysMediaPutPlan -> planIds.add(sysMediaPutPlan.getMediaPlanId()));
                SysMediaAdvertPutExample advertPutExample = new SysMediaAdvertPutExample();
                SysMediaAdvertPutExample.Criteria advertPutCriteria = advertPutExample.createCriteria();
                advertPutCriteria.andMediaPlanIdIn(planIds);
                advertPutCriteria.andStatusEqualTo(CommonConstant.STANDARD_ONE);
                List<SysMediaAdvertPut> mediaAdvertPutList = mediaAdvertPutService.queryByExample(advertPutExample);
                /*
                 * 根据广告Id查询广告信息
                 */
                if (mediaAdvertPutList != null && !mediaAdvertPutList.isEmpty()){
                    List<MediaAdvertVO> mediaAdvertVOS = new ArrayList<>(mediaAdvertPutList.size());
                    for (SysMediaAdvertPut mediaAdvertPut : mediaAdvertPutList){
                        MediaAdvertVO mediaAdvertVO = new MediaAdvertVO();
                        BeanUtils.copyProperties(mediaAdvertPut,mediaAdvertVO);
                        mediaAdvertVO.setPlanId(mediaAdvertPut.getMediaPlanId());
                        mediaAdvertVOS.add(mediaAdvertVO);
                    }
                retInfo.setResultCodes(ResultCodes.SUCCESS);
                retInfo.setData(mediaAdvertVOS);
                }else {
                    retInfo.setResultCodes(ResultCodes.FAILED);
                    retInfo.setMessage("投放计划未激活");
                }
            }else {
                retInfo.setResultCodes(ResultCodes.FAILED);
                retInfo.setMessage("投放计划未激活");
            }
        }else {
            retInfo.setResultCodes(ResultCodes.FAILED);
            retInfo.setMessage("媒体不存在或没有投放中计划");
        }
        log.info("===mediaQueryAdvertList end===" + param);
        return retInfo;
    }

    /**
     * 浏览回写记录
     * 根据广告计划扣钱
     * 根据媒体计划扣钱
     * @param param 参数
     * @return 结果
     */
    @Override
    public RetInfo mediaWriterBackShowRecord(MediaWriterParam param) {
        log.info("===mediaWriterBackShowRecord begin===" + param);
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validParamStrNotNull(param.getAdvertId());
        ParamCheckUtil.validParamStrNotNull(param.getAccessId());
        ParamCheckUtil.validParamStrNotNull(param.getPlanId());
        RetInfo retInfo = new RetInfo();
        SysAdvertPlayRecord record = new SysAdvertPlayRecord();
        record.setCreateTime(new Date());
        record.setNum(CommonConstant.STANDARD_ONE);
        record.setPlayType(CommonConstant.STANDARD_ZERO);
        record.setAdvertId(param.getAdvertId());
        record.setMediaOwnKey(param.getAccessId());
        record.setPlanId(param.getPlanId());
        playRecordService.savePlayRecord(record);
        checkAdvertPlanBalance(param.getAdvertId());
        checkMediaPlanBalance(param.getPlanId());
        retInfo.setResultCodes(ResultCodes.SUCCESS);
        log.info("===mediaWriterBackShowRecord end===");
        return retInfo;
    }

    @Override
    public RetInfo mediaWriterBackClickRecord(MediaWriterParam param) {
        log.info("===mediaWriterBackClickRecord begin===" + param);
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validParamStrNotNull(param.getAdvertId());
        ParamCheckUtil.validParamStrNotNull(param.getAccessId());
        RetInfo retInfo = new RetInfo();
        SysAdvertPlayRecord record = new SysAdvertPlayRecord();
        record.setCreateTime(new Date());
        record.setNum(CommonConstant.STANDARD_ONE);
        record.setPlayType(CommonConstant.STANDARD_ONE);
        record.setAdvertId(param.getAdvertId());
        record.setMediaOwnKey(param.getAccessId());
        record.setPlanId(param.getPlanId());
        playRecordService.savePlayRecord(record);
        checkAdvertPlanBalance(param.getAdvertId());
        checkMediaPlanBalance(param.getPlanId());
        retInfo.setResultCodes(ResultCodes.SUCCESS);
        log.info("===mediaWriterBackClickRecord end===");
        return retInfo;
    }


    private Map<String,String> queryAndConvertMediaType(List<Long> ids){
        if (ids != null && !ids.isEmpty()){
            SysMediaTypeExample example = new SysMediaTypeExample();
            SysMediaTypeExample.Criteria criteria = example.createCriteria();
            criteria.andMediaTypeIdIn(ids);
            List<SysMediaType> mediaTypeList = mediaTypeService.queryMediaTypeByExample(example);
            if (mediaTypeList != null && !mediaTypeList.isEmpty()){
                Map<String,String> mediaTypeMap = new HashMap<>(16);
                mediaTypeList.forEach(sysMediaType -> {
                    mediaTypeMap.put(sysMediaType.getMediaTypeId().toString(),sysMediaType.getMediaTypeName());
                });
                return mediaTypeMap;
            }
        }
        return null;
    }

    private Map<String,String> queryAndConvertShowType(List<String> showTypeIds){
        if (showTypeIds != null && !showTypeIds.isEmpty()) {
            SysAdvertShowTypeExample example = new SysAdvertShowTypeExample();
            example.setDistinct(true);
            SysAdvertShowTypeExample.Criteria criteria = example.createCriteria();
            criteria.andShowCodeIn(showTypeIds);
            List<SysAdvertShowType> sysAdvertShowTypeList = advertShowTypeService.queryByExample(example);
            if (sysAdvertShowTypeList != null && !sysAdvertShowTypeList.isEmpty()){
                Map<String, String> showTypeMap = new HashMap<>(16);
                for (SysAdvertShowType sysAdvertShowType : sysAdvertShowTypeList) {
                    showTypeMap.put(sysAdvertShowType.getShowCode(), sysAdvertShowType.getShowName());
                }
                return showTypeMap;
            }
        }
        return null;
    }

    /**
     * 扣减广告计划余额
     */
    private void subAdvertPlanBalance(SysAdvertPutPlan advertPutPlan){
        SysAdvertPutPlan adPutPlanTemp = new SysAdvertPutPlan();
        BigDecimal balance = advertPutPlan.getBalance();
        BigDecimal subBalance = advertPutPlan.getPrice().multiply(advertPutPlan.getSettleExpansivity()).setScale(2,BigDecimal.ROUND_HALF_UP);
        adPutPlanTemp.setAdvertPlanId(advertPutPlan.getAdvertPlanId());
        adPutPlanTemp.setUpdateTime(new Date());
        if (balance.compareTo(subBalance) == -1){
            adPutPlanTemp.setStatus(CommonConstant.STANDARD_TWO);
        }
        adPutPlanTemp.setBalance(balance.subtract(subBalance));
        advertPutPlanService.updateAdvertPutPlan(adPutPlanTemp);
    }

    private void checkAdvertPlanBalance(String advertId){
        SysAdvertPutPlan advertPutPlan = advertPutPlanService.queryPutPlanByAdvertId(advertId);
        if (advertPutPlan != null){
            Lock lock = new ReentrantLock();
            lock.lock();
            try {
                if ("cpc".equals(advertPutPlan.getBillingType())){
                    subAdvertPlanBalance(advertPutPlan);
                }
                if ("cpm".equals(advertPutPlan.getBillingType())){
                    int num = playRecordService.countPlayByAdvertDay(advertId);
                    if ( num % 1000 == 0){
                        subAdvertPlanBalance(advertPutPlan);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
                log.error("===计费广告扣减余额异常===");
            }finally {
                lock.unlock();
            }
        }else {
            log.info("===浏览回写根据广告Id没有查到广告计划===");
        }
    }

    private void checkMediaPlanBalance(String planId){
        SysMediaPutPlan mediaPutPlan = mediaPutPlanService.queryMediaPutPlan(planId);
        if (mediaPutPlan != null){
            Lock lock = new ReentrantLock();
            lock.lock();
            try {
                if ("cpc".equals(mediaPutPlan.getBillingType())){
                    subMediaPlanBalance(mediaPutPlan);
                }
                if ("cpm".equals(mediaPutPlan.getBillingType())){
                    int num = playRecordService.countPlayByAdvertDay(planId);
                    if ( num % 1000 == 0){
                        subMediaPlanBalance(mediaPutPlan);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
                log.error("===计费媒体扣减余额异常===");
            }finally {
                lock.unlock();
            }
        }else {
            log.info("===浏览回写根据计划id没有查到媒体计划===");
        }
    }

    private void subMediaPlanBalance(SysMediaPutPlan mediaPutPlan){
        SysMediaPutPlan mdPutPlanTemp = new SysMediaPutPlan();
        BigDecimal balance = mediaPutPlan.getBalance();
        BigDecimal subBalance = mediaPutPlan.getPrice().multiply(mediaPutPlan.getSettleExpansivity()).setScale(2,BigDecimal.ROUND_HALF_UP);
        mdPutPlanTemp.setMediaPlanId(mediaPutPlan.getMediaPlanId());
        mdPutPlanTemp.setUpdateTime(new Date());
        if (balance.compareTo(subBalance) == -1){
            mdPutPlanTemp.setStatus(CommonConstant.STANDARD_TWO);
        }
        mdPutPlanTemp.setBalance(balance.subtract(subBalance));
        mediaPutPlanService.updateMediaPutPlan(mdPutPlanTemp);
    }
}
