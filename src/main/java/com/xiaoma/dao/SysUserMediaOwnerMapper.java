package com.xiaoma.dao;

import com.xiaoma.bean.bo.SysUserMediaOwnerExample;
import com.xiaoma.bean.po.SysUserMediaOwner;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserMediaOwnerMapper {
    int countByExample(SysUserMediaOwnerExample example);

    int insert(SysUserMediaOwner record);

    int insertSelective(SysUserMediaOwner record);

    List<SysUserMediaOwner> selectByExample(SysUserMediaOwnerExample example);

    SysUserMediaOwner selectByPrimaryKey(String mediaOwnerId);

    SysUserMediaOwner selectByPhoneNo(String phoneNo);

    int updateByExampleSelective(@Param("record") SysUserMediaOwner record, @Param("example") SysUserMediaOwnerExample example);

    int updateByExample(@Param("record") SysUserMediaOwner record, @Param("example") SysUserMediaOwnerExample example);

    int updateByPrimaryKeySelective(SysUserMediaOwner record);

    int updateByPrimaryKey(SysUserMediaOwner record);
}