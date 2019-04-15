package com.xiaoma.service.base;

import com.xiaoma.bean.bo.SysUserAdvertisersExample;
import com.xiaoma.bean.po.SysUserAdvertisers;

import java.util.List;

/**
 * 广告主帐号信息领域级接口
 * @author mmh
 * @date 2019/3/18
 */

public interface UserAdvertiserService {

    SysUserAdvertisers queryAdvertiserInfo(String phoneNo);

    SysUserAdvertisers queryAdvertiserById(String advertiserId);

    int countAdvertisers(SysUserAdvertisersExample example);

    List<SysUserAdvertisers> queryAdvertiserList(SysUserAdvertisersExample example);

    int saveAdvertisers(SysUserAdvertisers record);

    int updateAdvertisersById(SysUserAdvertisers record);


}
