package com.gm.wx.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.gm.service.CommodityService;
import com.gm.service.MemberService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gm.base.consts.Const;
import com.gm.base.model.Commodity;
import com.gm.base.model.Member;
import com.gm.base.query.Page;
import com.gm.utils.AESCoder;
import com.gm.utils.StringUtil;

import static com.gm.controllerUtil.WeiXin.getDBMember;

@Controller
@RequestMapping("/wx")
public class WxIndexController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private CommodityService commodityService;

    @Resource
    private MemberService memberService;

    private static final String PATH = "wx/";

    /**
     * 描述:首页入口
     */
    @RequestMapping("/index/{id}")
    public String index(ModelMap map, String generalizeId, HttpSession session, @PathVariable Integer id)
    {
        if (!StringUtil.strNullOrEmpty(generalizeId)) {
            Member member = getDBMember();
            if (StringUtil.strNullOrEmpty(member.getReferrerGeneralizeId())) {
                member.setReferrerGeneralizeId(AESCoder.decryptResultStr(generalizeId, Const.PASSWORD_SECRET));
                member.setReferrerNickname(member.getNickname());
                memberService.update(member);
                session.setAttribute(Const.CUR_WX_MEMBER, member);
            }
        }
        session.setAttribute("iid", id);
        map.put("page", getCommodityData(id));
        map.put("path", PATH);

        return PATH + "/index";
    }

    /**
     * 描述:首页入口
     */
    @RequestMapping("/index")
    public String index(ModelMap map, String generalizeId, HttpSession session)
    {
        if (!StringUtil.strNullOrEmpty(generalizeId)) {
            Member member = getDBMember();
            Member one = memberService.getOne("generalizeId", generalizeId);
            if (StringUtil.strNullOrEmpty(member.getReferrerGeneralizeId())) {
                member.setReferrerGeneralizeId(AESCoder.decryptResultStr(generalizeId, Const.PASSWORD_SECRET));
                member.setReferrerNickname(one.getNickname());
                memberService.update(member);
                session.setAttribute(Const.CUR_WX_MEMBER, member);
            }
        }
        int id = 1;
        if (!(session.getAttribute("iid") == null)) {
            id = (int) session.getAttribute("iid");
        }
        map.put("page", getCommodityData(id));
        map.put("path", PATH);
        return PATH + "/index";
    }

    /**
     * 分页获取商品数据
     */
    @RequestMapping("/getCommodityData/{id}")
    @ResponseBody
    public Page<Commodity> getCommodityData(@PathVariable Integer id)
    {
        DetachedCriteria dc = DetachedCriteria.forClass(Commodity.class);
        dc.addOrder(Order.desc("sort"));
        if (id == 1) {
            dc.add(Restrictions.like("code", "1", MatchMode.ANYWHERE));
        } else {
            dc.add(Restrictions.like("code", "2", MatchMode.ANYWHERE));
        }

        return commodityService.list(dc, 1, 10);
    }

    /**
     * @Description: 去公司简介页面
     */
    @RequestMapping("profile")
    public String setProfileView(ModelMap model)
    {
        model.put("member", getDBMember());
        model.put("path", PATH);
        return PATH + "profile";
    }

    /**
     * @Description: 去购买套餐页面
     */
    @RequestMapping("/setMeal")
    public String setMealView(ModelMap model)
    {
        model.put("member", getDBMember());
        model.put("path", PATH);
        return PATH + "setMeal";
    }

    /**
     * @Title: payMemberSuccess @Description: 购买会员套餐成功 @param model @return @return:
     * String @throws
     */
    @RequestMapping("/payMemberSuccess")
    public String payMemberSuccess(ModelMap model)
    {
        model.put("path", PATH);
        model.put("member", getDBMember());
        logger.info("payMemberSuccess:购买套餐成功");
        return PATH + "payMemberSuccess";
    }

    /**
     * @Title: payMemberFail @Description: 购买会员套餐失败 @param model @return @return:
     * String @throws
     */
    @RequestMapping("/payMemberFail")
    public String payMemberFail(ModelMap model)
    {
        model.put("member", getDBMember());
        model.put("path", PATH);
        return PATH + "payMemberFail";
    }

}
