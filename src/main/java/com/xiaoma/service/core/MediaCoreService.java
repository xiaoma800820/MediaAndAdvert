package com.xiaoma.service.core;

import com.xiaoma.bean.dto.*;
import com.xiaoma.utils.RetInfo;

/**
 * 媒体主核心业务接口
 * @author mmh
 * @date 2019/3/25
 */
public interface MediaCoreService {



    RetInfo saveMediaInfo(MediaInfoAddParam param);

    RetInfo queryMediaInfoList(MediaQryListParam param);

    RetInfo mediaPutPlanAdd(MediaPutPlanParam param);

    RetInfo queryMediaPutPlanList(MediaPlanQryListParam param);

    RetInfo updatePutPlanStatus(MediaPlanStatusParam param);

    RetInfo updateExpansivity(MediaExpansivityParam param);

    RetInfo mediaPlanRecharge(PlanRechargeParam param,String token);

    RetInfo mediaQueryAdvertList(MediaQryAdvertListParam param);

    RetInfo mediaWriterBackShowRecord(MediaWriterParam param);

    RetInfo mediaWriterBackClickRecord(MediaWriterParam param);
}
