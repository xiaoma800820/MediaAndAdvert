package com.xiaoma.dao;

import com.xiaoma.bean.bo.SysAdvertInfoExample;
import com.xiaoma.bean.po.SysAdvertInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAdvertInfoMapper {

    int countByExample(SysAdvertInfoExample example);

    int insert(SysAdvertInfo record);

    int insertSelective(SysAdvertInfo record);

    List<SysAdvertInfo> selectByExample(SysAdvertInfoExample example);

    SysAdvertInfo selectByPrimaryKey(String advertId);

    int updateByExampleSelective(@Param("record") SysAdvertInfo record, @Param("example") SysAdvertInfoExample example);

    int updateByExample(@Param("record") SysAdvertInfo record, @Param("example") SysAdvertInfoExample example);

    int updateByPrimaryKeySelective(SysAdvertInfo record);

    int updateByPrimaryKey(SysAdvertInfo record);
}