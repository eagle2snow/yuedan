package com.gm.utils.weixin.wx;






import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.alibaba.fastjson.JSON;
import com.gm.utils.weixin.Const;
import com.gm.utils.weixin.wx.utils.RandomUtil;
import com.gm.utils.weixin.wx.utils.WXPayUtil;
import com.gm.utils.weixin.wx.utils.WXSignUtils;

/**
 * 企业付款到用户的测试类
 *
 * @author bobo
 */
public class EnterpriceToCustomer {

    public static Boolean enterPrice()
    {

        return null;
    }

    public static void main(String[] args)
    {
        // 1.0 拼凑企业支付需要的参数
        String appid = Const.APPID; // 微信公众号的appid
        String mch_id = Const.MCHID; // 商户号
        String nonce_str = RandomUtil.getRandomNum(32); // 生成随机数
        String partner_trade_no = RandomUtil.getRandomString(32); // 生成商户订单号
        String openid = "orSud0ZLL4Y101ZMlTYCeS7QBpYQ"; // 支付给用户openid : Eagle
        String check_name = "NO_CHECK"; // 是否验证真实姓名呢
        String re_user_name = "小鱼"; // 收款用户姓名
        String amount = "1"; // 企业付款金额，单位为分
        String desc = "测试开发"; // 企业付款操作说明信息。必填。
        String spbill_create_ip = "192.168.3.56"; //

        // 2.0 生成map集合
        SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
        packageParams.put("mch_appid", appid); // 微信公众号的appid
        packageParams.put("mchid", mch_id); // 商户号
        packageParams.put("nonce_str", nonce_str); // 随机生成后数字，保证安全性
        packageParams.put("partner_trade_no", partner_trade_no); // 生成商户订单号
        packageParams.put("openid", openid); // 支付给用户openid
        packageParams.put("check_name", check_name); // 是否验证真实姓名呢
        packageParams.put("re_user_name", re_user_name);// 收款用户姓名
        packageParams.put("amount", amount); // 企业付款金额，单位为分
        packageParams.put("desc", desc); // 企业付款操作说明信息。必填。
        packageParams.put("spbill_create_ip", spbill_create_ip); // 调用接口的机器Ip地址

        // 3.0 生成自己的签名
        String sign = WXSignUtils.createSign("utf-8", packageParams); // key?

        // 4.0 封装退款对象
        packageParams.put("sign", sign);

        // 5.0将当前的map结合转化成xml格式
        String requestXml = WXPayUtil.getRequestXml(packageParams);
        System.out.println("①:" + requestXml);

        // 6.0获取需要发送的url地址
        String wxUrl = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers"; // 获取退款的api接口

        try {
            String weixinPost = ClientCustomSSL.doRefund(wxUrl, requestXml).toString();
            // 7.0 解析返回的xml数据
            Map<String, String> refundResult = WXPayUtil.xmlToMap(weixinPost);
            System.out.println("②:" + JSON.toJSON(refundResult));

            if (weixinPost.contains("<![CDATA[SUCCESS]]>")) {
                // 8表示退款成功
                // TODO 执行成功付款后的业务逻辑
                // return
                // successPayMoneyByBankCard(submitMoney,cmms_amt,enterpriceToCustomerByCard,applyId,companyId);
                System.out.println("③:付款成功");
            } else {
                // 9 表示退款失败
                // TODO 调用service的方法 ，存储失败提现的记录咯
                // failToPayMoneyByBankCard(enterpriceToCustomerByCard,applyId);
                System.out.println("④:付款失败");

            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
