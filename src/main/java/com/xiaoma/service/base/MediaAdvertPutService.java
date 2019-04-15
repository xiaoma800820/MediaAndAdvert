package com.xiaoma.service.base;

import com.xiaoma.bean.bo.SysMediaAdvertPutExample;
import com.xiaoma.bean.po.SysMediaAdvertPut;

import java.util.List;

/**
 * 媒体投放广告领域级业务接口
 * @author mmh
 * @date 2019/3/26
 */
public interface MediaAdvertPutService {

    int batchSaveMediaAdvertPut(List<SysMediaAdvertPut> mediaAdvertPuts);

    List<SysMediaAdvertPut> queryByExample(SysMediaAdvertPutExample example);

    List<SysMediaAdvertPut> queryByPlanId(String planId);
}
