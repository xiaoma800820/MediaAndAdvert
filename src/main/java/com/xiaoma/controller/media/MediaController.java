package com.xiaoma.controller.media;

import com.xiaoma.bean.dto.*;
import com.xiaoma.service.core.MediaCoreService;
import com.xiaoma.utils.RetInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 媒体信息访问控制器
 * @author mmh
 * @date 2019/3/25
 */
@RestController
public class MediaController {


    @Autowired
    private MediaCoreService mediaCoreService;

    @ApiOperation("添加媒体")
    @PostMapping(value = "/api/reader/back/saveMediaInfo")
    public RetInfo saveMediaInfo(@RequestBody MediaInfoAddParam param){
        return mediaCoreService.saveMediaInfo(param);
    }

    @ApiOperation("媒体列表")
    @PostMapping(value = "/api/reader/back/queryMediaInfoList")
    public RetInfo queryMediaInfoList(@RequestBody MediaQryListParam param){
        return mediaCoreService.queryMediaInfoList(param);
    }

    @ApiOperation("媒体投放计划新增")
    @PostMapping(value = "/api/reader/back/mediaPutPlanAdd")
    public RetInfo mediaPutPlanAdd(@RequestBody MediaPutPlanParam param){
        return mediaCoreService.mediaPutPlanAdd(param);
    }

    @ApiOperation("媒体投放计划列表")
    @PostMapping(value = "/api/reader/back/queryMediaPutPlanList")
    public RetInfo queryMediaPutPlanList(@RequestBody MediaPlanQryListParam param){
        return mediaCoreService.queryMediaPutPlanList(param);
    }

    @ApiOperation("媒体投放计划状态更新:状态更新：0是空闲，1是投放中，2是已停止")
    @PostMapping(value = "/api/reader/back/updateMediaPutPlanStatus")
    public RetInfo updateMediaPutPlanStatus(@RequestBody MediaPlanStatusParam param){
        return mediaCoreService.updatePutPlanStatus(param);
    }

    @ApiOperation("媒体投放计划膨胀系数修改")
    @PostMapping(value = "/api/reader/back/updateMediaExpansivity")
    public RetInfo updateMediaExpansivity(@RequestBody MediaExpansivityParam param){
        return mediaCoreService.updateExpansivity(param);
    }

    @ApiOperation("媒体管理-投放")
    @PostMapping(value = "/api/reader/back/mediaPlanRecharge")
    public RetInfo mediaPlanRecharge(@RequestBody PlanRechargeParam param, @RequestHeader(value = "token") String token){
        return mediaCoreService.mediaPlanRecharge(param,token);
    }



    @ApiOperation("媒体阅读器-查询投放计划")
    @PostMapping(value = "/api/reader/media/mediaQueryAdvertList")
    public RetInfo mediaQueryAdvertList(@RequestBody MediaQryAdvertListParam param){
        return mediaCoreService.mediaQueryAdvertList(param);
    }

    @ApiOperation("媒体阅读器-回写广告展示记录")
    @PostMapping(value = "/api/reader/media/mediaWriterBackShowRecord")
    public RetInfo mediaWriterBackShowRecord(@RequestBody MediaWriterParam param){
        return mediaCoreService.mediaWriterBackShowRecord(param);
    }

    @ApiOperation("媒体阅读器-回写广告展示记录")
    @PostMapping(value = "/api/reader/media/mediaWriterBackClickRecord")
    public RetInfo mediaWriterBackClickRecord(@RequestBody MediaWriterParam param){
        return mediaCoreService.mediaWriterBackClickRecord(param);
    }

}
