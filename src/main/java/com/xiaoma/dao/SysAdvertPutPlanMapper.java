package com.xiaoma.dao;

import com.xiaoma.bean.bo.SysAdvertPutPlanExample;
import com.xiaoma.bean.po.SysAdvertPutPlan;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAdvertPutPlanMapper {
    int countByExample(SysAdvertPutPlanExample example);

    int insert(SysAdvertPutPlan record);

    int insertSelective(SysAdvertPutPlan record);

    List<SysAdvertPutPlan> selectByExample(SysAdvertPutPlanExample example);

    SysAdvertPutPlan selectByPrimaryKey(String advertPlanId);

    SysAdvertPutPlan selectByAdvertId(String advertId);

    int updateByExampleSelective(@Param("record") SysAdvertPutPlan record, @Param("example") SysAdvertPutPlanExample example);

    int updateByExample(@Param("record") SysAdvertPutPlan record, @Param("example") SysAdvertPutPlanExample example);

    int updateByPrimaryKeySelective(SysAdvertPutPlan record);

    int updateByPrimaryKey(SysAdvertPutPlan record);
}