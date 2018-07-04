package com.hhs.base;

import com.hhs.base.model.sys.LoginLog;
import com.hhs.gencode.Build;

public class CreateCode {

	public static void main(String[] args) {

		/** ====================================================== **/
		/*
		 * 生成选项 dao,s,c,add,update,list ，null则全部生成
		 * ======================================================
		 **/

		// Build.buildCode(Notice.class, "dao,s,c,add,update,list");
		// Build.buildCode(AutoMsgType.class, null);
		// Build.buildCode(TestTime.class, "update");
		try {
			Build.buildCode(LoginLog.class, "c");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}