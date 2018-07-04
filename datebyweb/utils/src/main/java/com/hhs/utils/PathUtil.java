package com.hhs.utils;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public class PathUtil {

	public static String getDomain(HttpServletRequest request) {
		return request.getServerName();
	}

	public static String getHttpDomain(HttpServletRequest request) {
		return request.getScheme() + "://" + getDomain(request) + request;
	}

	public static String getHttpUrl(HttpServletRequest request) {
		return request.getRequestURL().toString();
	}

	/**
	 * 
	 * <p>
	 * 描述: 获取项目在tomcat的根路径
	 * </p>
	 * 
	 * @author 灰灰
	 * 
	 * @date 2018年5月3日
	 * 
	 * @version 1.0
	 */
	public static String getRealRootPath(HttpServletRequest request) {
		String path = request.getServletContext().getRealPath(File.separator) + File.separator;
		return path;
	}

}
