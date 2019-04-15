package com.xiaoma.dao;

import com.xiaoma.bean.bo.SysAccountSettleRecordExample;
import com.xiaoma.bean.po.SysAccountSettleRecord;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.xiaoma.bean.vo.AdvertiserSettleVO;
import org.apache.ibatis.annotations.Param;

public interface SysAccountSettleRecordMapper {

    int insertSettleList(List<SysAccountSettleRecord> records);

    int countByExample(SysAccountSettleRecordExample example);

    int insert(SysAccountSettleRecord record);

    int insertSelective(SysAccountSettleRecord record);

    List<SysAccountSettleRecord> selectByExample(SysAccountSettleRecordExample example);

    SysAccountSettleRecord selectByPrimaryKey(Long accountSettleId);

    int updateByExampleSelective(@Param("record") SysAccountSettleRecord record, @Param("example") SysAccountSettleRecordExample example);

    int updateByExample(@Param("record") SysAccountSettleRecord record, @Param("example") SysAccountSettleRecordExample example);

    int updateByPrimaryKeySelective(SysAccountSettleRecord record);

    int updateByPrimaryKey(SysAccountSettleRecord record);

    BigDecimal countTotalEarngings(String userId);

    BigDecimal countCurrentEarnings(String userId);

    List<AdvertiserSettleVO> selectAdvertiserList(Map paramMap);
}