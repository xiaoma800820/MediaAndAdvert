package com.xiaoma.service.core;

import com.xiaoma.bean.dto.*;
import com.xiaoma.utils.RetInfo;

/**
 * 广告核心业务逻辑接口
 * @author mmh
 * @date 2019/3/20
 */
public interface AdvertCoreService {

    RetInfo advertInfoAdd(AdvertInfoAddParam param);

    RetInfo advertInfoUpdate(AdvertInfoEditParam param);

    RetInfo queryAdvertList(AdvertListQryParam param);

    RetInfo advertPutPlanAdd(AdvertPutPlanParam param);

    RetInfo queryAdvertPutPlanList(AdvertPlanQryListParam param);

    RetInfo updatePutPlanStatus(PutPlanStatusParam param);

    RetInfo updateExpansivity(PlanExpansivityParam param);

    RetInfo advertListByAdvertiser(AdvertiserAdvertListParam param, String token);

    RetInfo putPlanByAdvertiser(AdvertiserAdvertListParam param, String token);

    RetInfo advertiserRechargePlan(PlanRechargeParam param, String token);

    RetInfo mediaPlanQryAdvertPlan(MediaAdvertPlanParam param);
}
