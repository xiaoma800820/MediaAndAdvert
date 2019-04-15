package com.xiaoma.service.core;

import com.xiaoma.bean.dto.*;
import com.xiaoma.utils.PageInfo;
import com.xiaoma.utils.RetInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * 广告主核心业务逻辑类
 * @author mmh
 * @date 2019/3/18
 */
public interface AdvertiserCoreService {

    /**
     * 广告主账号密码登录
     * @param param 帐号密码
     * @return 结果码
     */
    RetInfo advertiserLogin(LoginParam param,HttpServletRequest request);

    /**
     * 广告主退出登录
     * @param token 访问token
     * @return 结果码
     */
    RetInfo advertiserExit(String token);

    /**
     * 广告主列表查询
     * @param param 分页参数
     * @return 结果
     */
    RetInfo queryAdvertiserList(AdvertiserQryParam param);

    /**
     * 广告主信息添加
     * @param param 参数
     * @return 结果码
     */
    RetInfo advertiserInfoAdd(AdvertiserAddParam param);

    /**
     * 广告主个人信息查询
     * @param token 访问token
     * @return 结果
     */
    RetInfo advertiserInfoDetail(String token);

    /**
     * 广告主个人信息更新
     * @param param 更新参数
     * @return 结果码
     */
    RetInfo advertInfoUpdate(AdvertiserEditParam param);

    /**
     * 广告主更新密码
     * @param token 访问token
     * @param param 结果码
     * @return 结果码
     */
    RetInfo advertiserPassWordUpdate(String token,PassWordUpdateParam param);
}
