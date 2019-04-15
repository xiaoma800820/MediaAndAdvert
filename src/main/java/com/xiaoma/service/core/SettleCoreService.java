package com.xiaoma.service.core;

import com.xiaoma.bean.dto.MediaOwnerQryParam;
import com.xiaoma.bean.dto.SettleParam;
import com.xiaoma.utils.PageInfo;
import com.xiaoma.utils.RetInfo;

/**
 * 账户结算信息
 * @author mmh
 * @date 2019/4/8
 */
public interface SettleCoreService {


    RetInfo querySettleList(PageInfo pageInfo);

    RetInfo queryWaitSettleList(MediaOwnerQryParam param);

    RetInfo finishSettle(SettleParam param);

    RetInfo queryMediaSettleList(PageInfo pageInfo,String token);

    RetInfo queryAdvertSettleList(PageInfo pageInfo, String token);
}
