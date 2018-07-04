package com.hhs.controllerUtil;

import com.hhs.base.consts.Const;
import com.hhs.base.model.Member;
import com.hhs.service.MemberService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import static com.hhs.controllerUtil.Common.getRequest;

@Component
public class WeiXin {

    @Resource
    private MemberService memberService;

    private static WeiXin self;

    @PostConstruct
    public void init()
    {
        self = this;
    }


    public static Member getSessionMember()
    {
        return (Member) getRequest().getSession().getAttribute(Const.CUR_WX_MEMBER);
    }

    public static Member getDBMember()
    {
        Member member = getSessionMember();
        String openid = member.getOpenid();
        member = self.memberService.get(member.getId());
        if (member == null)
            member = self.memberService.getOne("openid", openid);
        return member;
    }

    public static String getDomain()
    {
        return getRequest().getScheme() + "://" + getRequest().getServerName();
    }
}
