package com.yd.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * 加解密工具类
 * @author Rong.zhu
 *
 */
public class EncryptUtils {
	
	/**
	 * MD5加密
	 * @param s
	 * @return
	 */
	public static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * MD5+BASE64加密
	 * @param srcValue
	 * @return
	 */
	public static String MD5_BASE64(String srcValue){
		if(srcValue == null) return null;
		byte [] bytPwd = srcValue.getBytes();
		MessageDigest alg = null;
		String tgtValue = null;
		try {
			alg = MessageDigest.getInstance("MD5");
			alg.update(bytPwd);
		    byte[] digest = alg.digest();
		    BASE64Encoder encoder = new BASE64Encoder();
		    tgtValue =encoder.encode(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return tgtValue;
	}
	
	public static void main(String[] args) {
		String s = "12345";
		System.out.println(EncryptUtils.MD5_BASE64(s));
	}
}
