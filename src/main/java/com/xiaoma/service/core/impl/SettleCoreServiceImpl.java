package com.xiaoma.service.core.impl;

import com.xiaoma.bean.bo.SysAccountRechargeRecordExample;
import com.xiaoma.bean.bo.SysAccountSettleRecordExample;
import com.xiaoma.bean.bo.SysUserMediaOwnerExample;
import com.xiaoma.bean.dto.MediaOwnerQryParam;
import com.xiaoma.bean.dto.SettleParam;
import com.xiaoma.bean.po.SysAccountSettleRecord;
import com.xiaoma.bean.po.SysUserAdvertisers;
import com.xiaoma.bean.po.SysUserMediaOwner;
import com.xiaoma.bean.vo.AdvertiserSettleVO;
import com.xiaoma.bean.vo.MediaSettleVO;
import com.xiaoma.bean.vo.SettleHasVO;
import com.xiaoma.bean.vo.TokenUserVO;
import com.xiaoma.service.base.*;
import com.xiaoma.service.core.SettleCoreService;
import com.xiaoma.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/8.
 */
@Slf4j
@Service
public class SettleCoreServiceImpl implements SettleCoreService {


    @Autowired
    private SettleService settleService;
    @Autowired
    private UserAdvertiserService advertiserService;
    @Autowired
    private RechargerService rechargerService;
    @Autowired
    private RedisClient redisClient;

    @Override
    public RetInfo querySettleList(PageInfo pageInfo) {
        log.info("===querySettleList begin ===");
        SysAccountSettleRecordExample example = new SysAccountSettleRecordExample();
        SysAccountSettleRecordExample.Criteria criteria = example.createCriteria();
        //1是已结算，0是未结算
        criteria.andStatusEqualTo(CommonConstant.STANDARD_ONE);
        int totalRow = settleService.countSettle(example);
        RetInfo retInfo = new RetInfo();
        if (totalRow > CommonConstant.STANDARD_ZERO){
            PageUtil pageUtil = new PageUtil(pageInfo.getPageSize(),pageInfo.getPageNo());
            pageUtil.setTotalCount(totalRow);
            example.setOrderByClause(" create_time DESC " + pageUtil.getLimitCriterion());
            List<SysAccountSettleRecord> settleRecords = settleService.querySettleRecordList(example);
            if (settleRecords != null && !settleRecords.isEmpty()){
                List<SettleHasVO> settleHasVOS = new ArrayList<>(settleRecords.size());
                for (SysAccountSettleRecord accountSettleRecord : settleRecords){
                    SettleHasVO settleHasVO = new SettleHasVO();
                    BeanUtils.copyProperties(accountSettleRecord,settleHasVO);
                    settleHasVOS.add(settleHasVO);
                }
                BigDecimal totalNum = settleService.countTotalEarngings(null);
                BigDecimal currentNum = settleService.countCurrentEarnings(null);
                HashMap resultMap = new HashMap(4);
                resultMap.put("resultList",settleHasVOS);
                resultMap.put("totalEarnings",totalNum);
                resultMap.put("currentEarnings",currentNum);
                retInfo.setResultCodes(ResultCodes.SUCCESS);
                retInfo.setData(resultMap);
                retInfo.setPages(pageUtil.getTotalPages());
            }else {
                retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
                retInfo.setMessage("查询无数据");
            }
        }else {
            retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
            retInfo.setMessage("查询无数据");
        }
        log.info("===querySettleList end ===");
        return retInfo;
    }

    @Override
    public RetInfo queryWaitSettleList(MediaOwnerQryParam param) {
        log.info("===queryWaitSettleList begin ===" + param);
        RetInfo retInfo = new RetInfo();
        SysAccountSettleRecordExample example = new SysAccountSettleRecordExample();
        SysAccountSettleRecordExample.Criteria criteria = example.createCriteria();
        //1是已结算，0是未结算
        criteria.andStatusEqualTo(CommonConstant.STANDARD_ONE);
        if (param.getMediaPhone() != null && !StringUtils.isEmpty(param.getMediaPhone())){
            criteria.andUserNameEqualTo(param.getMediaPhone());
        }
        int totalRow = settleService.countSettle(example);
        if (totalRow > CommonConstant.STANDARD_ZERO){
            PageUtil pageUtil = new PageUtil(param.getPageSize(),param.getPageNo());
            pageUtil.setTotalCount(totalRow);
            example.setOrderByClause(" create_time DESC " + pageUtil.getLimitCriterion());
            List<SysAccountSettleRecord> settleRecords = settleService.querySettleRecordList(example);
            if (settleRecords != null && !settleRecords.isEmpty()){
                List<SettleHasVO> settleHasVOS = new ArrayList<>(settleRecords.size());
                for (SysAccountSettleRecord accountSettleRecord : settleRecords){
                    SettleHasVO settleHasVO = new SettleHasVO();
                    BeanUtils.copyProperties(accountSettleRecord,settleHasVO);
                    settleHasVOS.add(settleHasVO);
                }
                retInfo.setResultCodes(ResultCodes.SUCCESS);
                retInfo.setData(settleHasVOS);
                retInfo.setPages(pageUtil.getTotalPages());
            }else {
                retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
                retInfo.setMessage("查询无数据");
            }
        }else {
            retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
            retInfo.setMessage("查询无数据");
        }
        log.info("===queryWaitSettleList end ===");
        return retInfo;
    }

