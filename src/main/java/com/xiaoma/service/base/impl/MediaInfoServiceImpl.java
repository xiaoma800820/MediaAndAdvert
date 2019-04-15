package com.xiaoma.service.base.impl;

import com.xiaoma.bean.bo.SysMediaInfoExample;
import com.xiaoma.bean.po.SysMediaInfo;
import com.xiaoma.dao.SysMediaInfoMapper;
import com.xiaoma.service.base.MediaInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 媒体信息领域级业务实现
 * @author mmh
 * @date 2019/3/25
 */
@Service
public class MediaInfoServiceImpl implements MediaInfoService {

    @Autowired
    private SysMediaInfoMapper mediaInfoMapper;


    @Override
    public int countByExmple(SysMediaInfoExample example) {
        return mediaInfoMapper.countByExample(example);
    }

    @Override
    public int saveMediaInfo(SysMediaInfo record) {
        return mediaInfoMapper.insert(record);
    }

    @Override
    public List<SysMediaInfo> queryMediaInfoList(SysMediaInfoExample example) {
        return mediaInfoMapper.selectByExample(example);
    }

    @Override
    public int updateMediaInfo(SysMediaInfo record) {
        return mediaInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public SysMediaInfo queryMediaInfoByMediaId(String mediaId) {
        return mediaInfoMapper.selectByPrimaryKey(mediaId);
    }
}
