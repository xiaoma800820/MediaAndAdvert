package com.xiaoma.service.core;

import com.xiaoma.bean.dto.*;
import com.xiaoma.utils.RetInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * 媒体主核心业务逻辑接口
 * @author mmh
 * @date 2019/3/26
 */
public interface MediaOwnerCoreService {

    RetInfo mediaOwnerAdd(MediaOwnerAddParam param);

    RetInfo queryMediaOwnerList(MediaOwnerQryParam param);

//    RetInfo mediaAccountPayeeAdd(PayeeAddParam param);

    RetInfo queryAccountPayeeInfo(PayeeQryParam payeeQryParam);

    RetInfo mediaOwnerLogin(LoginParam param, HttpServletRequest request);

    RetInfo mediaOwnerExit(String token);

    RetInfo mediaOwnerUpdatePassWord(String token, PassWordUpdateParam param);

    RetInfo queryMediaOwnerDetail(String token);

    RetInfo updateMediaOwnerInfo(MediaOwnerUpdateParam param);
}
