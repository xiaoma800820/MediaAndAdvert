package com.xiaoma.dao;

import com.xiaoma.bean.bo.SysAdvertAdvertiserBO;
import com.xiaoma.bean.bo.SysAdvertMediaBO;
import com.xiaoma.bean.po.SysAdvertPlayRecord;
import com.xiaoma.bean.bo.SysAdvertPlayRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAdvertPlayRecordMapper {

    List<SysAdvertAdvertiserBO> statisticsAdvertsByAdvertiser();

    List<SysAdvertMediaBO> statisticsAdvertsByMedia();

    int countByExample(SysAdvertPlayRecordExample example);

    int cpuntByAdvertIdDay(String advertId);

    int cpuntByPlanIdDay(String planId);

    int insert(SysAdvertPlayRecord record);

    int insertSelective(SysAdvertPlayRecord record);

    List<SysAdvertPlayRecord> selectByExample(SysAdvertPlayRecordExample example);

    SysAdvertPlayRecord selectByPrimaryKey(Long playRecordId);

    int updateByExampleSelective(@Param("record") SysAdvertPlayRecord record, @Param("example") SysAdvertPlayRecordExample example);

    int updateByExample(@Param("record") SysAdvertPlayRecord record, @Param("example") SysAdvertPlayRecordExample example);

    int updateByPrimaryKeySelective(SysAdvertPlayRecord record);

    int updateByPrimaryKey(SysAdvertPlayRecord record);
}