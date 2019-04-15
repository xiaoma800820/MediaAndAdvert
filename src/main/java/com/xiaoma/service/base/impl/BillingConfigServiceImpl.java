package com.xiaoma.service.base.impl;

import com.xiaoma.bean.bo.SysBillingConfigExample;
import com.xiaoma.bean.po.SysBillingConfig;
import com.xiaoma.dao.SysBillingConfigMapper;
import com.xiaoma.service.base.BillingConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 计费形式领域级业务实现
 * @author mmh
 * @date 2019/3/27
 */
@Service
public class BillingConfigServiceImpl implements BillingConfigService {

    @Autowired
    private SysBillingConfigMapper billingConfigMapper;



    @Override
    public List<SysBillingConfig> queryByExample(SysBillingConfigExample example) {
        return billingConfigMapper.selectByExample(example);
    }
}
