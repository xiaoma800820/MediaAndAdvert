package com.xiaoma.controller.androidandios;

import com.xiaoma.utils.RetInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 安卓和ios访问控制器
 * @author mmh
 * @date 2019/4/4
 */
@RestController
public class AndroidAndIosController {


    @ApiOperation("查询广告主投放计划信息")
    @PostMapping(value = "/api/reader/mobile/queryAdvertiserPlanList")
    public RetInfo queryAdvertiserPlanList(){
        return null;
    }
}
