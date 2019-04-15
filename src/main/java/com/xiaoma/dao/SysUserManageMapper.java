package com.xiaoma.dao;

import com.xiaoma.bean.bo.SysUserManageExample;
import com.xiaoma.bean.po.SysUserManage;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserManageMapper {
    int countByExample(SysUserManageExample example);

    int deleteByExample(SysUserManageExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(SysUserManage record);

    int insertSelective(SysUserManage record);

    List<SysUserManage> selectByExample(SysUserManageExample example);

    SysUserManage selectByPrimaryKey(Integer userId);

    SysUserManage selectByPhoneNo(String phoneNo);

    int updateByExampleSelective(@Param("record") SysUserManage record, @Param("example") SysUserManageExample example);


    int updateByExample(@Param("record") SysUserManage record, @Param("example") SysUserManageExample example);

    int updateByPrimaryKeySelective(SysUserManage record);

    int updateByPrimaryKey(SysUserManage record);
}