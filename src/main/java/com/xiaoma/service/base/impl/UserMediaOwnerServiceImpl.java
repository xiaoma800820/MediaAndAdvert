package com.xiaoma.service.base.impl;

import com.xiaoma.bean.bo.SysUserMediaOwnerExample;
import com.xiaoma.bean.dto.MediaOwnerAddParam;
import com.xiaoma.bean.dto.MediaOwnerQryParam;
import com.xiaoma.bean.po.SysUserMediaOwner;
import com.xiaoma.dao.SysUserMediaOwnerMapper;
import com.xiaoma.service.base.UserMediaOwnerService;
import com.xiaoma.utils.RetInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 媒体主账号信息领域级业务实现类
 * @author mmh
 * @date 2019/3/18
 */
@Service
public class UserMediaOwnerServiceImpl implements UserMediaOwnerService {

    @Autowired
    private SysUserMediaOwnerMapper userMediaOwnerMapper;


    @Override
    public int countMediaOwner(SysUserMediaOwnerExample example) {
        return userMediaOwnerMapper.countByExample(example);
    }

    @Override
    public List<SysUserMediaOwner> queryMediaOwnerList(SysUserMediaOwnerExample example) {
        return userMediaOwnerMapper.selectByExample(example);
    }

    @Override
    public int saveMediaOwnerInfo(SysUserMediaOwner userMediaOwner) {
        return userMediaOwnerMapper.insert(userMediaOwner);
    }

    @Override
    public int updateMediaOwnerInfo(SysUserMediaOwner userMediaOwner) {
        return userMediaOwnerMapper.updateByPrimaryKeySelective(userMediaOwner);
    }

    @Override
    public SysUserMediaOwner queryMediaOwnerInfo(String phoneNo) {
        return userMediaOwnerMapper.selectByPhoneNo(phoneNo);
    }
}
