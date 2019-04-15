package com.xiaoma.service.base.impl;

import com.xiaoma.bean.bo.SysAdvertPutPlanExample;
import com.xiaoma.bean.po.SysAdvertPutPlan;
import com.xiaoma.dao.SysAdvertPutPlanMapper;
import com.xiaoma.service.base.AdvertPutPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 广告投放计划领域级业务实现
 * @author mmh
 * @date 2019/3/26
 */
@Service
public class AdvertPutPlanServiceImpl implements AdvertPutPlanService {

    @Autowired
    private SysAdvertPutPlanMapper advertPutPlanMapper;


    @Override
    public int countByExample(SysAdvertPutPlanExample example) {
        return advertPutPlanMapper.countByExample(example);
    }

    @Override
    public int saveAdvertPutPlanInfo(SysAdvertPutPlan record) {
        return advertPutPlanMapper.insert(record);
    }

    @Override
    public List<SysAdvertPutPlan> queryListByExample(SysAdvertPutPlanExample example) {
        return advertPutPlanMapper.selectByExample(example);
    }

    @Override
    public int updateAdvertPutPlan(SysAdvertPutPlan record) {
        return advertPutPlanMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public SysAdvertPutPlan queryPutPlanById(String planId) {
        return advertPutPlanMapper.selectByPrimaryKey(planId);
    }

    @Override
    public SysAdvertPutPlan queryPutPlanByAdvertId(String advertId) {
        return advertPutPlanMapper.selectByAdvertId(advertId);
    }
}
