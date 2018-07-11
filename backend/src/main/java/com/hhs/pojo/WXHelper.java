package com.hhs.pojo;

import com.hhs.base.model.Client;
import com.hhs.service.ClientService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @Auther: Eagle
 * @Date: 2018/7/11 10:39
 * @Description: 保存微信用户信息
 */
@Component
public class WXHelper {
    @Resource
    private ClientService clientService;

    private static WXHelper self;

    @PostConstruct
    public void init()
    {
        self = this;
    }

    public static Client getClient(Client client)
    {
        String openid = client.getOpenid();
        client = self.clientService.get(client.getId());
        if (client == null)
            client = self.clientService.getOne("openid", openid);
        return client;
    }
}
