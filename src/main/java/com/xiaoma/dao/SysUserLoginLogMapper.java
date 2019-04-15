package com.xiaoma.dao;

import com.xiaoma.bean.bo.SysUserLoginLogExample;
import com.xiaoma.bean.po.SysUserLoginLog;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserLoginLogMapper {
    int countByExample(SysUserLoginLogExample example);

    int deleteByExample(SysUserLoginLogExample example);

    int deleteByPrimaryKey(Long loginId);

    int insert(SysUserLoginLog record);

    int insertSelective(SysUserLoginLog record);

    List<SysUserLoginLog> selectByExample(SysUserLoginLogExample example);

    SysUserLoginLog selectByPrimaryKey(Long loginId);

    int updateByExampleSelective(@Param("record") SysUserLoginLog record, @Param("example") SysUserLoginLogExample example);

    int updateByExample(@Param("record") SysUserLoginLog record, @Param("example") SysUserLoginLogExample example);

    int updateByPrimaryKeySelective(SysUserLoginLog record);

    int updateByPrimaryKey(SysUserLoginLog record);
}