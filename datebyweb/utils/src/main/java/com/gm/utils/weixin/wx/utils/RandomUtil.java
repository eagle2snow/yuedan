package com.gm.utils.weixin.wx.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

/**
 * 随机工具
 * 
 * @author pqr
 *
 */
public class RandomUtil {

	/**
	 * 随机生成字符串
	 * 
	 * @param length
	 *            生成字符串的长度
	 * @return
	 */
	public static String getRandomString(int length) {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 随机生成数字
	 * 
	 * @param length
	 *            生成字符串的长度
	 * @return
	 */
	public static String getRandomNum(int length) {
		String temp = "";
		try {
			for (int i = 0; i < length; i++) {
				temp = SecureRandom.getInstanceStrong().nextInt(10)+temp;				
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return temp;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			String a = getRandomNum(19);
			System.out.println(a.length());
			System.out.println(a);
			
		}
	}
}
