package com.xiaoma.service.base;

import com.xiaoma.bean.bo.SysUserMediaOwnerExample;
import com.xiaoma.bean.dto.MediaOwnerQryParam;
import com.xiaoma.bean.po.SysUserMediaOwner;
import com.xiaoma.utils.RetInfo;

import java.util.List;

/**
 * 媒体主帐号信息领域级接口
 * @author mmh
 * @date 2019/3/18
 */

public interface UserMediaOwnerService {

    int countMediaOwner(SysUserMediaOwnerExample example);

    List<SysUserMediaOwner> queryMediaOwnerList(SysUserMediaOwnerExample example);

    int saveMediaOwnerInfo(SysUserMediaOwner userMediaOwner);

    int updateMediaOwnerInfo(SysUserMediaOwner userMediaOwner);

    SysUserMediaOwner queryMediaOwnerInfo(String phoneNo);
}
