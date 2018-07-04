package com.hhs.utils;

import java.io.File;

/**
 * 文件操作工具类
 * 
 * @author Guet
 *
 */
public class IOStreamUtil {

	/**
	 * 递归创建文件夹
	 * 
	 * @param file
	 */
	public static void mkDir(File file) {
		if (file.getParentFile().exists()) {
			file.mkdir();
		} else {
			mkDir(file.getParentFile());
			file.mkdir();
		}
	}
}
