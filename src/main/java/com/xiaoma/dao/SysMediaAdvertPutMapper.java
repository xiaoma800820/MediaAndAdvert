package com.xiaoma.dao;

import com.xiaoma.bean.bo.SysMediaAdvertPutExample;
import com.xiaoma.bean.po.SysMediaAdvertPut;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMediaAdvertPutMapper {
    int countByExample(SysMediaAdvertPutExample example);

    int insert(SysMediaAdvertPut record);

    int insertSelective(SysMediaAdvertPut record);

    List<SysMediaAdvertPut> selectByExample(SysMediaAdvertPutExample example);

    List<SysMediaAdvertPut> selectByPlanId(String planId);

    SysMediaAdvertPut selectByPrimaryKey(Long mediaAdvertId);

    int updateByExampleSelective(@Param("record") SysMediaAdvertPut record, @Param("example") SysMediaAdvertPutExample example);

    int updateByExample(@Param("record") SysMediaAdvertPut record, @Param("example") SysMediaAdvertPutExample example);

    int updateByPrimaryKeySelective(SysMediaAdvertPut record);

    int updateByPrimaryKey(SysMediaAdvertPut record);

    int insertByMediaAdvertPutList(List<SysMediaAdvertPut> sysMediaAdvertPuts);
}