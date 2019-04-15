package com.xiaoma.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * ip地址获取工具类
 * @author mmh
 */
public class IpUtil {
	/**
	 * @Purpose  ip获取
	 * @version  1.0
	 * @author   lizhun
	 * @param    request
	 * @return   String
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if(ip.indexOf(",") > 0){
			ip = ip.split(",")[0];
		}
		return ip;
	}
}
