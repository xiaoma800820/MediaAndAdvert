package com.xiaoma.service.base.impl;

import com.xiaoma.bean.bo.SysAdvertAdvertiserBO;
import com.xiaoma.bean.bo.SysAdvertMediaBO;
import com.xiaoma.bean.po.SysAdvertPlayRecord;
import com.xiaoma.dao.SysAdvertPlayRecordMapper;
import com.xiaoma.service.base.PlayRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2019/4/8.
 */
@Service
public class PlayRecordServiceImpl implements PlayRecordService {

    @Autowired
    private SysAdvertPlayRecordMapper sysAdvertPlayRecordMapper;


    @Override
    public int savePlayRecord(SysAdvertPlayRecord record) {
        return sysAdvertPlayRecordMapper.insert(record);
    }

    @Override
    public List<SysAdvertMediaBO> countQryAdvertMedia() {
        return sysAdvertPlayRecordMapper.statisticsAdvertsByMedia();
    }

    @Override
    public List<SysAdvertAdvertiserBO> countQryAdvertAdvertiser() {
        return sysAdvertPlayRecordMapper.statisticsAdvertsByAdvertiser();
    }

    @Override
    public int countPlayByAdvertDay(String advertId) {
        return sysAdvertPlayRecordMapper.cpuntByAdvertIdDay(advertId);
    }

    @Override
    public int countPlayByPlanIdDay(String planId) {
        return sysAdvertPlayRecordMapper.cpuntByPlanIdDay(planId);
    }
}
