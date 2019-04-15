package com.xiaoma.service.core;

import com.xiaoma.bean.dto.MediaTypeAddParam;
import com.xiaoma.bean.dto.ShowTypeAddParam;
import com.xiaoma.utils.RetInfo;

/**
 * 基本配置核心业务逻辑
 * @author mmh
 * @date 2019/3/27
 */
public interface ConfigCoreService {


    RetInfo saveAdvertShowType(ShowTypeAddParam param);

    RetInfo queryEnableShowTypeList();

    RetInfo saveMediaType(MediaTypeAddParam param);

    RetInfo queryEnableMediaType();

    RetInfo queryEnableBillingList();
}
