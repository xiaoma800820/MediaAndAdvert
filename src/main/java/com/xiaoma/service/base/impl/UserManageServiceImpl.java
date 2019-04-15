package com.xiaoma.service.base.impl;

import com.xiaoma.bean.po.SysUserManage;
import com.xiaoma.dao.SysUserManageMapper;
import com.xiaoma.service.base.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 平台账号领域级业务实现类
 * @author mmh
 * @date 2019/3/18
 */
@Service
public class UserManageServiceImpl implements UserManageService {

    @Autowired
    private SysUserManageMapper userManageMapper;

    /**
     * 根据手机号查询管理员帐号
     * @param phoneNo 手机号
     * @return 帐号信息
     */
    @Override
    public SysUserManage queryByPhone(String phoneNo) {
        return userManageMapper.selectByPhoneNo(phoneNo);
    }

    @Override
    public int updateUserManageInfo(SysUserManage record) {
        return userManageMapper.updateByPrimaryKeySelective(record);
    }
}
