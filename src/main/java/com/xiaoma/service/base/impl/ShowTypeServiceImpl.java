package com.xiaoma.service.base.impl;

import com.xiaoma.bean.bo.SysAdvertShowTypeExample;
import com.xiaoma.bean.po.SysAdvertShowType;
import com.xiaoma.dao.SysAdvertShowTypeMapper;
import com.xiaoma.service.base.ShowTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 广告展示类型领域级业务实现
 * @author mmh
 * @date 2019/3/27
 */
@Service
public class ShowTypeServiceImpl implements ShowTypeService {


    @Autowired
    private SysAdvertShowTypeMapper advertShowTypeMapper;

    @Override
    public int saveShowTypeInfo(SysAdvertShowType record) {
        return advertShowTypeMapper.insert(record);
    }

    @Override
    public int updateShowTypeInfo(SysAdvertShowType record) {
        return advertShowTypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int countShowType(SysAdvertShowTypeExample example) {
        return advertShowTypeMapper.countByExample(example);
    }

    @Override
    public List<SysAdvertShowType> queryShowTypeList(SysAdvertShowTypeExample example) {
        return advertShowTypeMapper.selectByExample(example);
    }

    @Override
    public SysAdvertShowType queryShowTypeInfo(String showTypeCode) {
        return advertShowTypeMapper.selectByPrimaryKey(showTypeCode);
    }
}
