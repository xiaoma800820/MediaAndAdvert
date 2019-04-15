package com.xiaoma.controller.settle;

import com.xiaoma.bean.dto.MediaOwnerQryParam;
import com.xiaoma.bean.dto.SettleParam;
import com.xiaoma.service.core.SettleCoreService;
import com.xiaoma.utils.PageInfo;
import com.xiaoma.utils.RetInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 结算单访问控制器
 * @author mmh
 * @date 2019/4/8
 */
@RestController
public class SettleController {


    @Autowired
    private SettleCoreService settleCoreService;


    @ApiOperation("财务管理-平台账户")
    @PostMapping(value = "/api/reader/back/querySettleList")
    public RetInfo querySettleList(@RequestBody PageInfo pageInfo){
        return settleCoreService.querySettleList(pageInfo);
    }

    @ApiOperation("财务管理-待结算")
    @PostMapping(value = "/api/reader/back/queryWaitSettleList")
    public RetInfo queryWaitSettleList(@RequestBody MediaOwnerQryParam param){
        return settleCoreService.queryWaitSettleList(param);
    }

    @ApiOperation("财务管理-结算")
    @PostMapping(value = "/api/reader/back/finishSettle")
    public RetInfo finishSettle(@RequestBody SettleParam param){
        return settleCoreService.finishSettle(param);
    }

    @ApiOperation("媒体主-财务管理")
    @PostMapping(value = "/api/reader/back/queryMediaSettleList")
    public RetInfo queryMediaSettleList(@RequestBody PageInfo pageInfo, @RequestHeader(value = "token") String token){
        return settleCoreService.queryMediaSettleList(pageInfo,token);
    }

    @ApiOperation("广告主-财务管理")
    @PostMapping(value = "/api/reader/back/queryAdvertSettleList")
    public RetInfo queryAdvertSettleList(@RequestBody PageInfo pageInfo, @RequestHeader(value = "token") String token){
        return settleCoreService.queryAdvertSettleList(pageInfo,token);
    }
}
