package com.hhs.controllers;

import com.hhs.base.consts.Constant;
import com.hhs.base.model.Client;
import com.hhs.service.ClientService;

import javax.annotation.Resource;

/**
 * @Auther: Eagle
 * @Date: 2018/7/11 10:10
 * @Description: 微信基础控制器
 */
public class WeixinBaseController extends BaseController {

    @Resource
    private ClientService clientService;

    public Client getCurrentClient() {
        return (Client) getRequest().getSession().getAttribute(Constant.current_client);
    }

    public String getDomain() {
        String domain = getRequest().getScheme() + "://" + getRequest().getServerName();
        return domain;
    }
}
