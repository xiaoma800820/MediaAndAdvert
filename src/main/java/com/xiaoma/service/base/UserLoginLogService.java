package com.xiaoma.service.base;

import com.xiaoma.bean.po.SysUserLoginLog;

/**
 * 登录日志领域级业务接口
 * @author mmh
 * @date 2019/3/18
 */
public interface UserLoginLogService {

    int saveLoginLog(SysUserLoginLog userLoginLog);
}
