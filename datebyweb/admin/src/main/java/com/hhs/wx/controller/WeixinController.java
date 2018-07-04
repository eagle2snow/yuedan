package com.hhs.wx.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hhs.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.sd4324530.fastweixin.api.response.GetUserInfoResponse;
import com.github.sd4324530.fastweixin.api.response.OauthGetTokenResponse;
import com.github.sd4324530.fastweixin.message.BaseMsg;
import com.github.sd4324530.fastweixin.message.TextMsg;
import com.github.sd4324530.fastweixin.message.req.BaseEvent;
import com.github.sd4324530.fastweixin.message.req.QrCodeEvent;
import com.github.sd4324530.fastweixin.message.req.TextReqMsg;
import com.hhs.api.wx.WeiXinApi;
import com.hhs.base.consts.Const;
import com.hhs.base.model.Member;
import com.hhs.utils.StringUtil;

/**
 * 微信认证入口
 */
@RestController
@RequestMapping("/wx")
public class WeixinController extends WeixinControllerSupport {
    private static final Logger log = LoggerFactory.getLogger(WeixinController.class);
    private static final String TOKEN = Const.TOKEN;
    private static final String APPID = Const.APPID;

    @Resource
    private MemberService memberService;

    // 设置TOKEN，用于绑定微信服务器
    @Override
    protected String getToken()
    {
        return TOKEN;
    }

    // 使用安全模式时设置：APPID
    @Override
    protected String getAppId()
    {
        return APPID;
    }

    // 使用安全模式时设置：密钥
    @Override
    protected String getAESKey()
    {
        return null;
    }

    // 重写父类方法，处理对应的微信消息
    @Override
    public BaseMsg handleTextMsg(TextReqMsg msg)
    {
        String content = msg.getContent();
        log.info("收到消息：" + content);
        return new TextMsg("亲爱的会员您好，公众号会话功能未开启，有问题请点击下面链接进入客服系统进行咨询^_^\n" +
                "http://zhuyu.tiexinxi.cn/wx/chat");
    }

    @Override
    public BaseMsg handleSubscribe(BaseEvent event)
    {
        if (event instanceof QrCodeEvent) {// 扫描会员的二维码
            QrCodeEvent qrCodeEvent = (QrCodeEvent) event;
            String openid = qrCodeEvent.getFromUserName();
            Member member = memberService.getOne("openid", openid);
            if (null == member)
                return new TextMsg("感谢您的关注，祝您购物愉快。");// 数据库没有此会员 信息
            else
                return new TextMsg("感谢您再次关注竹语商城，祝您购物愉快。");// 娄据库已有此会员 信息
        } else {// 扫描官方二维码或者通过搜索关注的
            String openid = event.getFromUserName();
            Member member = memberService.getOne("openid", openid);
            if (null == member)
                return new TextMsg("感谢您的关注，祝您购物愉快。");// 数据库没有此会员 信息
            else
                return new TextMsg("感谢您再次关注竹语商城，祝您购物愉快。");// 娄据库已有此会员 信息
        }
    }

    @RequestMapping("/testLogin/{memberId}")
    public String testLogin(@PathVariable Integer memberId, HttpSession session)
    {
        Member member = memberService.get(memberId);
        if (member != null) {
            session.setAttribute(Const.CUR_WX_MEMBER, member);
            return "ok";
        } else {
            return "no member";
        }
    }

    @RequestMapping("/saveMember")
    public void saveMember(String code, String state, HttpServletResponse response, HttpSession session)
    {
        OauthGetTokenResponse re = WeiXinApi.getOauthAPI().getToken(code);
        String openid = re.getOpenid();
        if (!StringUtil.strNullOrEmpty(openid)) {
            Member member = memberService.getOne("openid", openid);
            if (null == member) {
                member = memberService.saveWeixinMember(openid);
            }
            session.setAttribute(Const.CUR_WX_MEMBER, member);
        }
        try {
            response.sendRedirect(state);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/getUserInfo")
    public void getUserInfo(String code, String state, HttpServletResponse response, HttpSession session)
    {
        OauthGetTokenResponse re = WeiXinApi.getOauthAPI().getToken(code);
        String openid = re.getOpenid();
        GetUserInfoResponse response2 = WeiXinApi.getOauthAPI().getUserInfo(re.getAccessToken(), openid);
        Member member = memberService.getOne("openid", openid);
        if (member == null) {
            member = memberService.saveWeixinMember(response2);
        } else {
            member = memberService.updateWeixinMember(member, response2);
        }
        session.setAttribute(Const.CUR_WX_MEMBER, member);
        try {
            response.sendRedirect(state);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}