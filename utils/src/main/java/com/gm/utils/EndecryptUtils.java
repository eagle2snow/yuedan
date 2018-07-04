package com.gm.utils;

import java.security.Key;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/**
 * 加密
 * 
 * @author ying
 *
 */

public final class EndecryptUtils {
	/**
	 * base64进制加密
	 * 
	 * @param password
	 * @return
	 */
	public static String encrytBase64(String password) {
		Preconditions.checkArgument(!Strings.isNullOrEmpty(password), "不能为空");
		byte[] bytes = password.getBytes();
		return Base64.encodeToString(bytes);
	}

	/**
	 * base64进制解密
	 * 
	 * @param cipherText
	 * @return
	 */
	public static String decryptBase64(String cipherText) {
		Preconditions.checkArgument(!Strings.isNullOrEmpty(cipherText), "消息摘要不能为空");
		return Base64.decodeToString(cipherText);
	}

	/**
	 * 16进制加密
	 * 
	 * @param password
	 * @return
	 */
	public static String encrytHex(String password) {
		Preconditions.checkArgument(!Strings.isNullOrEmpty(password), "不能为空");
		byte[] bytes = password.getBytes();
		return Hex.encodeToString(bytes);
	}

	/**
	 * 16进制解密
	 * 
	 * @param cipherText
	 * @return
	 */
	public static String decryptHex(String cipherText) {
		Preconditions.checkArgument(!Strings.isNullOrEmpty(cipherText), "消息摘要不能为空");
		return new String(Hex.decode(cipherText));
	}

	public static String generateKey() {
		AesCipherService aesCipherService = new AesCipherService();
		Key key = aesCipherService.generateNewKey();
		return Base64.encodeToString(key.getEncoded());
	}

}