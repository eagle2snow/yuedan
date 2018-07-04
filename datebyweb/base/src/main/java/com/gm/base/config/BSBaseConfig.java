package com.gm.base.config;

import com.gm.base.consts.Const;

/**
 * @author:     Ealge 
 * @date:       2018年5月8日 下午2:31:05 
 * @ClassName:  BSBaseConfig 
 * @Description:用于存储基础数据信息类   
 *     
 * @Copyright: 2018 www.gxhhskj.com Inc. All rights reserved. 
 * 注意：本内容仅限于广西恒河沙科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class BSBaseConfig {

	// 基本信息
	public static String userid = "";
	public static String username = "";
	public static String password = "";

	// 短信接口URL
	public static String sMSApiUrl = "";

	static {
		
		userid = Const.userId;
		username = Const.userName;
		password = Const.password;

		sMSApiUrl = Const.sMSApiUrl;

	}

	public static String getUserid() {
		return userid;
	}

	public static void setUserid(String userid) {
		BSBaseConfig.userid = userid;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		BSBaseConfig.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		BSBaseConfig.password = password;
	}

	public static String getsMSApiUrl() {
		return sMSApiUrl;
	}

	public static void setsMSApiUrl(String sMSApiUrl) {
		BSBaseConfig.sMSApiUrl = sMSApiUrl;
	}
	
	
	
	

}
