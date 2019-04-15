package com.xiaoma.service.base.impl;

import com.xiaoma.bean.po.SysUserLoginLog;
import com.xiaoma.dao.SysUserLoginLogMapper;
import com.xiaoma.service.base.UserLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录日志领域级业务实现
 * @author mmh
 * @date 2019/3/18
 */
@Service
public class UserLoginLogServiceImpl implements UserLoginLogService {


    @Autowired
    private SysUserLoginLogMapper userLoginLogMapper;

    @Override
    public int saveLoginLog(SysUserLoginLog userLoginLog) {
        return userLoginLogMapper.insert(userLoginLog);
    }
}
