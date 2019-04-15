package com.xiaoma.service.base.impl;

import com.xiaoma.bean.bo.SysAccountSettleRecordExample;
import com.xiaoma.bean.po.SysAccountSettleRecord;
import com.xiaoma.bean.vo.AdvertiserSettleVO;
import com.xiaoma.dao.SysAccountSettleRecordMapper;
import com.xiaoma.service.base.SettleService;
import com.xiaoma.service.core.SettleCoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/8.
 */
@Service
public class SettleServiceImpl implements SettleService {

    @Autowired
    private SysAccountSettleRecordMapper settleRecordMapper;


    @Override
    public int countSettle(SysAccountSettleRecordExample example) {
        return settleRecordMapper.countByExample(example);
    }

    @Override
    public List<SysAccountSettleRecord> querySettleRecordList(SysAccountSettleRecordExample example) {
        return settleRecordMapper.selectByExample(example);
    }

    @Override
    public int saveSettleInfo(SysAccountSettleRecord record) {
        return settleRecordMapper.insert(record);
    }

    @Override
    public int updateSettleInfo(SysAccountSettleRecord record) {
        return settleRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int batchSaveRecord(List<SysAccountSettleRecord> records) {
        return settleRecordMapper.insertSettleList(records);
    }

    @Override
    public BigDecimal countTotalEarngings(String userId) {
        return settleRecordMapper.countTotalEarngings(userId) == null ? new BigDecimal(0) : settleRecordMapper.countTotalEarngings(userId);
    }

    @Override
    public BigDecimal countCurrentEarnings(String userId) {
        return settleRecordMapper.countCurrentEarnings(userId) == null ? new BigDecimal(0) : settleRecordMapper.countCurrentEarnings(userId);
    }

    @Override
    public List<AdvertiserSettleVO> queryAdvertiserSettleList(Map paramMap) {
        return settleRecordMapper.selectAdvertiserList(paramMap);
    }
}
