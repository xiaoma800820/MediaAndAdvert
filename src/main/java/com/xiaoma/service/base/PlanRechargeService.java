package com.xiaoma.service.base;

import com.xiaoma.bean.po.SysPlanRecharge;

import java.math.BigDecimal;

/**
 * 领域级计划投放充值接口
 * @author mmh
 * @date 2019/4/4
 */
public interface PlanRechargeService {

    int savePlanRecharge(SysPlanRecharge record);

    BigDecimal countPlanRecharge(String userId);
}
