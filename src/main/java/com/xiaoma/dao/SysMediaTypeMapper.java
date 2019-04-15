package com.xiaoma.dao;

import com.xiaoma.bean.bo.SysMediaTypeExample;
import com.xiaoma.bean.po.SysMediaType;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMediaTypeMapper {
    int countByExample(SysMediaTypeExample example);

    int insert(SysMediaType record);

    int insertSelective(SysMediaType record);

    List<SysMediaType> selectByExample(SysMediaTypeExample example);

    SysMediaType selectByPrimaryKey(Long mediaTypeId);

    int updateByExampleSelective(@Param("record") SysMediaType record, @Param("example") SysMediaTypeExample example);

    int updateByExample(@Param("record") SysMediaType record, @Param("example") SysMediaTypeExample example);

    int updateByPrimaryKeySelective(SysMediaType record);

    int updateByPrimaryKey(SysMediaType record);
}