package com.xiaoma.service.base.impl;

import com.xiaoma.bean.bo.SysAccountRechargeRecordExample;
import com.xiaoma.bean.po.SysAccountRechargeRecord;
import com.xiaoma.dao.SysAccountRechargeRecordMapper;
import com.xiaoma.service.base.RechargerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 充值领域级业务实现类
 * @author mmh
 * @date 2019/3/25
 */
@Service
public class RechargerServiceImpl implements RechargerService {


    @Autowired
    SysAccountRechargeRecordMapper sysAccountRechargeRecordMapper;


    @Override
    public int saveRechargeRecord(SysAccountRechargeRecord rechargeRecord) {
        return sysAccountRechargeRecordMapper.insert(rechargeRecord);
    }

    @Override
    public int countQryRecord(SysAccountRechargeRecordExample example) {
        return sysAccountRechargeRecordMapper.countByExample(example);
    }

    @Override
    public List<SysAccountRechargeRecord> queryRecordList(SysAccountRechargeRecordExample example) {
        return sysAccountRechargeRecordMapper.selectByExample(example);
    }

    @Override
    public BigDecimal countRechargeAmount(String userId) {
        return sysAccountRechargeRecordMapper.countRechargeAmount(userId) == null ? new BigDecimal(0): sysAccountRechargeRecordMapper.countRechargeAmount(userId);

    }
}
