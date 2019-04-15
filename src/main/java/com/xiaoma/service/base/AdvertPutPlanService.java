package com.xiaoma.service.base;

import com.xiaoma.bean.bo.SysAdvertPutPlanExample;
import com.xiaoma.bean.po.SysAdvertPutPlan;

import java.util.List;

/**
 * 广告投放计划领域级业务接口
 * @author mmh
 * @date 2019/3/26
 */
public interface AdvertPutPlanService {

    int countByExample(SysAdvertPutPlanExample example);

    int saveAdvertPutPlanInfo(SysAdvertPutPlan record);

    List<SysAdvertPutPlan> queryListByExample(SysAdvertPutPlanExample example);

    int updateAdvertPutPlan(SysAdvertPutPlan record);

    SysAdvertPutPlan queryPutPlanById(String planId);

    SysAdvertPutPlan queryPutPlanByAdvertId(String advertId);
}
