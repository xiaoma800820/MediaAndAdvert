package com.xiaoma.controller.conf;

import com.xiaoma.bean.dto.MediaTypeAddParam;
import com.xiaoma.bean.dto.ShowTypeAddParam;
import com.xiaoma.service.core.ConfigCoreService;
import com.xiaoma.utils.RetInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 基本配置数据字典
 * ShowTypeVO
 * @author mmh
 * @date 2019/3/27
 */
@RestController
public class BaseConfigController {

    @Autowired
    private ConfigCoreService configCoreService;

    @ApiOperation("广告展示类型新增")
    @PostMapping(value = "/api/reader/back/saveAdvertShowType")
    public RetInfo saveAdvertShowType(@RequestBody ShowTypeAddParam param){
        return configCoreService.saveAdvertShowType(param);
    }

    @ApiOperation("广告展示类型列表：可使用的")
    @PostMapping(value = "/api/reader/back/queryEnableShowTypeList")
    public RetInfo queryEnableShowTypeList(){
        return configCoreService.queryEnableShowTypeList();
    }

    @ApiOperation("媒体类型新增")
    @PostMapping(value = "/api/reader/back/saveMediaType")
    public RetInfo saveMediaType(@RequestBody MediaTypeAddParam param){
        return configCoreService.saveMediaType(param);
    }

    @ApiOperation("媒体类型列表：可使用的")
    @PostMapping(value = "/api/reader/back/queryEnableMediaType")
    public RetInfo queryEnableMediaType(){
        return configCoreService.queryEnableMediaType();
    }

    @ApiOperation("计费形式列表：可使用")
    @PostMapping(value = "/api/reader/back/queryEnableBillingList")
    public RetInfo queryEnableBillingList(){
        return configCoreService.queryEnableBillingList();
    }
}
