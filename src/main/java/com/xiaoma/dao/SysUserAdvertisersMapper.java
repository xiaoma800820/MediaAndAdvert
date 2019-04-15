package com.xiaoma.dao;

import com.xiaoma.bean.bo.SysUserAdvertisersExample;
import com.xiaoma.bean.po.SysUserAdvertisers;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserAdvertisersMapper {

    SysUserAdvertisers selectByPhoneNo(String phoneNo);

    int countByExample(SysUserAdvertisersExample example);

    int insert(SysUserAdvertisers record);

    int insertSelective(SysUserAdvertisers record);

    List<SysUserAdvertisers> selectByExample(SysUserAdvertisersExample example);

    SysUserAdvertisers selectByPrimaryKey(String advertiserId);

    int updateByExampleSelective(@Param("record") SysUserAdvertisers record, @Param("example") SysUserAdvertisersExample example);

    int updateByExample(@Param("record") SysUserAdvertisers record, @Param("example") SysUserAdvertisersExample example);

    int updateByPrimaryKeySelective(SysUserAdvertisers record);

    int updateByPrimaryKey(SysUserAdvertisers record);
}