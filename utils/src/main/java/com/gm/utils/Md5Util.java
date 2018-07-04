package com.gm.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.RandomStringUtils;

public class Md5Util {

	public static String MD5(String sourceStr) {
		String result = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(sourceStr.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			result = buf.toString();
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e);
		}
		return result;
	}

	/**
	 * MD5加密
	 * 
	 * @param message
	 *            要进行MD5加密的字符串
	 * @return 加密结果为32位字符串
	 */
	public static String getMD5(String message) {
		MessageDigest messageDigest = null;
		StringBuffer md5StrBuff = new StringBuffer();
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(message.getBytes("UTF-8"));

			byte[] byteArray = messageDigest.digest();
			for (int i = 0; i < byteArray.length; i++) {
				if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
					md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
				else
					md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return md5StrBuff.toString();// 字母大写
	}

	public static String getSalt() {
		return new RandomStringUtils().randomAlphanumeric(6);
	}

	public static String getPass(String pass, String salt) {

		return MD5(pass + salt);
	}

	public static void main(String[] args) {
		////// System.out.println(getPass("guet1234", "K7t9Cz"));String md5pass
		////// = getMD5("hlzxhygl");
		// System.out.println(getPass(md5pass, "P6t7CN"));
		// 778de27d7841760991ff19b9ea2f9594

		String md5pass = getMD5("aa123456");
		System.out.println(getPass(md5pass, "P6t7CN")); // b12e6b5d836f3573401df7dabbe1a218

	}

}
