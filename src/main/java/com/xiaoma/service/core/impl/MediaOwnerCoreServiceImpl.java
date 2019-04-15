package com.xiaoma.service.core.impl;

import com.xiaoma.bean.bo.SysUserMediaOwnerExample;
import com.xiaoma.bean.dto.*;
import com.xiaoma.bean.po.SysAccountPayee;
import com.xiaoma.bean.po.SysUserLoginLog;
import com.xiaoma.bean.po.SysUserMediaOwner;
import com.xiaoma.bean.vo.MediaOwnerInfoVO;
import com.xiaoma.bean.vo.MediaOwnerListVO;
import com.xiaoma.bean.vo.PayeeVO;
import com.xiaoma.bean.vo.TokenUserVO;
import com.xiaoma.service.base.*;
import com.xiaoma.service.core.MediaOwnerCoreService;
import com.xiaoma.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 媒体主核心业务逻辑实现
 * @author mmh
 * @date 2019/3/26
 */
@Slf4j
@Service
public class MediaOwnerCoreServiceImpl implements MediaOwnerCoreService {

    @Autowired
    private UserMediaOwnerService mediaOwnerService;
    @Autowired
    private AccountPayeeService accountPayeeService;
    @Autowired
    private UserLoginLogService userLoginLogService;
    @Autowired
    private RedisClient redisClient;


    @Override
    public RetInfo mediaOwnerAdd(MediaOwnerAddParam param) {
        RetInfo retInfo = new RetInfo();
        log.info("===mediaOwnerAdd begin ===" + param);
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            SysUserMediaOwner mediaOwnerDB = mediaOwnerService.queryMediaOwnerInfo(param.getMediaPhone());
            if (mediaOwnerDB == null){
                SysUserMediaOwner mediaOwner = new SysUserMediaOwner();
                int totalNum = mediaOwnerService.countMediaOwner(null);
                String userId = CommonConstant.getCodeId("MTZ", 4, totalNum);
                BeanUtils.copyProperties(param,mediaOwner);
                mediaOwner.setMediaOwnerId(userId);
                mediaOwner.setCurrentBalance(0L);
                mediaOwner.setCreateTime(new Date());
                mediaOwner.setPassWord(MD5Util.code(param.getPassWord()));
                mediaOwnerService.saveMediaOwnerInfo(mediaOwner);
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
        log.info("===mediaOwnerAdd end ===");
        return retInfo;
    }

    @Override
    public RetInfo queryMediaOwnerList(MediaOwnerQryParam param) {
        log.info("===queryMediaOwnerList begin ===" + param);
        RetInfo retInfo = new RetInfo();
        SysUserMediaOwnerExample example = new SysUserMediaOwnerExample();
        SysUserMediaOwnerExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(param.getMediaPhone())){
            criteria.andMediaPhoneLike(param.getMediaPhone());
        }
        int totalRow = mediaOwnerService.countMediaOwner(example);
        if (totalRow > CommonConstant.STANDARD_ZERO){
            PageUtil pageUtil = new PageUtil(param.getPageSize(),param.getPageNo());
            pageUtil.setTotalCount(totalRow);
            example.setDistinct(true);
            example.setOrderByClause(" create_time DESC " + pageUtil.getLimitCriterion());
            List<SysUserMediaOwner> userMediaOwners = mediaOwnerService.queryMediaOwnerList(example);
            if (userMediaOwners != null && !userMediaOwners.isEmpty()){
                List<MediaOwnerListVO> mediaOwnerListVOS = new ArrayList<>(userMediaOwners.size());
                for (SysUserMediaOwner mediaOwner : userMediaOwners){
                    MediaOwnerListVO mediaOwnerListVO = new MediaOwnerListVO();
                    BeanUtils.copyProperties(mediaOwner,mediaOwnerListVO);
                    if (!StringUtils.isEmpty(mediaOwner.getPayeeId())){
                        SysAccountPayee payee = accountPayeeService.queryPayeeInfoById(mediaOwner.getPayeeId());
                        mediaOwnerListVO.setPayeeName(payee.getTypeName());
                    }
                    mediaOwnerListVOS.add(mediaOwnerListVO);
                }
                retInfo.setResultCodes(ResultCodes.SUCCESS);
                retInfo.setData(mediaOwnerListVOS);
                retInfo.setPages(pageUtil.getTotalPages());
            }else {
                retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
            }
        }else {
            retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
        }
        log.info("===queryMediaOwnerList end===");
        return retInfo;
    }

//    @Transactional
//    @Override
//    public RetInfo mediaAccountPayeeAdd(PayeeAddParam param) {
//        log.info("===mediaAccountPayeeAdd begin===" + param);
//        RetInfo retInfo = new RetInfo();
//        String payeeId = CommonConstant.getUUID();
//        SysAccountPayee sysAccountPayee = new SysAccountPayee();
//        BeanUtils.copyProperties(param,sysAccountPayee);
//        sysAccountPayee.setCreateTime(new Date());
//        sysAccountPayee.setPayeeId(payeeId);
//        accountPayeeService.saveAccountPayeeInfo(sysAccountPayee);
//        SysUserMediaOwner mediaOwner = new SysUserMediaOwner();
//        mediaOwner.setMediaOwnerId(param.getOwnerId());
//        mediaOwner.setUpdateTime(new Date());
//        mediaOwner.setPayeeId(payeeId);
//        mediaOwnerService.updateMediaOwnerInfo(mediaOwner);
//        retInfo.setResultCodes(ResultCodes.SUCCESS);
//        log.info("===mediaAccountPayeeAdd end===");
//        return retInfo;
//    }

