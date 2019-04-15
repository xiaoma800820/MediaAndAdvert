package com.xiaoma.service.base.impl;

import com.xiaoma.bean.bo.SysAdvertShowTypeExample;
import com.xiaoma.bean.po.SysAdvertShowType;
import com.xiaoma.dao.SysAdvertShowTypeMapper;
import com.xiaoma.service.base.AdvertShowTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 广告类型
 * @author mmh
 * @date 2019/3/26
 */
@Service
public class AdvertShowTypeServiceImpl implements AdvertShowTypeService {

    @Autowired
    private SysAdvertShowTypeMapper advertShowTypeMapper;

    @Override
    public List<SysAdvertShowType> queryByExample(SysAdvertShowTypeExample example) {
        return advertShowTypeMapper.selectByExample(example);
    }
}
