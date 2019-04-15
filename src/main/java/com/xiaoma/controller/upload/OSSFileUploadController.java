package com.xiaoma.controller.upload;


import com.xiaoma.utils.CommonConstant;
import com.xiaoma.utils.OssUtil;
import com.xiaoma.utils.ResultCodes;
import com.xiaoma.utils.RetInfo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import com.aliyun.openservices.oss.model.ObjectMetadata;

/**
 * 阿里云文件上传控制器
 * @author mmh
 * @date 2018/6/19
 */
@Slf4j
@RestController
public class OSSFileUploadController {


    @ApiOperation("广告图片上传")
    @RequestMapping(value = "/api/xiaoma/advertImgUploadSave", method = RequestMethod.POST)
    public RetInfo advertImgUploadSave(@RequestParam(value = "file")MultipartFile file){
        RetInfo retInfo = new RetInfo();
        try {
            retInfo = fileCheck(file);
            if (retInfo != null) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmssS", Locale.CHINA);
                ObjectMetadata headMetadata = new ObjectMetadata();
                headMetadata.setContentLength(file.getSize());
                String headFileName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                String headSavePath = "/advert/" + formatter.format(new Date(System.currentTimeMillis())) + headFileName;
                OssUtil.uploadInputStream(file.getInputStream(), headMetadata, headSavePath);
                retInfo.setResultCodes(ResultCodes.SUCCESS);
                retInfo.setData(CommonConstant.FILE_URL + headSavePath);
                log.debug("===上传文件成功===");
            }
        }catch (Exception e){
            log.error("===上传文件异常：" + e.getMessage());
            retInfo.setResultCodes(ResultCodes.FAILED);
            retInfo.setMessage("阿里云上传文件异常");
        }
        return retInfo;
    }

    private RetInfo fileCheck(MultipartFile file){
        RetInfo retInfo = null;
        if (file != null && file.getSize() > 167772160) {
            retInfo = new RetInfo();
            retInfo.setResultCodes(ResultCodes.FAILED);
            retInfo.setMessage("上传文件太大");
            log.debug("===上传文件过大===");
        } else if (file == null || file.getSize() == 0) {
            retInfo = new RetInfo();
            retInfo.setResultCodes(ResultCodes.FAILED);
            retInfo.setMessage("未选中文件");
            log.debug("===没有选中文件===");
        }else {
            retInfo = new RetInfo();
            retInfo.setResultCodes(ResultCodes.SUCCESS);
            log.info("===上传文件校验符合===");
        }
        return retInfo;
    }

}
