package com.xiaoma.dao;

import com.xiaoma.bean.bo.SysMediaPutPlanExample;
import com.xiaoma.bean.po.SysMediaPutPlan;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMediaPutPlanMapper {
    int countByExample(SysMediaPutPlanExample example);

    int insert(SysMediaPutPlan record);

    int insertSelective(SysMediaPutPlan record);

    List<SysMediaPutPlan> selectByExample(SysMediaPutPlanExample example);

    SysMediaPutPlan selectByPrimaryKey(String mediaPlanId);

    int updateByExampleSelective(@Param("record") SysMediaPutPlan record, @Param("example") SysMediaPutPlanExample example);

    int updateByExample(@Param("record") SysMediaPutPlan record, @Param("example") SysMediaPutPlanExample example);

    int updateByPrimaryKeySelective(SysMediaPutPlan record);

    int updateByPrimaryKey(SysMediaPutPlan record);
}