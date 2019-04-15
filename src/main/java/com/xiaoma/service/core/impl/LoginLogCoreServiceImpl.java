package com.xiaoma.service.core.impl;

import com.xiaoma.bean.po.SysUserLoginLog;
import com.xiaoma.service.base.UserLoginLogService;
import com.xiaoma.service.core.LoginLogCoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录日志核心业务逻辑实现
 * @author mmh
 * @date 2019/3/18
 */
@Service
public class LoginLogCoreServiceImpl implements LoginLogCoreService {

    @Autowired
    private UserLoginLogService userLoginLogService;

    @Override
    public int saveLoginLog(SysUserLoginLog userLoginLog) {
        return userLoginLogService.saveLoginLog(userLoginLog);
    }
}
