package com.xiaoma.controller.user;

import com.xiaoma.bean.dto.LoginParam;
import com.xiaoma.bean.dto.PassWordParam;
import com.xiaoma.service.core.AdminCoreService;
import com.xiaoma.utils.RetInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 管理员登录
 * @author mmh
 * @date 2019/3/20
 */
@RestController
public class AdminController {

    @Autowired
    private AdminCoreService adminCoreService;

    @ApiOperation("管理员登录")
    @PostMapping(value = "/api/reader/back/adminLogin")
    public RetInfo adminLogin(@RequestBody LoginParam param,HttpServletRequest request){
        return adminCoreService.adminLogin(param,request);
    }

    @ApiOperation("管理员退出")
    @PostMapping(value = "/api/reader/back/adminExit")
    public RetInfo adminExit(@RequestHeader(value = "token") String token){
        return adminCoreService.adminExit(token);
    }

    @ApiOperation("修改密码")
    @PostMapping(value = "/api/reader/back/adminUpdatePassword")
    public RetInfo adminUpdatePassword(@RequestBody PassWordParam param, @RequestHeader(value = "token") String token){
        return adminCoreService.adminUpdatePassword(param,token);
    }
}
