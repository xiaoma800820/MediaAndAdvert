package com.xiaoma.service.base.impl;

import com.xiaoma.bean.bo.SysMediaTypeExample;
import com.xiaoma.bean.po.SysMediaType;
import com.xiaoma.dao.SysMediaTypeMapper;
import com.xiaoma.service.base.MediaTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 媒体类型领域级业务实现
 * @author mmh
 * @date 2019/3/26
 */
@Service
public class MediaTypeServiceImpl implements MediaTypeService {

    @Autowired
    private SysMediaTypeMapper mediaTypeMapper;

    @Override
    public List<SysMediaType> queryMediaTypeByExample(SysMediaTypeExample example) {
        return mediaTypeMapper.selectByExample(example);
    }

    @Override
    public int countMediaType(SysMediaTypeExample example) {
        return mediaTypeMapper.countByExample(example);
    }

    @Override
    public int saveSysMediaTypeInfo(SysMediaType record) {
        return mediaTypeMapper.insert(record);
    }

    @Override
    public int updateSysMediaType(SysMediaType record) {
        return mediaTypeMapper.updateByPrimaryKeySelective(record);
    }
}
