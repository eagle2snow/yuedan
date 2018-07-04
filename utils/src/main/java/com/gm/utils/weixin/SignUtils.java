package com.gm.utils.weixin;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import com.hazelcast.util.MD5Util;



/**
 * 签名工具类
 * 
 * @author 小郑
 * @date 2018年02月22日
 * @Notice:wxconfig.apikey。这句代码是获取商务号设置的api秘钥。这里不方便贴出来， 复制签名代码的人，需要把该常量改成自己商务号的key值。原因是Api规定了签名必须加上自己的key值哦
 */
public class SignUtils {

	/**
	 * @param characterEncoding
	 *            编码格式 utf-8
	 */
	public static String creatSign(String characterEncoding, SortedMap<Object, Object> parameters) {
		StringBuffer sb = new StringBuffer();
		Set es = parameters.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			Object v = entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		// wxconfig.apikey。这句代码是获取商务号设置的api秘钥。这里不方便贴出来，
		// 复制签名代码的人，需要把该常量改成自己商务号的key值。原因是Api规定了签名必须加上自己的key值哦
		sb.append("key=" + Const.MCHKEY);
		String sign = MD5Utils.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
		System.out.println(sign);
		return sign;
	}
}
