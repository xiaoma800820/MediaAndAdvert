package com.xiaoma.controller.user;

import com.xiaoma.bean.dto.*;
import com.xiaoma.service.core.MediaCoreService;
import com.xiaoma.service.core.MediaOwnerCoreService;
import com.xiaoma.utils.RetInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 媒体主
 * @author mmh
 * @date 2019/3/25
 */
@RestController
public class MediaOwnerController {


    @Autowired
    private MediaOwnerCoreService mediaOwnerCoreService;

    @ApiOperation("后台管理-媒体主列表查询")
    @PostMapping(value = "/api/reader/back/queryMediaOwnerList")
    public RetInfo queryMediaOwnerList(@RequestBody MediaOwnerQryParam param){
        return mediaOwnerCoreService.queryMediaOwnerList(param);
    }

    @ApiOperation("后台管理-媒体主添加")
    @PostMapping(value = "/api/reader/back/mediaOwnerAdd")
    public RetInfo mediaOwnerAdd(@RequestBody MediaOwnerAddParam param){
        return mediaOwnerCoreService.mediaOwnerAdd(param);
    }

//    @ApiOperation("媒体主收款方式添加")
//    @PostMapping(value = "/api/reader/back/mediaAccountPayeeAdd")
//    public RetInfo mediaAccountPayeeAdd(@RequestBody PayeeAddParam param){
//        return mediaOwnerCoreService.mediaAccountPayeeAdd(param);
//    }

    @ApiOperation("收款方式查询")
    @PostMapping(value = "/api/reader/back/queryAccountPayeeInfo")
    public RetInfo queryAccountPayeeInfo(@RequestBody PayeeQryParam payeeQryParam){
        return mediaOwnerCoreService.queryAccountPayeeInfo(payeeQryParam);
    }

    @ApiOperation("媒体主修改密码")
    @PostMapping(value = "/api/reader/back/mediaOwnerUpdatePassWord")
    public RetInfo mediaOwnerUpdatePassWord(@RequestHeader(value = "token") String token, @RequestBody PassWordUpdateParam param){
        return mediaOwnerCoreService.mediaOwnerUpdatePassWord(token,param);
    }

    @ApiOperation("媒体主-个人信息")
    @PostMapping(value = "/api/reader/back/queryMediaOwnerDetail")
    public RetInfo queryMediaOwnerDetail(@RequestHeader(value = "token") String token){
        return mediaOwnerCoreService.queryMediaOwnerDetail(token);
    }

    @ApiOperation("媒体主-修改个人信息")
    @PostMapping(value = "/api/reader/back/updateMediaOwnerInfo")
    public RetInfo updateMediaOwnerInfo(@RequestBody MediaOwnerUpdateParam param){
        return mediaOwnerCoreService.updateMediaOwnerInfo(param);
    }
}
