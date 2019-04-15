package com.xiaoma.service.core.impl;

import com.xiaoma.bean.bo.SysUserAdvertisersExample;
import com.xiaoma.bean.dto.*;
import com.xiaoma.bean.po.SysUserAdvertisers;
import com.xiaoma.bean.po.SysUserLoginLog;
import com.xiaoma.bean.vo.AdvertiserInfoVo;
import com.xiaoma.bean.vo.TokenUserVO;
import com.xiaoma.service.base.UserAdvertiserService;
import com.xiaoma.service.base.UserLoginLogService;
import com.xiaoma.service.core.AdvertiserCoreService;
import com.xiaoma.service.core.LoginLogCoreService;
import com.xiaoma.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 广告主核心业务逻辑实现类
 * @author mmh
 * @date 2019/3/18
 */
@Slf4j
@Service
public class AdvertiserCoreServiceImpl implements AdvertiserCoreService {


    @Autowired
    private UserAdvertiserService userAdvertiserService;
    @Autowired
    private RedisClient redisClient;

    @Autowired
    private UserLoginLogService userLoginLogService;

    /**
     * 广告主账号密码登录
     * @param param 帐号密码
     * @return 结果码
     */
    @Override
    public RetInfo advertiserLogin(LoginParam param,HttpServletRequest request) {
        log.info("===advertiserLogin begin===" + param);
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validMobilePhone(param.getUserPhone());
        ParamCheckUtil.validParamStrNotNull(param.getPassWord());
        SysUserAdvertisers advertisers = userAdvertiserService.queryAdvertiserInfo(param.getUserPhone());
        RetInfo retInfo = new RetInfo();
        SysUserLoginLog loginLog = new SysUserLoginLog();
        loginLog.setLoginAccount(param.getUserPhone());
        loginLog.setLoginTime(new Date());
        loginLog.setLoginIp(IpUtil.getIpAddr(request));
        if (advertisers == null){
            retInfo.setResultCodes(ResultCodes.FAILED);
            retInfo.setMessage("手机帐号不存在");
            log.error("手机帐号不存在>>>" + param.getUserPhone());
        }else if (advertisers.getStatus() == CommonConstant.STANDARD_ZERO){
            retInfo.setResultCodes(ResultCodes.FAILED);
            retInfo.setMessage("帐号被锁定，请联系管理员");
        }else {
            String passWord = advertisers.getPassWord();
            if (passWord.equals(MD5Util.code(param.getPassWord()))){
                String token = CommonConstant.READER_ADVERT_KEY + CommonConstant.getUUID();
                //保存登录日志,更新登录时间和次数
                String key = CommonConstant.READER_ADVERT_KEY + advertisers.getAdvertiserPhone();
                if (redisClient.hasKey(key)){
                    String oldToken = (String) redisClient.get(key,String.class);
                    redisClient.delete(oldToken);
                }
                TokenUserVO tokenUserVO = new TokenUserVO();
                tokenUserVO.setBalance(advertisers.getAccountBalance());
                tokenUserVO.setUserId(advertisers.getAdvertiserId().toString());
                tokenUserVO.setContactName(advertisers.getContactName());
                tokenUserVO.setPhoneNo(advertisers.getAdvertiserPhone());
                tokenUserVO.setToken(token);
                tokenUserVO.setDocType(CommonConstant.STANDARD_TWO);
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
        log.info("===advertiserLogin end===");
        return retInfo;
    }

    /**
     * 广告主退出登录
     * @param token 访问token
     * @return 结果码
     */
    @Override
    public RetInfo advertiserExit(String token) {
        log.info("===advertiserExit begin===" + token);
        RetInfo retInfo = new RetInfo();
        if (redisClient.hasKey(token)){
            redisClient.delete(token);
        }
        retInfo.setResultCodes(ResultCodes.SUCCESS);
        log.info("===advertiserExit end ===");
        return retInfo;
    }

    /**
     * 广告主列表查询
     * @param param 分页参数
     * @return 结果
     */
    @Override
    public RetInfo queryAdvertiserList(AdvertiserQryParam param) {
        RetInfo retInfo = new RetInfo();
        log.info("===queryAdvertiserList begin===" + param);
        SysUserAdvertisersExample example = new SysUserAdvertisersExample();
        SysUserAdvertisersExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(param.getAdvertiserPhone())){
            criteria.andAdvertiserPhoneLike(param.getAdvertiserPhone());
        }
        int totalRow = userAdvertiserService.countAdvertisers(example);
        if (totalRow > CommonConstant.STANDARD_ZERO){
            PageUtil pageUtil = new PageUtil(param.getPageSize(),param.getPageNo());
            pageUtil.setTotalCount(totalRow);
            example.setDistinct(true);
            example.setOrderByClause(" create_time DESC " + pageUtil.getLimitCriterion());
            List<SysUserAdvertisers> advertisers = userAdvertiserService.queryAdvertiserList(example);
            if (advertisers != null && !advertisers.isEmpty()){
                retInfo.setResultCodes(ResultCodes.SUCCESS);
                retInfo.setData(advertisers);
                retInfo.setPages(pageUtil.getTotalPages());
            }else {
                retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
            }
        }else {
            retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
        }
        log.info("===queryAdvertiserList end===");
        return retInfo;
    }

    /**
     * 广告主信息添加
     * @param param 参数
     * @return 结果码
     */
    @Override
    public synchronized RetInfo advertiserInfoAdd(AdvertiserAddParam param) {
        RetInfo retInfo = new RetInfo();
        log.info("===advertiserInfoAdd begin ===" + param);
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            SysUserAdvertisers dbAdvert = userAdvertiserService.queryAdvertiserInfo(param.getAdvertiserPhone());
            if (dbAdvert == null){
                SysUserAdvertisers userAdvertisers = new SysUserAdvertisers();
                int totalNum = userAdvertiserService.countAdvertisers(null);
                String userId = CommonConstant.getCodeId(CommonConstant.ADVERTISER_PRE, 4, totalNum);
                userAdvertisers.setAdvertiserId(userId);
                BeanUtils.copyProperties(param,userAdvertisers);
                userAdvertisers.setAccountBalance(0L);
                userAdvertisers.setCreateTime(new Date());
                userAdvertisers.setStatus(CommonConstant.STANDARD_ONE);
                userAdvertisers.setPassWord(MD5Util.code(param.getPassWord()));
                userAdvertiserService.saveAdvertisers(userAdvertisers);
                retInfo.setResultCodes(ResultCodes.SUCCESS);
            }else {
                retInfo.setResultCodes(ResultCodes.FAILED);
                retInfo.setMessage("手机号已被使用");
            }
        }catch (RuntimeException e){
            e.printStackTrace();
            retInfo.setResultCodes(ResultCodes.FAILED);
        }finally {
            lock.unlock();
        }
        log.info("===advertiserInfoAdd end ===");
        return retInfo;
    }

