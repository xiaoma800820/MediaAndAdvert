package com.xiaoma.dao;

import com.xiaoma.bean.bo.SysAdvertShowTypeExample;
import com.xiaoma.bean.po.SysAdvertShowType;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAdvertShowTypeMapper {

    int countByExample(SysAdvertShowTypeExample example);

    int insert(SysAdvertShowType record);

    int insertSelective(SysAdvertShowType record);

    List<SysAdvertShowType> selectByExample(SysAdvertShowTypeExample example);

    SysAdvertShowType selectByPrimaryKey(String advertShowId);

    int updateByExampleSelective(@Param("record") SysAdvertShowType record, @Param("example") SysAdvertShowTypeExample example);

    int updateByExample(@Param("record") SysAdvertShowType record, @Param("example") SysAdvertShowTypeExample example);

    int updateByPrimaryKeySelective(SysAdvertShowType record);

    int updateByPrimaryKey(SysAdvertShowType record);
}