package com.gm.wx.controller;

import java.io.File;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.sd4324530.fastweixin.api.enums.OauthScope;
import com.github.sd4324530.fastweixin.api.enums.QrcodeType;
import com.github.sd4324530.fastweixin.api.response.GetSignatureResponse;
import com.github.sd4324530.fastweixin.api.response.QrcodeResponse;
import com.gm.api.sms.BSSendSms;
import com.gm.api.wx.WeiXinApi;
import com.gm.base.consts.Const;
import com.gm.base.model.Member;
import com.gm.service.CommodityAppraiseService;
import com.gm.service.MemberService;
import com.gm.utils.StringUtil;
import com.xiaoleilu.hutool.http.HttpUtil;
import com.xiaoleilu.hutool.util.RandomUtil;

import static com.gm.controllerUtil.Common.getRequest;
import static com.gm.controllerUtil.WeiXin.getDBMember;
import static com.gm.controllerUtil.WeiXin.getDomain;
import static com.gm.controllerUtil.WeiXin.getSessionMember;

/**
 * @Description:个人中心控制器
 */
@Controller
@RequestMapping("/wx/myCenter/")
public class WxMyCenterController {

    private static final Logger logger = LoggerFactory.getLogger(WxMyCenterController.class);
    private static final String PATH = "wx/myCenter/";

    @Resource
    private MemberService memberService;

    @Resource
    private CommodityAppraiseService commodityAppraiseService;

    @Resource
    private BSSendSms semdSms;

    /**
     * Description: 首页
     */
    @RequestMapping("index")
    public String toMyCenterIndex(ModelMap map, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        Member member = getDBMember();
        map.put("member", member);
        if (StringUtil.strNullOrEmpty(member.getNickname())) {
            String domain = request.getScheme() + "://" + request.getServerName();
            String currentUrl = request.getRequestURL().toString();
            currentUrl = URLEncoder.encode(currentUrl, "utf-8");
            String url = WeiXinApi.getOauthAPI().getOauthPageUrl(domain + "/wx/getUserInfo", OauthScope.SNSAPI_USERINFO, currentUrl);
            response.sendRedirect(url);
        }
        map.put("path", PATH);
        return PATH + "personal";
    }

    /**
     * Description: 我的会员
     *
     * @param type 1未购买，2已购买
     */
    @RequestMapping("myMembers/{type}")
    public String myMembers(ModelMap map, @PathVariable Integer type)
    {
        List<Member> list = null;
        String generalizeId = getDBMember().getGeneralizeId();
        if (type == 1) {
            list = memberService.notVip(generalizeId);
            logger.info("未购买会员下属列表 {}.", JSON.toJSON(list.size()));
        } else if (2 == type) {
            list = memberService.vip(generalizeId);
            logger.info("已购买会员下属列表 {}.", JSON.toJSON(list.size()));
        }
        map.put("list", list);
        map.put("path", PATH);
        return PATH + "myMembers";
    }

    /**
     * @Description: 修改个人资料请求vies
     */
    @RequestMapping("editProfileView")
    public String editProfileView(ModelMap map)
    {
        Member model = memberService.get(getSessionMember().getId());
        map.put("path", PATH);
        map.put("model", model);

        return PATH + "editProfile";
    }

    /**
     * @Title: checkPhone @Description: ajax验证手机号是否已经存在 @return @return:
     * Map<String,Object> @throws
     */
    @ResponseBody
    @PostMapping("checkPhone")
    public Map<String, Object> checkPhone(String mobile)
    {
        HashMap<String, Object> map = new HashMap<>();
        logger.info("checkPhone:The paramemter mobile={}", mobile);

        Member member = memberService.getOne("mobile", mobile);

        if (null == member) {
            map.put("msg", "ok");
        } else {
            map.put("msg", "no");
        }

        logger.info("checkPhone:The Map map={}", JSON.toJSON(map));
        return map;

    }

