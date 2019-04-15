package com.xiaoma.service.base.impl;

import com.xiaoma.bean.bo.SysAdvertInfoExample;
import com.xiaoma.bean.po.SysAdvertInfo;
import com.xiaoma.dao.SysAdvertInfoMapper;
import com.xiaoma.service.base.AdvertInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 广告领域级业务接口实现类
 * @author mmh
 * @date 2019/3/20
 */
@Service
public class AdvertInfoServiceImpl implements AdvertInfoService {

    @Autowired
    private SysAdvertInfoMapper sysAdvertInfoMapper;

    @Override
    public int saveAdvertInfo(SysAdvertInfo record) {
        return sysAdvertInfoMapper.insert(record);
    }

    @Override
    public int countAdvertInfo(SysAdvertInfoExample example) {
        return sysAdvertInfoMapper.countByExample(example);
    }

    @Override
    public int updateAdvertInfoById(SysAdvertInfo record) {
        return sysAdvertInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<SysAdvertInfo> queryAdvertInfoList(SysAdvertInfoExample example) {
        return sysAdvertInfoMapper.selectByExample(example);
    }

    @Override
    public SysAdvertInfo queryAdvertInfoById(String advertId) {
        return sysAdvertInfoMapper.selectByPrimaryKey(advertId);
    }
}
