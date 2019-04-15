package com.xiaoma.dao;



import java.math.BigDecimal;
import java.util.List;

import com.xiaoma.bean.bo.SysPlanRechargeExample;
import com.xiaoma.bean.po.SysPlanRecharge;
import org.apache.ibatis.annotations.Param;

public interface SysPlanRechargeMapper {

    int countByExample(SysPlanRechargeExample example);

    int insert(SysPlanRecharge record);

    int insertSelective(SysPlanRecharge record);

    List<SysPlanRecharge> selectByExample(SysPlanRechargeExample example);

    SysPlanRecharge selectByPrimaryKey(String planRechargeNo);

    int updateByExampleSelective(@Param("record") SysPlanRecharge record, @Param("example") SysPlanRechargeExample example);

    int updateByExample(@Param("record") SysPlanRecharge record, @Param("example") SysPlanRechargeExample example);

    int updateByPrimaryKeySelective(SysPlanRecharge record);

    int updateByPrimaryKey(SysPlanRecharge record);

    BigDecimal countPlanRecharge(String userId);
}