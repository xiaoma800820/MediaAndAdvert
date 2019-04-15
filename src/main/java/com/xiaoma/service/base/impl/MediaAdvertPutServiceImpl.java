package com.xiaoma.service.base.impl;

import com.xiaoma.bean.bo.SysMediaAdvertPutExample;
import com.xiaoma.bean.po.SysMediaAdvertPut;
import com.xiaoma.dao.SysMediaAdvertPutMapper;
import com.xiaoma.service.base.MediaAdvertPutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 媒体投放广告领域级业务实现
 * @author mmh
 * @date 2019/3/26
 */
@Service
public class MediaAdvertPutServiceImpl implements MediaAdvertPutService {

    @Autowired
    private SysMediaAdvertPutMapper mediaAdvertPutMapper;

    @Override
    public int batchSaveMediaAdvertPut(List<SysMediaAdvertPut> mediaAdvertPuts) {
        return mediaAdvertPutMapper.insertByMediaAdvertPutList(mediaAdvertPuts);
    }

    @Override
    public List<SysMediaAdvertPut> queryByExample(SysMediaAdvertPutExample example) {
        return mediaAdvertPutMapper.selectByExample(example);
    }

    @Override
    public List<SysMediaAdvertPut> queryByPlanId(String planId) {
        return mediaAdvertPutMapper.selectByPlanId(planId);
    }
}
