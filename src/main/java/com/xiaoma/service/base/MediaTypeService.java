package com.xiaoma.service.base;

import com.xiaoma.bean.bo.SysMediaTypeExample;
import com.xiaoma.bean.po.SysMediaType;

import java.util.List;

/**
 * 媒体类型领域级业务接口
 * @author mmh
 * @date 2019/3/26
 */
public interface MediaTypeService {

    List<SysMediaType> queryMediaTypeByExample(SysMediaTypeExample example);

    int countMediaType(SysMediaTypeExample example);

    int saveSysMediaTypeInfo(SysMediaType record);

    int updateSysMediaType(SysMediaType record);
}
