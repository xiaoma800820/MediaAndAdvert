package com.xiaoma.service.base.impl;

import com.xiaoma.bean.po.SysPlanRecharge;
import com.xiaoma.dao.SysPlanRechargeMapper;
import com.xiaoma.service.base.PlanRechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 领域级计划投放充值实现类
 * @author mmh
 * @date 2019/4/4
 */
@Service
public class PlanRechargeServiceImpl implements PlanRechargeService {


    @Autowired
    private SysPlanRechargeMapper planRechargeMapper;

    @Override
    public int savePlanRecharge(SysPlanRecharge record) {
        return planRechargeMapper.insert(record);
    }

    @Override
    public BigDecimal countPlanRecharge(String userId) {
        return planRechargeMapper.countPlanRecharge(userId);
    }
}
