package com.xiaoma.controller.user;

import com.xiaoma.bean.dto.LoginParam;
import com.xiaoma.service.core.AdvertiserCoreService;
import com.xiaoma.service.core.MediaOwnerCoreService;
import com.xiaoma.utils.RetInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 广告主登录退出访问控制器
 * @author mmh
 * @date 2019/3/18
 */
@RestController
public class LoginController {


    @Autowired
    private AdvertiserCoreService advertiserCoreService;
    @Autowired
    private MediaOwnerCoreService mediaOwnerCoreService;


    @ApiOperation("广告主手机号密码登录")
    @PostMapping(value = "/api/reader/back/advertiserLogin")
    public RetInfo advertiserLogin(@RequestBody LoginParam param,HttpServletRequest request){
        return advertiserCoreService.advertiserLogin(param,request);
    }


    @ApiOperation("广告主退出登录")
    @PostMapping(value = "/api/reader/back/advertiserExit")
    public RetInfo advertiserExit(@RequestHeader(value = "token") String token){
        return advertiserCoreService.advertiserExit(token);
    }

    @ApiOperation("媒体主-帐号密码登录")
    @PostMapping(value = "/api/reader/back/mediaOwnerLogin")
    public RetInfo mediaOwnerLogin(@RequestBody LoginParam param,HttpServletRequest request){
        return mediaOwnerCoreService.mediaOwnerLogin(param,request);
    }

    @ApiOperation("媒体主账号密码退出")
    @PostMapping(value = "/api/reader/back/mediaOwnerExit")
    public RetInfo mediaOwnerExit(@RequestHeader(value = "token") String token){
        return mediaOwnerCoreService.mediaOwnerExit(token);
    }

}
