package com.xiaoma.filter;

import com.xiaoma.utils.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Map;
import java.util.Set;

/**
 * 移动端过滤器
 * @author mmh
 * @date 2019/4/11
 */
@Slf4j
public class AndroidIOSFilter implements Filter {

    @Autowired
    private JsonUtil jsonUtil;

    @Override
    public void destroy() {
    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        log.info("===Reader AndroidIOSFilter access do filter begin===");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        RetInfo rew2Result = new RetInfo();
        //判断参数是否合法
        if (!ahCheckInjectPass(request, response)) {
            rew2Result.setCode(202);
            rew2Result.setMessage("输入项中不能包含非法字符");
            errorResponse(response, jsonUtil.toString(rew2Result));
            return;
        }
        String pathInfo = request.getPathInfo() == null ? "" : request.getPathInfo();
        String url = request.getServletPath() + pathInfo;
        log.info("===url------->>>>>>" + url +"===");
        String key = CommonConstant.SIGN_MOVE_KEY;
        String timestamp = request.getHeader("Timestamp");
        String signInfo = request.getHeader("SignInfo");
        String code = timestamp + key;
        //判断时间戳 签名是否合法
        if (!url.contains(".")) {
            log.info("===接口传来的时间戳===" + timestamp + "===系统的时间戳===" + System.currentTimeMillis());
            //判断时间戳和加密信息是否为空
            if (timestamp != null && signInfo != null) {
                long s = (System.currentTimeMillis() - Long.parseLong(timestamp)) / 60000;
                //判断时间戳是否过期  时长5分钟
                if (-30L <= s && s <= 30L) {
                    //判断加密信息是否正确
                    if (!signInfo.equals(MD5Util.code(code))) {
                        rew2Result.setCode(500);
                        rew2Result.setMessage("签名已超时");
                        log.info("=== 签名key与时间加密比对，不正确===");
                        errorResponse(response, jsonUtil.toString(rew2Result));
                        return;
                    }
                } else {
                    log.info("===时间戳校验，上线5分钟区间内===" +s);
                    rew2Result.setCode(501);
                    rew2Result.setMessage("签名无效");
                    errorResponse(response, jsonUtil.toString(rew2Result));
                    return;
                }
            } else {
                rew2Result.setCode(502);
                log.info("===时间戳或签名为null===");
                rew2Result.setMessage("签名参数有误");
                errorResponse(response, jsonUtil.toString(rew2Result));
                return;
            }
        }
        log.info("======Reader AndroidIOSFilter access do filter begin======");
        chain.doFilter(req, res);
    }

    private boolean ahCheckInjectPass(HttpServletRequest req, HttpServletResponse response) throws IOException {
        //1、POST模式非法字符定义
        //双斜杠加上后，会影响被动登录
        String injStr = "(function(,script,iframe,insert,delete,update,declare,expression,XSS,alert,scanner,onerror,prompt,atestu,object,and ,having";

        //2、GET模式非法字符定义
        //双斜杠编码后为 %0a,故需要加上
        //此时为GET提交，否则为POST提交(POST提交，营销业务中存在参数中含HTML标签)
        if (req.getQueryString() != null) {
            injStr = "(function(,script,iframe,insert,delete,update,declare,expression,XSS,alert,scanner,onerror,prompt,atestu,object,and ,having,eval,../,./,<!--,-->";
        }
        String loginFrom = req.getRequestURL().toString();
        //转码
        URLDecoder.decode(loginFrom, "UTF-8");
        //需要对	URL中的参数进行转码
        String urlQuery = req.getQueryString() == null ? "" : URLDecoder.decode(req.getQueryString(), "UTF-8");
        String[] injStras = injStr.split(",");
        for (String anInjStra : injStras) {
            if (urlQuery.toLowerCase().contains(anInjStra)) {
                log.info("校验不通过,原因,包含非法字符:" + anInjStra);
                return false;
            }
        }

        //post 表单 和 ajax提交 参数处理
        Map map = req.getParameterMap();
        Set set = map.keySet();
        for (Object aSet : set) {
            String temp = (String) aSet;
            String value = "";
            if (map.get(temp) != null) {
                String[] values = (String[]) map.get(temp);
                value = values[0];
            }
            for (String injStra : injStras) {
                if (value.toLowerCase().contains(injStra)) {
                    log.info("校验不通过,原因,包含非法字符:" + injStra);
                    return false;
                }
            }
        }
        return true;
    }

    private void errorResponse(HttpServletResponse response, String retStr) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(retStr);
        out.flush();
        out.close();
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }


}