    @Override
    public RetInfo queryAccountPayeeInfo(PayeeQryParam payeeQryParam) {
        log.info("===queryAccountPayeeInfo begin===" + payeeQryParam);
        ParamCheckUtil.validParamObjectNull(payeeQryParam);
        ParamCheckUtil.validParamStrNotNull(payeeQryParam.getPayeeId());
        RetInfo retInfo = new RetInfo();
        SysAccountPayee accountPayee = accountPayeeService.queryPayeeInfoById(payeeQryParam.getPayeeId());
        retInfo.setResultCodes(ResultCodes.SUCCESS);
        retInfo.setData(accountPayee);
        log.info("===queryAccountPayeeInfo end===");
        return retInfo;
    }

    @Override
    public RetInfo mediaOwnerLogin(LoginParam param, HttpServletRequest request) {
        log.info("===mediaOwnerLogin begin===" + param);
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validMobilePhone(param.getUserPhone());
        ParamCheckUtil.validParamStrNotNull(param.getPassWord());
        SysUserMediaOwner mediaOwner = mediaOwnerService.queryMediaOwnerInfo(param.getUserPhone());
        RetInfo retInfo = new RetInfo();
        SysUserLoginLog loginLog = new SysUserLoginLog();
        loginLog.setLoginAccount(param.getUserPhone());
        loginLog.setLoginTime(new Date());
        loginLog.setLoginIp(IpUtil.getIpAddr(request));
        if (mediaOwner == null){
            retInfo.setResultCodes(ResultCodes.FAILED);
            retInfo.setMessage("手机帐号不存在");
            log.error("手机帐号不存在>>>" + param.getUserPhone());
        }else {
            String passWord = mediaOwner.getPassWord();
            if (passWord.equals(MD5Util.code(param.getPassWord()))){
                String token = CommonConstant.READER_MEDIA_KEY + CommonConstant.getUUID();
                //保存登录日志,更新登录时间和次数
                String key = CommonConstant.READER_MEDIA_KEY + mediaOwner.getMediaPhone();
                if (redisClient.hasKey(key)){
                    String oldToken = (String) redisClient.get(key,String.class);
                    redisClient.delete(oldToken);
                }
                TokenUserVO tokenUserVO = new TokenUserVO();
                tokenUserVO.setBalance(mediaOwner.getCurrentBalance());
                tokenUserVO.setUserId(mediaOwner.getMediaOwnerId());
                tokenUserVO.setContactName(mediaOwner.getContactsName());
                tokenUserVO.setPhoneNo(mediaOwner.getMediaPhone());
                tokenUserVO.setToken(token);
                tokenUserVO.setDocType(CommonConstant.STANDARD_THREE);
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
        log.info("===mediaOwnerLogin end===");
        return retInfo;
    }

    @Override
    public RetInfo mediaOwnerExit(String token) {
        log.info("===mediaOwnerExit begin===" + token);
        RetInfo retInfo = new RetInfo();
        if (redisClient.hasKey(token)){
            redisClient.delete(token);
        }
        retInfo.setResultCodes(ResultCodes.SUCCESS);
        log.info("===mediaOwnerExit end ===");
        return retInfo;
    }

    @Override
    public RetInfo mediaOwnerUpdatePassWord(String token, PassWordUpdateParam param) {
        log.info("===mediaOwnerUpdatePassWord begin===" + param);
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validParamStrNotNull(param.getNewPassWord());
        ParamCheckUtil.validParamStrNotNull(param.getOldPassWord());
        RetInfo retInfo = new RetInfo();
        TokenUserVO tokenUserVO = (TokenUserVO) redisClient.get(token,TokenUserVO.class);
        SysUserMediaOwner userMediaOwner = mediaOwnerService.queryMediaOwnerInfo(tokenUserVO.getPhoneNo());
        if (userMediaOwner.getPassWord().equals(MD5Util.code(param.getOldPassWord()))){
            SysUserMediaOwner mediaOwnerTemp = new SysUserMediaOwner();
            mediaOwnerTemp.setMediaOwnerId(userMediaOwner.getMediaOwnerId());
            mediaOwnerTemp.setPassWord(MD5Util.code(param.getNewPassWord()));
            mediaOwnerTemp.setUpdateTime(new Date());
            mediaOwnerService.updateMediaOwnerInfo(mediaOwnerTemp);
            retInfo.setResultCodes(ResultCodes.SUCCESS);
        }else {
            retInfo.setResultCodes(ResultCodes.FAILED);
            retInfo.setMessage("原密码不正确");
        }
        log.info("===mediaOwnerUpdatePassWord end===");
        return retInfo;
    }

    @Override
    public RetInfo queryMediaOwnerDetail(String token) {
        log.info("===queryMediaOwnerDetail begin===");
        RetInfo retInfo = new RetInfo();
        TokenUserVO tokenUserVO = (TokenUserVO) redisClient.get(token,TokenUserVO.class);
        SysUserMediaOwner mediaOwner = mediaOwnerService.queryMediaOwnerInfo(tokenUserVO.getPhoneNo());
        if (mediaOwner == null){
            retInfo.setResultCodes(ResultCodes.FAILED);
            retInfo.setMessage("媒体主用户不存在");
        }else {
            MediaOwnerInfoVO mediaOwnerInfoVO = new MediaOwnerInfoVO();
            BeanUtils.copyProperties(mediaOwner,mediaOwnerInfoVO);
            if (!StringUtils.isEmpty(mediaOwner.getPayeeId())){
                SysAccountPayee accountPayee = accountPayeeService.queryPayeeInfoById(mediaOwner.getPayeeId());
                PayeeVO payeeVO = new PayeeVO();
                BeanUtils.copyProperties(accountPayee,payeeVO);
                mediaOwnerInfoVO.setPayeeVO(payeeVO);
            }
            retInfo.setResultCodes(ResultCodes.SUCCESS);
            retInfo.setData(mediaOwnerInfoVO);
        }
        log.info("===queryMediaOwnerDetail end===");
        return retInfo;
    }

    @Transactional
    @Override
    public RetInfo updateMediaOwnerInfo(MediaOwnerUpdateParam param) {
        log.info("===updateMediaOwnerInfo begin===" + param);
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validParamStrNotNull(param.getMediaOwnerId());
        RetInfo retInfo = new RetInfo();
        SysUserMediaOwner mediaOwner = new SysUserMediaOwner();
        mediaOwner.setMediaOwnerId(param.getMediaOwnerId());
        mediaOwner.setUpdateTime(new Date());
        mediaOwner.setContactsName(param.getContactsName());
        mediaOwner.setSex(param.getSex());
        if (param.getPayeeVO() != null){
            if (StringUtils.isEmpty(param.getPayeeVO().getPayeeId())){
                String payeeId = CommonConstant.getUUID();
                mediaOwner.setPayeeId(payeeId);
                SysAccountPayee sysAccountPayee = new SysAccountPayee();
                BeanUtils.copyProperties(param.getPayeeVO(),sysAccountPayee);
                sysAccountPayee.setCreateTime(new Date());
                sysAccountPayee.setPayeeId(payeeId);
                accountPayeeService.saveAccountPayeeInfo(sysAccountPayee);
            }else {
                PayeeVO payeeVO = param.getPayeeVO();
                SysAccountPayee accountPayee = new SysAccountPayee();
                BeanUtils.copyProperties(payeeVO,accountPayee);
                accountPayeeService.updateAccountPayeeInfo(accountPayee);
            }
        }
        mediaOwnerService.updateMediaOwnerInfo(mediaOwner);
        retInfo.setResultCodes(ResultCodes.SUCCESS);
        log.info("===updateMediaOwnerInfo end===");
        return retInfo;
    }
}
