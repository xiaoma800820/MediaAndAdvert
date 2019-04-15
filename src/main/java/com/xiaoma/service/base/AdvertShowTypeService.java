package com.xiaoma.service.base;

import com.xiaoma.bean.bo.SysAdvertShowTypeExample;
import com.xiaoma.bean.po.SysAdvertShowType;

import java.util.List;

/**
 * 广告类型
 * @author mmh
 * @date 2019/3/26
 */
public interface AdvertShowTypeService {

    List<SysAdvertShowType> queryByExample(SysAdvertShowTypeExample example);
}
