package com.xiaoma.service.base;

import com.xiaoma.bean.bo.SysAdvertAdvertiserBO;
import com.xiaoma.bean.bo.SysAdvertMediaBO;
import com.xiaoma.bean.po.SysAdvertPlayRecord;

import java.util.List;

/**
 * Created by Administrator on 2019/4/8.
 */
public interface PlayRecordService {

    int savePlayRecord(SysAdvertPlayRecord record);

    List<SysAdvertMediaBO> countQryAdvertMedia();

    List<SysAdvertAdvertiserBO> countQryAdvertAdvertiser();

    int countPlayByAdvertDay(String advertId);

    int countPlayByPlanIdDay(String planId);
}
