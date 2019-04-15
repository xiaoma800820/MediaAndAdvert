package com.xiaoma.dao;

import com.xiaoma.bean.bo.SysMediaInfoExample;
import com.xiaoma.bean.po.SysMediaInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysMediaInfoMapper {
    int countByExample(SysMediaInfoExample example);

    int insert(SysMediaInfo record);

    int insertSelective(SysMediaInfo record);

    List<SysMediaInfo> selectByExample(SysMediaInfoExample example);

    SysMediaInfo selectByPrimaryKey(String mediaId);

    int updateByExampleSelective(@Param("record") SysMediaInfo record, @Param("example") SysMediaInfoExample example);

    int updateByExample(@Param("record") SysMediaInfo record, @Param("example") SysMediaInfoExample example);

    int updateByPrimaryKeySelective(SysMediaInfo record);

    int updateByPrimaryKey(SysMediaInfo record);
}