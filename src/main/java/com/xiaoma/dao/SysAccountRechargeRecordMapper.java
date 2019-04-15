package com.xiaoma.dao;

import com.xiaoma.bean.bo.SysAccountRechargeRecordExample;
import com.xiaoma.bean.po.SysAccountRechargeRecord;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAccountRechargeRecordMapper {
    int countByExample(SysAccountRechargeRecordExample example);

    int deleteByExample(SysAccountRechargeRecordExample example);

    int deleteByPrimaryKey(Long rechargeId);

    int insert(SysAccountRechargeRecord record);

    int insertSelective(SysAccountRechargeRecord record);

    List<SysAccountRechargeRecord> selectByExample(SysAccountRechargeRecordExample example);

    SysAccountRechargeRecord selectByPrimaryKey(Long rechargeId);

    int updateByExampleSelective(@Param("record") SysAccountRechargeRecord record, @Param("example") SysAccountRechargeRecordExample example);

    int updateByExample(@Param("record") SysAccountRechargeRecord record, @Param("example") SysAccountRechargeRecordExample example);

    int updateByPrimaryKeySelective(SysAccountRechargeRecord record);

    int updateByPrimaryKey(SysAccountRechargeRecord record);

    BigDecimal countRechargeAmount(String userId);
}