    @ResponseBody
    @GetMapping("getVerificationCode/{mobile}")
    public Map<String, Object> getVerificationCode(@PathVariable String mobile)
    {
        logger.info("getVerificationCode:The paramemter mobile={}", mobile);

        HashMap<String, Object> map = new HashMap<>();

        String param = RandomUtil.randomNumbers(6);
        Map<String, Object> sendSms = semdSms.sendSms(mobile, param);
        Integer status = (Integer) sendSms.get("status");

        if (status == 1) {
            getRequest().getSession().setAttribute(Const.verificationCode2Session, param);
            map.put("status", 1);
            map.put("msg", "验证码发送成功！");
        } else {
            map.put("status", 2);
            map.put("msg", "验证码发送失败！");
        }

        logger.info("getVerificationCode:The Map map={}", JSON.toJSON(map));
        return map;
    }

    /**
     * @return Map<String                                                                                                                                                                                                                                                               ,                                                                                                                                                                                                                                                               Object>
     * @Title: updateAction
     * @Description: 修改个人资料请求Action
     * 会员信息
     */
    @ResponseBody
    @RequestMapping("editProfile/{nickname}/{mobile}/{code}")
    public Map<String, Object> updateAction(@PathVariable String nickname, @PathVariable String mobile,
                                            @PathVariable String code)
    {
        logger.info("WxMyCenterController editProfileAction: the args nickname = {},mobile = {}, code = {}", nickname,
                mobile, code);

        Map<String, Object> map = new HashMap<>();

        Member curMember = getDBMember();
        String code2session = (String) getRequest().getSession().getAttribute(Const.verificationCode2Session);

        if (!StringUtils.isEmpty(code2session)) {
            if (code2session.equals(code)) {
                getRequest().getSession().setAttribute(Const.verificationCode2Session, null);
                curMember.setName(nickname);
                curMember.setMobile(mobile);
                memberService.update(curMember);
                map.put("status", 1);
                map.put("msg", "更改成功！");
            } else {
                map.put("status", 2);
                map.put("msg", "验证码错误，请认真输入！");
            }
        } else {
            map.put("status", 3);
            map.put("msg", "请输入验证码后保存！");
        }

        logger.info("updateAction: the Map to json is {}.", JSON.toJSON(map));

        return map;
    }

    /**
     * Description:我的评论
     */
    @RequestMapping("replyMessage/{type}")
    public String replyMessage(ModelMap map, @PathVariable Integer type)
    {
        Integer memberId = getSessionMember().getId();
        map.put("model", commodityAppraiseService.listEqDc("member.id", memberId, "createTime", "desc"));
        map.put("member", memberId);
        map.put("path", PATH);
        logger.info("会员评论列表 {}.",
                JSON.toJSONString(commodityAppraiseService.listEqDc("member.id", memberId, "createTime", "desc")));
        return PATH + "replyMessage";
    }

    /**
     * Description:删除评论
     */
    @ResponseBody
    @RequestMapping("deleteComment/{id}")
    public Map<String, Object> deleteComment(@PathVariable Integer id)
    {
        HashMap<String, Object> map = new HashMap<>();
        if (commodityAppraiseService.deleteById(id, true)) {
            map.put("status", 1);
            map.put("msg", "删除成功");
        } else {
            map.put("status", 2);
            map.put("msg", "删除失败");
        }

        logger.info("deleteComment:the Map to Json is map = {}", JSON.toJSON(map));
        return map;
    }

    @RequestMapping("genQrcode")
    @ResponseBody
    public String genQrcode(HttpServletRequest request)
    {
        Member member = getDBMember();
        member = memberService.genCodeAndQrCode(member, request);
        memberService.update(member);
        return member.getQrCode();
    }

    private static Map<Integer, Map<String, Object>> status = new HashMap<>();

