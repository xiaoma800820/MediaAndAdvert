package com.xiaoma.service.core.impl;

import com.xiaoma.bean.dto.LoginParam;
import com.xiaoma.bean.dto.PassWordParam;
import com.xiaoma.bean.po.SysUserLoginLog;
import com.xiaoma.bean.po.SysUserManage;
import com.xiaoma.bean.vo.TokenUserVO;
import com.xiaoma.service.base.UserLoginLogService;
import com.xiaoma.service.base.UserManageService;
import com.xiaoma.service.core.AdminCoreService;
import com.xiaoma.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 管理员核心业务接口实现类
 * @author mmh
 * @date 2019/3/20
 */
@Slf4j
@Service
public class AdminCoreServiceImpl implements AdminCoreService {

    @Autowired
    private UserManageService userManageService;
    @Autowired
    private UserLoginLogService userLoginLogService;
    @Autowired
    private RedisClient redisClient;

    /**
     * 管理员登录
     * @param param 参数
     * @return 结果码
     */
    @Override
    public RetInfo adminLogin(LoginParam param,HttpServletRequest request) {
        log.info("===adminLogin begin===" + param);
        RetInfo retInfo = new RetInfo();
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validMobilePhone(param.getUserPhone());
        ParamCheckUtil.validParamStrNotNull(param.getPassWord());
        SysUserManage manage = userManageService.queryByPhone(param.getUserPhone());
        SysUserLoginLog loginLog = new SysUserLoginLog();
        loginLog.setLoginAccount(param.getUserPhone());
        loginLog.setLoginTime(new Date());
        loginLog.setLoginIp(IpUtil.getIpAddr(request));
        if (manage == null){
            retInfo.setResultCodes(ResultCodes.FAILED);
            retInfo.setMessage("手机帐号不存在");
            log.error("手机帐号不存在>>>" + param.getUserPhone());
        }else {
            String passWord = manage.getPassword();
            if (passWord.equals(MD5Util.code(param.getPassWord()))){
                String token = CommonConstant.READER_ADMIN_KEY + CommonConstant.getUUID();
                //保存登录日志,更新登录时间和次数
                String key = CommonConstant.READER_ADMIN_KEY + manage.getUserName();
                if (redisClient.hasKey(key)){
                    String oldToken = (String) redisClient.get(key,String.class);
                    redisClient.delete(oldToken);
                }
                TokenUserVO tokenUserVO = new TokenUserVO();
                tokenUserVO.setBalance(0);
                tokenUserVO.setUserId(manage.getUserId().toString());
                tokenUserVO.setContactName(manage.getContactName());
                tokenUserVO.setPhoneNo(manage.getUserName());
                tokenUserVO.setToken(token);
                tokenUserVO.setDocType(CommonConstant.STANDARD_ONE);
                redisClient.set(key,token,1, TimeUnit.DAYS);
                redisClient.set(token,tokenUserVO,1, TimeUnit.DAYS);
                loginLog.setToken(token);
                retInfo.setResultCodes(ResultCodes.SUCCESS);
                retInfo.setData(tokenUserVO);
            }else {
                retInfo.setResultCodes(ResultCodes.FAILED);
                retInfo.setMessage("密码错误");
            }
        }
        loginLog.setLgoinDesc(retInfo.getMessage());
        userLoginLogService.saveLoginLog(loginLog);
        log.info("===adminLogin end===");
        return retInfo;
    }

    @Override
    public RetInfo adminExit(String token) {
        log.info("===adminExit begin===" + token);
        RetInfo retInfo = new RetInfo();
        if (redisClient.hasKey(token)){
            redisClient.delete(token);
        }
        retInfo.setResultCodes(ResultCodes.SUCCESS);
        log.info("===adminExit end===");
        return retInfo;
    }

    @Override
    public RetInfo adminUpdatePassword(PassWordParam param, String token) {
        log.info("===adminUpdatePassword begin ==="+ param);
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validParamStrNotNull(param.getNewPassWord());
        RetInfo retInfo = new RetInfo();
        TokenUserVO tokenUserVO = (TokenUserVO) redisClient.get(token,TokenUserVO.class);
        SysUserManage sysUserManage = userManageService.queryByPhone(tokenUserVO.getPhoneNo());
        if (sysUserManage.getPassword().equals(MD5Util.code(param.getOldPassWord()))){
            SysUserManage userManage = new SysUserManage();
            userManage.setUserId(sysUserManage.getUserId());
            userManage.setPassword(MD5Util.code(param.getNewPassWord()));
            userManage.setUpdateTime(new Date());
            userManageService.updateUserManageInfo(userManage);
            retInfo.setResultCodes(ResultCodes.SUCCESS);
        }else {
            retInfo.setResultCodes(ResultCodes.FAILED);
            retInfo.setMessage("原密码不正确");
        }
        log.info("===adminUpdatePassword end ===");
        return retInfo;
    }
}
