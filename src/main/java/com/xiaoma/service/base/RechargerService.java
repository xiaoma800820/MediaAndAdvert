package com.xiaoma.service.base;

import com.xiaoma.bean.bo.SysAccountRechargeRecordExample;
import com.xiaoma.bean.po.SysAccountRechargeRecord;

import java.math.BigDecimal;
import java.util.List;

/**
 * 充值领域级业务接口
 * @author mmh
 * @date 2019/3/25
 */
public interface RechargerService {


    int saveRechargeRecord(SysAccountRechargeRecord rechargeRecord);

    int countQryRecord(SysAccountRechargeRecordExample example);

    List<SysAccountRechargeRecord> queryRecordList(SysAccountRechargeRecordExample example);

    BigDecimal countRechargeAmount(String userId);
}
