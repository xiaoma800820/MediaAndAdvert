package com.xiaoma.service.base;

import com.xiaoma.bean.bo.SysAdvertShowTypeExample;
import com.xiaoma.bean.po.SysAdvertShowType;

import java.util.List;

/**
 * 广告展示类型领域级业务接口
 * @author mmh
 * @date 2019/3/27
 */
public interface ShowTypeService {

    int saveShowTypeInfo(SysAdvertShowType record);

    int updateShowTypeInfo(SysAdvertShowType record);

    int countShowType(SysAdvertShowTypeExample example);

    List<SysAdvertShowType> queryShowTypeList(SysAdvertShowTypeExample example);

    SysAdvertShowType queryShowTypeInfo(String showTypeCode);
}
