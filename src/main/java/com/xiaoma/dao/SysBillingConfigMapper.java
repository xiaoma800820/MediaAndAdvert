package com.xiaoma.dao;

import com.xiaoma.bean.bo.SysBillingConfigExample;
import com.xiaoma.bean.po.SysBillingConfig;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysBillingConfigMapper {
    int countByExample(SysBillingConfigExample example);

    int deleteByExample(SysBillingConfigExample example);

    int deleteByPrimaryKey(String billingCode);

    int insert(SysBillingConfig record);

    int insertSelective(SysBillingConfig record);

    List<SysBillingConfig> selectByExample(SysBillingConfigExample example);

    SysBillingConfig selectByPrimaryKey(String billingCode);

    int updateByExampleSelective(@Param("record") SysBillingConfig record, @Param("example") SysBillingConfigExample example);

    int updateByExample(@Param("record") SysBillingConfig record, @Param("example") SysBillingConfigExample example);

    int updateByPrimaryKeySelective(SysBillingConfig record);

    int updateByPrimaryKey(SysBillingConfig record);
}