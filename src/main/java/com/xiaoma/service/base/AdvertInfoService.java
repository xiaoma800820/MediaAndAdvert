package com.xiaoma.service.base;

import com.xiaoma.bean.bo.SysAdvertInfoExample;
import com.xiaoma.bean.po.SysAdvertInfo;

import java.util.List;

/**
 * 广告领域级业务接口
 * @author mmh
 * @date 2019/3/20
 */
public interface AdvertInfoService {

    int saveAdvertInfo(SysAdvertInfo record);

    int countAdvertInfo(SysAdvertInfoExample example);

    int updateAdvertInfoById(SysAdvertInfo record);

    List<SysAdvertInfo> queryAdvertInfoList(SysAdvertInfoExample example);

    SysAdvertInfo queryAdvertInfoById(String advertId);

}
