package com.xiaoma.service.core;

import com.xiaoma.bean.po.SysUserLoginLog;

/**
 * 登录日志核心业务逻辑接口
 * @author mmh
 * @date 2019/3/18
 */
public interface LoginLogCoreService {

    int saveLoginLog(SysUserLoginLog userLoginLog);
}
