package com.xiaoma.service.base;

import com.xiaoma.bean.bo.SysAccountSettleRecordExample;
import com.xiaoma.bean.po.SysAccountSettleRecord;
import com.xiaoma.bean.vo.AdvertiserSettleVO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/4/8.
 */
public interface SettleService {

    int countSettle(SysAccountSettleRecordExample example);

    List<SysAccountSettleRecord> querySettleRecordList(SysAccountSettleRecordExample example);

    int saveSettleInfo(SysAccountSettleRecord record);

    int updateSettleInfo(SysAccountSettleRecord record);

    int batchSaveRecord(List<SysAccountSettleRecord> records);

    BigDecimal countTotalEarngings(String userId);

    BigDecimal countCurrentEarnings(String userId);

    List<AdvertiserSettleVO> queryAdvertiserSettleList(Map paramMap);
}
