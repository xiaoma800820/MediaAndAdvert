package com.xiaoma.service.base;

import com.xiaoma.bean.bo.SysBillingConfigExample;
import com.xiaoma.bean.po.SysBillingConfig;

import java.util.List;

/**
 * 计费形式领域级业务接口
 * @author mmh
 * @date 2019/3/27
 */
public interface BillingConfigService {

    List<SysBillingConfig> queryByExample(SysBillingConfigExample example);
}