    @Override
    public RetInfo finishSettle(SettleParam param) {
        log.info("===finishSettle begin===" + param);
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validParamObjectNull(param.getSettleIdS());
        List<Long> settleIDS = param.getSettleIdS();
        RetInfo retInfo = new RetInfo();
        if (settleIDS != null && settleIDS.size()> 0){
            for (Long settleId : settleIDS){
                SysAccountSettleRecord record = new SysAccountSettleRecord();
                record.setAccountSettleId(settleId);
                record.setStatus(CommonConstant.STANDARD_ZERO);
                settleService.updateSettleInfo(record);
            }
            retInfo.setResultCodes(ResultCodes.SUCCESS);
        }else {
            retInfo.setResultCodes(ResultCodes.FAILED);
            retInfo.setMessage("参数为空");
        }
        log.info("===finishSettle end===");
        return retInfo;
    }

    @Override
    public RetInfo queryMediaSettleList(PageInfo pageInfo, String token) {
        log.info("===queryMediaSettleList begin===" + pageInfo);
        TokenUserVO tokenUserVO = (TokenUserVO) redisClient.get(token, TokenUserVO.class);
        SysAccountSettleRecordExample example = new SysAccountSettleRecordExample();
        SysAccountSettleRecordExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(tokenUserVO.getUserId());
        RetInfo retInfo = new RetInfo();
        int totalRow = settleService.countSettle(example);
        if (totalRow > CommonConstant.STANDARD_ZERO){
            PageUtil pageUtil = new PageUtil(pageInfo.getPageSize(),pageInfo.getPageNo());
            pageUtil.setTotalCount(totalRow);
            example.setOrderByClause(" create_time DESC " + pageUtil.getLimitCriterion());
            List<SysAccountSettleRecord> settleRecords = settleService.querySettleRecordList(example);
            if (settleRecords != null && settleRecords.size() > 0){
                List<MediaSettleVO> settleVOS = new ArrayList<>(settleRecords.size());
                for (SysAccountSettleRecord accountSettleRecord : settleRecords){
                    MediaSettleVO mediaSettleVO = new MediaSettleVO();
                    BeanUtils.copyProperties(accountSettleRecord,mediaSettleVO);
                    settleVOS.add(mediaSettleVO);
                }
                BigDecimal totalEarnings = settleService.countTotalEarngings(tokenUserVO.getUserId());
                BigDecimal currentEarnings = settleService.countCurrentEarnings(tokenUserVO.getUserId());
                retInfo.setResultCodes(ResultCodes.SUCCESS);
                retInfo.setPages(pageUtil.getTotalPages());
                HashMap resultMap = new HashMap(4);
                resultMap.put("resultList",settleVOS);
                resultMap.put("totalEarnings",totalEarnings);
                resultMap.put("currentEarnings",currentEarnings);
                retInfo.setData(resultMap);
            }else {
                retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
            }
        }else {
            retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
        }
        log.info("===queryMediaSettleList end===");
        return retInfo;
    }

    @Override
    public RetInfo queryAdvertSettleList(PageInfo pageInfo, String token) {
        log.info("===queryAdvertSettleList begin===" + pageInfo);
        TokenUserVO tokenUserVO = (TokenUserVO) redisClient.get(token, TokenUserVO.class);
        SysUserAdvertisers advertisers = advertiserService.queryAdvertiserById(tokenUserVO.getUserId());
        //余额
        BigDecimal balance = new BigDecimal(advertisers.getAccountBalance()).divide(new BigDecimal(100),BigDecimal.ROUND_HALF_UP);
        BigDecimal totalPlanRecharge = rechargerService.countRechargeAmount(tokenUserVO.getUserId());
        BigDecimal totalSettle = settleService.countTotalEarngings(tokenUserVO.getUserId());

        SysAccountSettleRecordExample example = new SysAccountSettleRecordExample();
        SysAccountSettleRecordExample.Criteria criteria = example.createCriteria();
        //1是已结算，0是未结算
        criteria.andStatusEqualTo(CommonConstant.STANDARD_ONE);
        criteria.andUserIdEqualTo(tokenUserVO.getUserId());
        int totalRow1 = settleService.countSettle(example);
        SysAccountRechargeRecordExample example1 = new SysAccountRechargeRecordExample();
        SysAccountRechargeRecordExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andAdvertiserIdEqualTo(tokenUserVO.getUserId());
        int totalRow2 = rechargerService.countQryRecord(example1);
        RetInfo retInfo = new RetInfo();
        if (totalRow1 > 0 || totalRow2 > 0){
            PageUtil pageUtil = new PageUtil(pageInfo.getPageSize(),pageInfo.getPageNo());
            pageUtil.setTotalCount(totalRow1 + totalRow2);
            String limitStr = pageUtil.getLimitCriterion();
            Map<String,String> paramMap = new HashMap<>(4);
            paramMap.put("userId",tokenUserVO.getUserId());
            paramMap.put("limitStr",limitStr);
            List<AdvertiserSettleVO> advertiserSettleVOS = settleService.queryAdvertiserSettleList(paramMap);
            Map<String, Object> resultMap = new HashMap<>();
            resultMap.put("balance",balance);
            resultMap.put("totalPlanRecharge",totalPlanRecharge);
            resultMap.put("totalExpenditure",totalSettle);
            resultMap.put("resultList",advertiserSettleVOS);
            retInfo.setResultCodes(ResultCodes.SUCCESS);
            retInfo.setData(resultMap);
            retInfo.setPages(pageUtil.getTotalPages());
        }else {
            retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
        }
        log.info("===queryAdvertSettleList end===");
        return retInfo;
    }
}
