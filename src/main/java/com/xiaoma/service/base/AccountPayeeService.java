package com.xiaoma.service.base;

import com.xiaoma.bean.po.SysAccountPayee;

/**
 * 收款人信息领域级业务接口
 * @author mmh
 * @date 2019/3/25
 */
public interface AccountPayeeService {

    int saveAccountPayeeInfo(SysAccountPayee record);

    SysAccountPayee queryPayeeInfoById(String payeeId);

    int updateAccountPayeeInfo(SysAccountPayee record);
}