    static {
        for (int i = 1; i <= 7; ++i) {
            Map<String, Object> m = new HashMap<>();
            m.put("s", String.valueOf(i));
            status.put(i, m);
        }
        //推广码有误，请检查!
        //不存在推荐人，请重新更改!
        //推荐人只能修改一次，请勿重复修改!
        //推荐人不可以是自己!
        //推荐关系是环形！请重新选择！
        //推荐关系是环形　请重新选择！
        //更改完成!
    }

    /**
     * @param referrerGeneralizeId 推荐人推荐ID
     * @return Map<String                                                                                                                                                                                                                                                               ,                                                                                                                                                                                                                                                               Object> 状态信息
     * @Title: editReferrerAction
     * @Description: 修改推荐人
     */
    @ResponseBody
    @RequestMapping("editReferrerAction/{referrerGeneralizeId}")
    public Map<String, Object> editReferrerAction(@PathVariable String referrerGeneralizeId)
    {
        if (StringUtils.isEmpty(referrerGeneralizeId))
            return status.get(1);
        Member other = memberService.getOne("generalizeId", referrerGeneralizeId);
        if (other == null)
            return status.get(2);

        Member myself = getDBMember();
        if (myself.getChangReferrer().equals(1))
            return status.get(3);

        if (myself.getId().equals(other.getId()))
            return status.get(4);

        Member parent = memberService.getParent(other, 1);
        for (Set<Integer> visited = new HashSet<>();
             parent != null;
             parent = memberService.getParent(other, 1)) {
            if (parent.getId().equals(other.getId()))
                return status.get(5);
            if (visited.contains(parent.getId()))
                return status.get(6);
            visited.add(parent.getId());
        }

        myself.setReferrerGeneralizeId(referrerGeneralizeId);
        myself.setReferrerNickname(other.getNickname());
        myself.setChangReferrer(1);
        memberService.update(myself);

        return status.get(7);
    }

    /**
     * Description: 我的二维码
     */
    @RequestMapping("myQrCode")
    public String myQrCode(HttpSession session, HttpServletRequest request, ModelMap map)
    {
        Member member = getDBMember();
        if (member == null)
            return PATH + "myQrCode";

        String generalizeId = member.getGeneralizeId();
        if (!StringUtil.strNullOrEmpty(generalizeId)) {
            GetSignatureResponse resp = WeiXinApi.getJsAPI().getSignature(getDomain() + request.getRequestURI());
            map.put("resp", resp);

            if (!StringUtil.strNullOrEmpty(member.getQrCode())) {
                LocalDateTime lastUpdateQrCode = member.getLastUpdateQrCode();
                if (null == lastUpdateQrCode || lastUpdateQrCode.plusDays(25).isBefore(LocalDateTime.now()))
                    genQrCode(session, request, member, generalizeId);
            } else {
                genQrCode(session, request, member, generalizeId);
            }
        }
        return PATH + "myQrCode";
    }

    /**
     * <p>Description:分享我的二维码页面</p>
     */
    @RequestMapping("myQrCode/{openid}")
    public String myQrCode(ModelMap map, @PathVariable String openid)
    {
        Member one = memberService.getOne("openid", openid);
        map.put("user", one);
        map.put("status", 1);
        return PATH + "myQrCode1";
    }

    // 生成二维码
    private void genQrCode(HttpSession session, HttpServletRequest request, Member member, String generalizeId)
    {
        QrcodeResponse qrCode = WeiXinApi.getQrcodeAPI().createQrcode(QrcodeType.QR_SCENE, generalizeId, 2592000);
        String path = request.getServletContext().getRealPath(File.separator) + File.separator;
        path = path + "static" + File.separator + "member" + File.separator + "qrcode" + File.separator + generalizeId
                + ".png";
        HttpUtil.downloadFile("https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + qrCode.getTicket(), path);
        member.setLastUpdateQrCode(LocalDateTime.now());
        member.setQrCode("/static/member/qrcode/" + generalizeId + ".png");
        memberService.update(member);
        session.setAttribute(Const.CUR_WX_MEMBER, member);
    }
}
