package com.xiaoma.utils;


import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;


/**
 * md5加密工具类
 * @author Administrator
 */
public class MD5Util {


	private MD5Util() {
	}

	public static String code(String str) {
		try {
			MessageDigest digest = MessageDigest.getInstance("md5");
			byte[] data = digest.digest(str.getBytes("utf-8"));
			StringBuilder sb = new StringBuilder();
            for (byte aData : data) {
                String result = Integer.toHexString(aData & 0xff);
                if (result.length() == 1) {
                    result = "0" + result;
                }
                sb.append(result);
            }
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public  static String md5Encoder(String s) {
		try {
			byte[] btInput = s.getBytes("utf-8");
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			StringBuffer sb = new StringBuffer();
            for (byte aMd : md) {
                int val = ((int) aMd) & 0xff;
                if (val < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(val));
            }
			return sb.toString();
		} catch (Exception e) {
		    e.printStackTrace();
			return null;
		}
	}

	/**
	 * 签名字符串
	 * @param text 需要签名的字符串
	 * @param key 密钥
	 * @param inputCharset 编码格式
	 * @return 签名结果
	 */
	public static String sign(String text, String key, String inputCharset) {
		text = text + key;
		return DigestUtils.md5Hex(getContentBytes(text, inputCharset));
	}

	/**
	 * @param content
	 * @param charset
	 * @return
	 * @throws java.security.SignatureException
	 * @throws UnsupportedEncodingException
	 */
	private static byte[] getContentBytes(String content, String charset) {

		try {
            if (charset == null || "".equals(charset)) {
                return content.getBytes("utf-8");
            }
			return content.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
		}
	}

	/**
	 * 签名字符串
	 * @param text 需要签名的字符串
	 * @param sign 签名结果
	 * @param key 密钥
	 * @param inputCharset 编码格式
	 * @return 签名结果
	 */
	public static boolean verify(String text, String sign, String key, String inputCharset) {
		text = text + key;
		String mySign = DigestUtils.md5Hex(getContentBytes(text, inputCharset));
        return mySign.equals(sign);
    }

//    public static void main(String[] srts){
//		String str = "18839503712";
//		String codeStr = MD5Util.code(str);
//		System.out.println("===" + codeStr+"===");
//	}
}
