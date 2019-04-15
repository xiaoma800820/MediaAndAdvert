package com.xiaoma.controller.recharge;

import com.xiaoma.bean.dto.RechargeParam;
import com.xiaoma.service.core.RechargeCoreService;
import com.xiaoma.utils.PageInfo;
import com.xiaoma.utils.RetInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 充值访问控制器
 * @author mmh
 * @date 2019/3/25
 */
@RestController
public class RechargeController {


    @Autowired
    private RechargeCoreService rechargeCoreService;



    @ApiOperation("用户管理-充值")
    @PostMapping(value = "/api/reader/back/rechargeUserAccount")
    public RetInfo rechargeUserAccount(@RequestBody RechargeParam param){
        return rechargeCoreService.rechargeUserAccount(param);
    }

    @ApiOperation("财务管理-充值记录")
    @PostMapping(value = "/api/reader/back/rechargeQryRecordList")
    public RetInfo rechargeQryRecordList(@RequestBody PageInfo pageInfo){
        return rechargeCoreService.rechargeQryRecordList(pageInfo);
    }



}
