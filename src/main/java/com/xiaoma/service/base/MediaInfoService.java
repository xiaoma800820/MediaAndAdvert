package com.xiaoma.service.base;

import com.xiaoma.bean.bo.SysMediaInfoExample;
import com.xiaoma.bean.po.SysMediaInfo;

import java.util.List;

/**
 * 媒体主领域级业务接口
 * @author mmh
 * @date 2019/3/25
 */
public interface MediaInfoService {

    int countByExmple(SysMediaInfoExample example);

    int saveMediaInfo(SysMediaInfo record);

    List<SysMediaInfo> queryMediaInfoList(SysMediaInfoExample example);

    int updateMediaInfo(SysMediaInfo record);

    SysMediaInfo queryMediaInfoByMediaId(String mediaId);
}
