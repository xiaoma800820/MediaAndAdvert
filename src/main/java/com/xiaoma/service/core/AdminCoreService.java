package com.xiaoma.service.core;

import com.xiaoma.bean.dto.LoginParam;
import com.xiaoma.bean.dto.PassWordParam;
import com.xiaoma.utils.RetInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * 管理员核心业务接口
 * @author mmh
 * @date 2019/3/20
 */
public interface AdminCoreService {

    /**
     * 管理员登录
     * @param param 参数
     * @return 结果码
     */
    RetInfo adminLogin(LoginParam param,HttpServletRequest request);

    RetInfo adminExit(String token);

    RetInfo adminUpdatePassword(PassWordParam param, String token);
}
