package com.xiaoma.controller.user;

import com.xiaoma.bean.dto.AdvertiserAddParam;
import com.xiaoma.bean.dto.AdvertiserEditParam;
import com.xiaoma.bean.dto.AdvertiserQryParam;
import com.xiaoma.bean.dto.PassWordUpdateParam;
import com.xiaoma.service.core.AdvertiserCoreService;
import com.xiaoma.utils.RetInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 广告主访问
 * @author mmh
 * @date 2019/3/20
 */
@RestController
public class AdvertiserController {

    @Autowired
    private AdvertiserCoreService advertiserCoreService;

    @ApiOperation("广告主列表查询")
    @PostMapping(value = "/api/reader/back/queryAdvertiserList")
    public RetInfo queryAdvertiserList(@RequestBody AdvertiserQryParam param){
        return advertiserCoreService.queryAdvertiserList(param);
    }

    @ApiOperation("广告主添加")
    @PostMapping(value = "/api/reader/back/advertiserInfoAdd")
    public RetInfo advertiserInfoAdd(@RequestBody AdvertiserAddParam param){
        return advertiserCoreService.advertiserInfoAdd(param);
    }


    @ApiOperation("广告主-个人信息详情")
    @PostMapping(value = "/api/reader/back/advertiserInfoDetail")
    public RetInfo advertiserInfoDetail(@RequestHeader(value = "token")String token){
        return advertiserCoreService.advertiserInfoDetail(token);
    }

    @ApiOperation("广告主-个人信息更新")
    @PostMapping(value = "/api/reader/back/advertiserInfoUpdate")
    public RetInfo advertiserInfoUpdate(@RequestBody AdvertiserEditParam param){
        return advertiserCoreService.advertInfoUpdate(param);
    }

    @ApiOperation("广告主-密码修改")
    @PostMapping(value = "/api/reader/back/advertiserPassWordUpdate")
    public RetInfo advertiserPassWordUpdate(@RequestHeader(value = "token") String token,@RequestBody PassWordUpdateParam param){
        return advertiserCoreService.advertiserPassWordUpdate(token,param);
    }

}