    /**
     * 广告主个人信息查询
     * @param token 访问token
     * @return 结果
     */
    @Override
    public RetInfo advertiserInfoDetail(String token) {
        log.info("===advertiserInfoDetail begin===" + token);
        RetInfo retInfo = new RetInfo();
        TokenUserVO tokenUserVO = (TokenUserVO) redisClient.get(token,TokenUserVO.class);
        SysUserAdvertisers advertisers = userAdvertiserService.queryAdvertiserById(tokenUserVO.getUserId());
        AdvertiserInfoVo advertiserInfoVo = new AdvertiserInfoVo();
        BeanUtils.copyProperties(advertisers,advertiserInfoVo);
        retInfo.setResultCodes(ResultCodes.SUCCESS);
        retInfo.setData(advertiserInfoVo);
        log.info("===advertiserInfoDetail end===");
        return retInfo;
    }

    /**
     * 广告主个人信息更新
     * @param param 更新参数
     * @return 结果码
     */
    @Override
    public RetInfo advertInfoUpdate(AdvertiserEditParam param) {
        log.info("===advertInfoUpdate begin===" + param);
        RetInfo retInfo = new RetInfo();
        SysUserAdvertisers record = new SysUserAdvertisers();
        BeanUtils.copyProperties(param,record);
        userAdvertiserService.updateAdvertisersById(record);
        retInfo.setResultCodes(ResultCodes.SUCCESS);
        log.info("===advertInfoUpdate end===");
        return retInfo;
    }

    /**
     * 广告主更新密码
     * @param token 访问token
     * @param param 结果码
     * @return 结果码
     */
    @Override
    public RetInfo advertiserPassWordUpdate(String token, PassWordUpdateParam param) {
        log.info("===advertiserPassWordUpdate begin===" + param);
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validParamStrNotNull(param.getNewPassWord());
        ParamCheckUtil.validParamStrNotNull(param.getOldPassWord());
        RetInfo retInfo = new RetInfo();
        TokenUserVO tokenUserVO = (TokenUserVO) redisClient.get(token,TokenUserVO.class);
        SysUserAdvertisers advertisers = userAdvertiserService.queryAdvertiserById(tokenUserVO.getUserId());
        if (advertisers.getPassWord().equals(MD5Util.code(param.getOldPassWord()))){
            SysUserAdvertisers advertisersTemp = new SysUserAdvertisers();
            advertisersTemp.setAdvertiserId(advertisers.getAdvertiserId());
            advertisersTemp.setPassWord(MD5Util.code(param.getNewPassWord()));
            userAdvertiserService.updateAdvertisersById(advertisersTemp);
            retInfo.setResultCodes(ResultCodes.SUCCESS);
        }else {
            retInfo.setResultCodes(ResultCodes.FAILED);
            retInfo.setMessage("原密码不正确");
        }
        log.info("===advertiserPassWordUpdate end===");
        return retInfo;
    }
}
