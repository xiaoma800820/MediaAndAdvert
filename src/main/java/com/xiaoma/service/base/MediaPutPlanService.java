package com.xiaoma.service.base;

import com.xiaoma.bean.bo.SysMediaPutPlanExample;
import com.xiaoma.bean.po.SysMediaPutPlan;

import java.util.List;

/**
 * 媒体投放计划领域级业务接口
 * @author mmh
 * @date 2019/3/26
 */
public interface MediaPutPlanService {

    int countMediaPlan(SysMediaPutPlanExample example);

    int saveMediaPutPlanInfo(SysMediaPutPlan record);

    List<SysMediaPutPlan> queryMediaPutPlan(SysMediaPutPlanExample example);

    int updateMediaPutPlan(SysMediaPutPlan record);

    SysMediaPutPlan queryMediaPutPlan(String planId);
}
