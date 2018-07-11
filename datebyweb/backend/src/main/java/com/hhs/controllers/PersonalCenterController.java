package com.hhs.controllers;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import com.hhs.api.sms.BSSendSms;
import com.hhs.base.consts.Constant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Eagle
 * @Date: 2018/7/11 11:41
 * @Description: 个人中心处理器
 */
@Slf4j
@Controller
@RequestMapping("/pc")
public class PersonalCenterController extends WeixinBaseController{

    @Resource
    private BSSendSms semdSms;

    @ResponseBody
    @GetMapping("getVerificationCode/{mobile}")
    public Map<String, Object> getVerificationCode(@PathVariable String mobile) {
        log.info("getVerificationCode:The parameter mobile={}", mobile);

        HashMap<String, Object> map = this.getMap();

        String param = RandomUtil.randomNumbers(6);
        Map<String, Object> sendSms = semdSms.sendSms(mobile, param);
        Integer status = (Integer) sendSms.get("status");

        if (status == 1) {

            this.getRequest().getSession().setAttribute(Constant.verificationCode2Session, param);

            map.put("status", 1);
            map.put("msg", "验证码发送成功！");
        } else {
            map.put("status", 2);
            map.put("msg", "验证码发送失败！");

        }

        log.info("getVerificationCode:The Map map={}", JSON.toJSON(map));
        return map;

    }
}
