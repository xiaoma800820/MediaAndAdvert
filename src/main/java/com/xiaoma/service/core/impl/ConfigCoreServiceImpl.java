package com.xiaoma.service.core.impl;

import com.xiaoma.bean.bo.SysAdvertShowTypeExample;
import com.xiaoma.bean.bo.SysBillingConfigExample;
import com.xiaoma.bean.bo.SysMediaTypeExample;
import com.xiaoma.bean.dto.MediaTypeAddParam;
import com.xiaoma.bean.dto.ShowTypeAddParam;
import com.xiaoma.bean.po.SysAdvertShowType;
import com.xiaoma.bean.po.SysBillingConfig;
import com.xiaoma.bean.po.SysMediaType;
import com.xiaoma.bean.vo.BillingConfigVO;
import com.xiaoma.bean.vo.MediaTypeVO;
import com.xiaoma.bean.vo.ShowTypeVO;
import com.xiaoma.service.base.BillingConfigService;
import com.xiaoma.service.base.MediaTypeService;
import com.xiaoma.service.base.ShowTypeService;
import com.xiaoma.service.core.ConfigCoreService;
import com.xiaoma.utils.CommonConstant;
import com.xiaoma.utils.ParamCheckUtil;
import com.xiaoma.utils.ResultCodes;
import com.xiaoma.utils.RetInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 基本配置参数核心业务逻辑
 * @author mmh
 * @date 2019/3/27
 */
@Slf4j
@Service
public class ConfigCoreServiceImpl implements ConfigCoreService {


    @Autowired
    private ShowTypeService showTypeService;
    @Autowired
    private MediaTypeService mediaTypeService;
    @Autowired
    private BillingConfigService billingConfigService;


