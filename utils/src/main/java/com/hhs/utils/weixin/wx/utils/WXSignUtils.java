package com.hhs.utils.weixin.wx.utils;


import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import com.hhs.utils.weixin.Const;

public class WXSignUtils {
    /**
     * 微信支付签名算法sign
     * @param characterEncoding
     * @param parameters
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static String createSign(String characterEncoding,SortedMap<Object,Object> parameters){
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();//所有参与传参的参数按照accsii排序（升序）
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            Object v = entry.getValue();
            if(null != v && !"".equals(v)
                    && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + Const.MCHKEY);
        String sign = Md5Util.MD5Encode(sb.toString(), characterEncoding);
        return sign;
    }
}
