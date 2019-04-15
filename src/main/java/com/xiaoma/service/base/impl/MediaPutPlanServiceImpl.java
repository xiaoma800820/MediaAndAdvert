package com.xiaoma.service.base.impl;

import com.xiaoma.bean.bo.SysMediaPutPlanExample;
import com.xiaoma.bean.po.SysMediaPutPlan;
import com.xiaoma.dao.SysMediaPutPlanMapper;
import com.xiaoma.service.base.MediaPutPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 媒体投放计划领域级业务接口
 * @author mmh
 * @date 2019/3/26
 */
@Service
public class MediaPutPlanServiceImpl implements MediaPutPlanService {

    @Autowired
    private SysMediaPutPlanMapper mediaPutPlanMapper;

    @Override
    public int countMediaPlan(SysMediaPutPlanExample example) {
        return mediaPutPlanMapper.countByExample(example);
    }

    @Override
    public int saveMediaPutPlanInfo(SysMediaPutPlan record) {
        return mediaPutPlanMapper.insert(record);
    }

    @Override
    public List<SysMediaPutPlan> queryMediaPutPlan(SysMediaPutPlanExample example) {
        return mediaPutPlanMapper.selectByExample(example);
    }

    @Override
    public int updateMediaPutPlan(SysMediaPutPlan record) {
        return mediaPutPlanMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public SysMediaPutPlan queryMediaPutPlan(String planId) {
        return mediaPutPlanMapper.selectByPrimaryKey(planId);
    }
}
