package com.gm.wx.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.gm.service.DrawService;
import com.gm.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gm.base.consts.Const;
import com.gm.base.model.Draw;
import com.gm.base.model.Member;

import static com.gm.controllerUtil.WeiXin.getDBMember;
import static com.gm.controllerUtil.WeiXin.getSessionMember;

@Controller
@RequestMapping("/wx/myCenter/draw")
public class WxMyDrawController {

    @Resource
    private DrawService drawService;

    @Resource
    private MemberService memberService;

    private static final String PATH = "/wx/myCenter/draw/";

    /**
     * Description: 去提现
     */
    @RequestMapping("/toDraw")
    public String toDraw(ModelMap map)
    {
        map.put("path", PATH);
        return PATH + "toDraw";
    }

    /**
     * Description: 提现提交
     */
    @ResponseBody
    @RequestMapping("/addDraw")
    public Map<String, Object> addDraw(Draw draw, HttpSession session)
    {
        Map<String, Object> map = new HashMap<>();
        Member member = getDBMember();
        draw.setMember(member);
        draw.setStatus(1);
        if (draw.getAmount().compareTo(member.getBalance()) == 1) {
            map.put("balance", member.getBalance());
            map.put("s", -1);// 余额不足
        } else if (drawService.save(draw)) {
            member.setBalance(member.getBalance().subtract(draw.getAmount()));
            memberService.update(member);
            map.put("s", 1);
        } else {
            map.put("s", 0);
        }
        session.setAttribute(Const.CUR_WX_MEMBER, member);
        return map;
    }

    /**
     * Description: 提现记录
     */
    @RequestMapping("/drawLog")
    public String drawLog(ModelMap map)
    {
        map.put("list", drawService.listEq("member.id", getSessionMember().getId()));
        map.put("path", PATH);
        return PATH + "drawLog";
    }

    /**
     * Description: 取消提现
     */
    @RequestMapping("cancelDraw/{id}")
    @ResponseBody
    public Map<String, Object> cancelDraw(@PathVariable Integer id, HttpSession session)
    {
        Map<String, Object> map = new HashMap<>();
        Draw draw = drawService.get(id);
        if (draw.getStatus() == 1 || draw.getStatus() == 2) {
            draw.setStatus(5);
            drawService.update(draw);
            memberService.updateBalance(draw.getAmount(), getSessionMember().getId());
            Member member = getDBMember();
            member.setBalance(member.getBalance().add(draw.getAmount()));
            session.setAttribute(Const.CUR_WX_MEMBER, member);
            map.put("s", 1);
        } else {
            map.put("s", 2);
        }
        return map;
    }
}
