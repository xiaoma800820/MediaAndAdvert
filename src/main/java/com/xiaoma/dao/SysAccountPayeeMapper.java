package com.xiaoma.dao;

import com.xiaoma.bean.po.SysAccountPayee;
import com.xiaoma.bean.bo.SysAccountPayeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAccountPayeeMapper {

    int countByExample(SysAccountPayeeExample example);

    int insert(SysAccountPayee record);

    int insertSelective(SysAccountPayee record);

    List<SysAccountPayee> selectByExample(SysAccountPayeeExample example);

    SysAccountPayee selectByPrimaryKey(String payeeId);

    int updateByExampleSelective(@Param("record") SysAccountPayee record, @Param("example") SysAccountPayeeExample example);

    int updateByExample(@Param("record") SysAccountPayee record, @Param("example") SysAccountPayeeExample example);

    int updateByPrimaryKeySelective(SysAccountPayee record);

    int updateByPrimaryKey(SysAccountPayee record);
}