    @Override
    public RetInfo saveAdvertShowType(ShowTypeAddParam param) {
        log.info("===saveAdvertShowType begin===" + param);
        RetInfo retInfo = new RetInfo();
        ParamCheckUtil.validParamStrNotNull(param.getShowCode());
        ParamCheckUtil.validParamStrNotNull(param.getShowName());
        ParamCheckUtil.validParamStrNotNull(param.getShowDesc());
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            SysAdvertShowType dbAdvertShowType = showTypeService.queryShowTypeInfo(param.getShowCode());
            if (dbAdvertShowType != null){
                retInfo.setResultCodes(ResultCodes.FAILED);
                retInfo.setMessage("编码已被使用");
            }else {
                SysAdvertShowType sysAdvertShowType = new SysAdvertShowType();
                BeanUtils.copyProperties(param,sysAdvertShowType);
                sysAdvertShowType.setAdvertDr(CommonConstant.STANDARD_ONE);
                sysAdvertShowType.setCreateTime(new Date());
                showTypeService.saveShowTypeInfo(sysAdvertShowType);
                retInfo.setResultCodes(ResultCodes.SUCCESS);
            }
        }catch (Exception e){
            e.printStackTrace();
            retInfo.setResultCodes(ResultCodes.FAILED);
        }finally {
            lock.unlock();
        }
        log.info("===saveAdvertShowType end===");
        return retInfo;
    }

    @Override
    public RetInfo queryEnableShowTypeList() {
        log.info("===queryEnableShowTypeList begin===");
        RetInfo retInfo = new RetInfo();
        SysAdvertShowTypeExample example = new SysAdvertShowTypeExample();
        SysAdvertShowTypeExample.Criteria criteria = example.createCriteria();
        criteria.andAdvertDrEqualTo(CommonConstant.STANDARD_ONE);
        List<SysAdvertShowType> sysAdvertShowTypeList = showTypeService.queryShowTypeList(example);
        if (sysAdvertShowTypeList != null && !sysAdvertShowTypeList.isEmpty()){
            List<ShowTypeVO> showTypeVOS = new ArrayList<>(sysAdvertShowTypeList.size());
            sysAdvertShowTypeList.forEach(sysAdvertShowType -> {
                ShowTypeVO showTypeVO = new ShowTypeVO();
                BeanUtils.copyProperties(sysAdvertShowType,showTypeVO);
                showTypeVOS.add(showTypeVO);
            });
            retInfo.setResultCodes(ResultCodes.SUCCESS);
            retInfo.setData(showTypeVOS);
        }else {
            retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
        }
        log.info("===queryEnableShowTypeList end===");
        return retInfo;
    }

    @Override
    public RetInfo saveMediaType(MediaTypeAddParam param) {
        log.info("===saveMediaType begin===" + param);
        ParamCheckUtil.validParamObjectNull(param);
        ParamCheckUtil.validParamStrNotNull(param.getMediaTypeName());
        SysMediaTypeExample example = new SysMediaTypeExample();
        SysMediaTypeExample.Criteria criteria = example.createCriteria();
        criteria.andMediaTypeNameEqualTo(param.getMediaTypeName());
        RetInfo retInfo = new RetInfo();
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            int totalRow = mediaTypeService.countMediaType(example);
            if (totalRow > CommonConstant.STANDARD_ZERO){
                retInfo.setResultCodes(ResultCodes.FAILED);
                retInfo.setMessage("类型名称已存在");
            }else {
                SysMediaType sysMediaType = new SysMediaType();
                sysMediaType.setCreateTime(new Date());
                sysMediaType.setStatus(CommonConstant.STANDARD_ONE);
                sysMediaType.setMediaTypeName(param.getMediaTypeName());
                mediaTypeService.saveSysMediaTypeInfo(sysMediaType);
                retInfo.setResultCodes(ResultCodes.SUCCESS);
            }
        }catch (Exception e){
            e.printStackTrace();
            retInfo.setResultCodes(ResultCodes.FAILED);
        }finally {
            lock.unlock();
        }
        log.info("===saveMediaType end===");
        return retInfo;
    }

    @Override
    public RetInfo queryEnableMediaType() {
        log.info("===queryEnableMediaType begin===");
        RetInfo retInfo = new RetInfo();
        SysMediaTypeExample example = new SysMediaTypeExample();
        SysMediaTypeExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(CommonConstant.STANDARD_ONE);
        List<SysMediaType> sysMediaTypes = mediaTypeService.queryMediaTypeByExample(example);
        if (sysMediaTypes != null && !sysMediaTypes.isEmpty()){
            List<MediaTypeVO> mediaTypeVOS = new ArrayList<>(sysMediaTypes.size());
            sysMediaTypes.forEach(sysMediaType -> {
                MediaTypeVO mediaTypeVO = new MediaTypeVO();
                BeanUtils.copyProperties(sysMediaType,mediaTypeVO);
                mediaTypeVOS.add(mediaTypeVO);
            });
            retInfo.setResultCodes(ResultCodes.SUCCESS);
            retInfo.setData(mediaTypeVOS);
        }else {
            retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
        }
        log.info("===queryEnableMediaType end===");
        return retInfo;
    }

    @Override
    public RetInfo queryEnableBillingList() {
        log.info("===queryEnableBillingList begin===");
        RetInfo retInfo = new RetInfo();
        SysBillingConfigExample example = new SysBillingConfigExample();
        SysBillingConfigExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(CommonConstant.STANDARD_ONE);
        List<SysBillingConfig> billingConfigList = billingConfigService.queryByExample(example);
        if (billingConfigList != null && !billingConfigList.isEmpty()){
            List<BillingConfigVO> billingConfigVOS = new ArrayList<>(billingConfigList.size());
            billingConfigList.forEach(sysBillingConfig -> {
                BillingConfigVO billingConfigVO = new BillingConfigVO();
                BeanUtils.copyProperties(sysBillingConfig,billingConfigVO);
                billingConfigVOS.add(billingConfigVO);
            });
            retInfo.setResultCodes(ResultCodes.SUCCESS);
            retInfo.setData(billingConfigVOS);
        }else {
            retInfo.setResultCodes(ResultCodes.SUCCESS_NO_DATA);
        }
        log.info("===queryEnableBillingList end===");
        return retInfo;
    }
}
