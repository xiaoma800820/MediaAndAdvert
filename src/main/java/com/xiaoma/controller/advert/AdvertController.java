package com.xiaoma.controller.advert;

import com.xiaoma.bean.dto.*;
import com.xiaoma.service.core.AdvertCoreService;
import com.xiaoma.utils.RetInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 广告控制器
 * @author mmh
 * @date 2019/3/20
 */
@RestController
public class AdvertController {


    @Autowired
    private AdvertCoreService advertCoreService;


    @ApiOperation("添加广告")
    @PostMapping(value = "/api/reader/back/advertInfoAdd")
    public RetInfo advertInfoAdd(@RequestBody AdvertInfoAddParam param){
        return advertCoreService.advertInfoAdd(param);
    }

    @ApiOperation("修改广告信息")
    @PostMapping(value = "/api/reader/back/advertInfoUpdate")
    public RetInfo advertInfoUpdate(@RequestBody AdvertInfoEditParam param){
        return advertCoreService.advertInfoUpdate(param);
    }

    @ApiOperation("广告列表查询")
    @PostMapping(value = "/api/reader/back/queryAdvertList")
    public RetInfo queryAdvertList(@RequestBody AdvertListQryParam param){
        return advertCoreService.queryAdvertList(param);
    }

    @ApiOperation("广告投放计划新增")
    @PostMapping(value = "/api/reader/back/advertPutPlanAdd")
    public RetInfo advertPutPlanAdd(@RequestBody AdvertPutPlanParam param){
        return advertCoreService.advertPutPlanAdd(param);
    }

    @ApiOperation("广告投放计划列表")
    @PostMapping(value = "/api/reader/back/queryAdvertPutPlanList")
    public RetInfo queryAdvertPutPlanList(@RequestBody AdvertPlanQryListParam param){
        return advertCoreService.queryAdvertPutPlanList(param);
    }

    @ApiOperation("广告投放计划状态更新")
    @PostMapping(value = "/api/reader/back/updatePutPlanStatus")
    public RetInfo updatePutPlanStatus(@RequestBody PutPlanStatusParam param){
        return advertCoreService.updatePutPlanStatus(param);
    }

    @ApiOperation("广告投放计划修改系数")
    @PostMapping(value = "/api/reader/back/updateExpansivity")
    public RetInfo updateExpansivity(@RequestBody PlanExpansivityParam param){
        return advertCoreService.updateExpansivity(param);
    }

    @ApiOperation("广告主-查询广告列表")
    @PostMapping(value = "/api/reader/back/advertListByAdvertiser")
    public RetInfo advertListByAdvertiser(@RequestBody AdvertiserAdvertListParam param, @RequestHeader(value = "token") String token){
        return advertCoreService.advertListByAdvertiser(param,token);
    }

    @ApiOperation("广告主-投放计划列表")
    @PostMapping(value = "/api/reader/back/putPlanByAdvertiser")
    public RetInfo putPlanByAdvertiser(@RequestBody AdvertiserAdvertListParam param, @RequestHeader(value = "token") String token){
        return advertCoreService.putPlanByAdvertiser(param,token);
    }

    @ApiOperation("广告主-投放")
    @PostMapping(value = "/api/reader/back/advertiserRechargePlan")
    public RetInfo advertiserRechargePlan(@RequestBody PlanRechargeParam param,@RequestHeader(value = "token") String token){
        return advertCoreService.advertiserRechargePlan(param,token);
    }

    @ApiOperation("媒体计划制定广告投放计划集")
    @PostMapping(value = "/api/reader/back/mediaPlanQryAdvertPlan")
    public RetInfo mediaPlanQryAdvertPlan(@RequestBody MediaAdvertPlanParam param){
        return advertCoreService.mediaPlanQryAdvertPlan(param);
    }

}
