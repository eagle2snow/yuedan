package com.gm.utils;

import java.util.ArrayList;
import java.util.List;

 

/**
 * 给html标签内容加上http
 * @author Administrator
 *
 */
public class AddImgByContentUtils {
	
	public static String getImgContent(String httpString,String content){
		if (!StringUtil.strNullOrEmpty(content)) {
			List<String> list = StringUtil.getImgSrc(content);//获取所有src 标签
			List<String> listOld = new ArrayList<>();
			List<String> listNew = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).indexOf("http") == -1) {
					String ss = httpString + list.get(i).trim();
					listOld.add(list.get(i));
					listNew.add(ss);
				}
			}
			for (int i = 0; i < listOld.size(); i++) {
				content = content.replaceAll(list.get(i),listNew.get(i));
			}
		}
		return content;
	}
}
