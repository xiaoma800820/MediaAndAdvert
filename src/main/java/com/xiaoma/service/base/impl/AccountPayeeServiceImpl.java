package com.xiaoma.service.base.impl;

import com.xiaoma.bean.po.SysAccountPayee;
import com.xiaoma.dao.SysAccountPayeeMapper;
import com.xiaoma.service.base.AccountPayeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 账号收款信息领域级业务实现
 * @author mmh
 * @date 2019/3/25
 */
@Service
public class AccountPayeeServiceImpl implements AccountPayeeService {


    @Autowired
    private SysAccountPayeeMapper accountPayeeMapper;

    @Override
    public int saveAccountPayeeInfo(SysAccountPayee record) {
        return accountPayeeMapper.insert(record);
    }

    @Override
    public SysAccountPayee queryPayeeInfoById(String payeeId) {
        return accountPayeeMapper.selectByPrimaryKey(payeeId);
    }

    @Override
    public int updateAccountPayeeInfo(SysAccountPayee record) {
        return accountPayeeMapper.updateByPrimaryKeySelective(record);
    }
}
