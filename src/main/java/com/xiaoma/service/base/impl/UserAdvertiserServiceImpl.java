package com.xiaoma.service.base.impl;

import com.xiaoma.bean.bo.SysUserAdvertisersExample;
import com.xiaoma.bean.po.SysUserAdvertisers;
import com.xiaoma.dao.SysUserAdvertisersMapper;
import com.xiaoma.service.base.UserAdvertiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 广告主领域级帐号业务实现类
 * @author mmh
 * @date 2019/3/18
 */
@Service
public class UserAdvertiserServiceImpl implements UserAdvertiserService {

    @Autowired
    private SysUserAdvertisersMapper userAdvertisersMapper;

    @Override
    public SysUserAdvertisers queryAdvertiserInfo(String phoneNo) {
        return userAdvertisersMapper.selectByPhoneNo(phoneNo);
    }

    @Override
    public SysUserAdvertisers queryAdvertiserById(String advertiserId) {
        return userAdvertisersMapper.selectByPrimaryKey(advertiserId);
    }

    @Override
    public int countAdvertisers(SysUserAdvertisersExample example) {
        return userAdvertisersMapper.countByExample(example);
    }

    @Override
    public List<SysUserAdvertisers> queryAdvertiserList(SysUserAdvertisersExample example) {
        return userAdvertisersMapper.selectByExample(example);
    }

    @Override
    public int saveAdvertisers(SysUserAdvertisers record) {
        return userAdvertisersMapper.insert(record);
    }

    @Override
    public int updateAdvertisersById(SysUserAdvertisers record) {
        return userAdvertisersMapper.updateByPrimaryKeySelective(record);
    }
}
