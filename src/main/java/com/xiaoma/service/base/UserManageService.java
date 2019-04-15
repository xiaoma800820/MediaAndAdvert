package com.xiaoma.service.base;

import com.xiaoma.bean.po.SysUserManage;

/**
 * 平台帐号信息领域级接口
 * @author mmh
 * @date 2019/3/18
 */

public interface UserManageService {

    /**
     * 根据手机号查询管理员帐号信息
     * @param phoneNo 手机号
     * @return 帐号信息
     */
    SysUserManage queryByPhone(String phoneNo);

    int updateUserManageInfo(SysUserManage record);
}
