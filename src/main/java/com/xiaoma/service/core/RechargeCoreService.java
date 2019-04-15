package com.xiaoma.service.core;

import com.xiaoma.bean.dto.RechargeParam;
import com.xiaoma.utils.PageInfo;
import com.xiaoma.utils.RetInfo;

/**
 * 核心业务逻辑接口
 * @author mmh
 * @date 2019/3/25
 */
public interface RechargeCoreService {



    RetInfo rechargeUserAccount(RechargeParam param);

    RetInfo rechargeQryRecordList(PageInfo pageInfo);

}
