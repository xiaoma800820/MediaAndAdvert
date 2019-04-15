package com.xiaoma.service.core.impl;

import com.xiaoma.bean.bo.SysAccountRechargeRecordExample;
import com.xiaoma.bean.dto.RechargeParam;
import com.xiaoma.bean.po.SysAccountRechargeRecord;
import com.xiaoma.bean.po.SysUserAdvertisers;
import com.xiaoma.bean.vo.RechargeVO;
import com.xiaoma.service.base.RechargerService;
import com.xiaoma.service.base.UserAdvertiserService;
import com.xiaoma.service.core.RechargeCoreService;
import com.xiaoma.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.*;

/**
 * 充值核心业务逻辑实现
 * @author mmh
 * @date 2019/3/25
 */
@Slf4j
@Service
public class RechargeCoreServiceImpl implements RechargeCoreService {


    @Autowired
    private UserAdvertiserService advertiserService;
    @Autowired
    private RechargerService rechargerService;


    @Transactional
    @Override
    public RetInfo rechargeUserAccount(RechargeParam param) {
        log.info("===rechargeUserAccount begin ===" + param);
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validParamStrNotNull(param.getAdvertiserId());
        ParamCheckUtil.validParamNotNullAndThanZero(param.getRechargeNum());
        SysUserAdvertisers advertisers = advertiserService.queryAdvertiserById(param.getAdvertiserId());
        long balance = advertisers.getAccountBalance() + param.getRechargeNum();
        Date updateTime = new Date();
        SysUserAdvertisers advertisersTemp = new SysUserAdvertisers();
        advertisersTemp.setAdvertiserId(advertisers.getAdvertiserId());
        advertisersTemp.setAccountBalance(balance);
        advertisersTemp.setUpdateTime(updateTime);
        advertiserService.updateAdvertisersById(advertisersTemp);
        SysAccountRechargeRecord rechargeRecord = new SysAccountRechargeRecord();
        rechargeRecord.setAdvertiserId(advertisers.getAdvertiserId());
        rechargeRecord.setAdvertiserPhone(advertisers.getAdvertiserPhone());
        rechargeRecord.setCreateTime(updateTime);
        rechargeRecord.setCreateYmd(XmDateUtil.dateFormat(updateTime,XmDateUtil.DATE_FORMAT_YMD));
        BigDecimal beforeBalance = new BigDecimal(advertisers.getAccountBalance()/100).setScale(2,BigDecimal.ROUND_HALF_UP);
        rechargeRecord.setRechargeBefore(beforeBalance);
        rechargeRecord.setRechargeBack(new BigDecimal(balance/100).setScale(2,BigDecimal.ROUND_HALF_UP));
        rechargeRecord.setRechargeNum(new BigDecimal(param.getRechargeNum()/100).setScale(2,BigDecimal.ROUND_HALF_UP));
        String billNo = updateTime.getTime() + "" +CommonConstant.getRandRangeNumBer(3);
        rechargeRecord.setBillNo(billNo);
        rechargerService.saveRechargeRecord(rechargeRecord);
        RetInfo retInfo = new RetInfo();
        retInfo.setResultCodes(ResultCodes.SUCCESS);
        log.info("===rechargeUserAccount end ===");
        return retInfo;
    }

    @Override
    public RetInfo rechargeQryRecordList(PageInfo pageInfo) {
        log.info("===rechargeQryRecordList begin===");
        RetInfo retInfo = new RetInfo();
        BigDecimal rechargeTotal = rechargerService.countRechargeAmount(null);
        /*
         * 单号、日期、金额、id、帐号
         */
        SysAccountRechargeRecordExample example = new SysAccountRechargeRecordExample();
//        SysAccountRechargeRecordExample.Criteria criteria = example.createCriteria();
        int totalRow = rechargerService.countQryRecord(example);
        if (totalRow > CommonConstant.STANDARD_ZERO){
            PageUtil pageUtil = new PageUtil(pageInfo.getPageSize(),pageInfo.getPageNo());
            pageUtil.setTotalCount(totalRow);
            example.setOrderByClause(" create_time DESC " + pageUtil.getLimitCriterion());
            List<SysAccountRechargeRecord> rechargeRecords = rechargerService.queryRecordList(example);
            if (rechargeRecords != null && !rechargeRecords.isEmpty()){
                List<RechargeVO> rechargeVOS = new ArrayList<>(rechargeRecords.size());
                for (SysAccountRechargeRecord rechargeRecord : rechargeRecords){
                    RechargeVO rechargeVO = new RechargeVO();
                    BeanUtils.copyProperties(rechargeRecord,rechargeVO);
                    rechargeVOS.add(rechargeVO);
                }
                retInfo.setResultCodes(ResultCodes.SUCCESS);
                retInfo.setPages(pageUtil.getTotalPages());
                Map<String,Object> resultMap = new HashMap<>(4);
                resultMap.put("list",rechargeVOS);
                resultMap.put("totalAmount",rechargeTotal);
                retInfo.setData(resultMap);
            }else {
                retInfo.setResultCodes(ResultCodes.SUCCESS);
                retInfo.setMessage("未查到充值信息");
            }
        }else {
            retInfo.setResultCodes(ResultCodes.SUCCESS);
            retInfo.setMessage("未查到充值信息");
        }
        log.info("===rechargeQryRecordList end===");
        return retInfo;
    }
}
