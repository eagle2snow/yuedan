package com.gm.wx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.gm.service.AutoMsgService;
import com.gm.service.AutoMsgTypeService;
import com.gm.service.MsgService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.gm.api.websocket.WebSokectMsgSender;
import com.gm.base.enums.MsgCatEnum;
import com.gm.base.enums.MsgTypeEnum;
import com.gm.base.model.AutoMsg;
import com.gm.base.model.AutoMsgType;
import com.gm.base.model.Msg;

import static com.gm.controllerUtil.WeiXin.getSessionMember;

/**
 * Description: 微信聊天
 */
@Controller
@RequestMapping("/wx")
public class WxChatController {

    @Resource
    private WebSokectMsgSender sender;

    @Resource
    private MsgService msgService;

    @Resource
    private AutoMsgService autoMsgtService;

    @Resource
    private AutoMsgTypeService autoMsgTypeService;

    @RequestMapping("/chat")
    public String chat(ModelMap map)
    {
        Integer mid = getSessionMember().getId();
        List<Msg> msgs = msgService.listMsgByMember(mid);

        // 会员加入聊天
        Msg msg = new Msg();
        msg.setFromId(mid);
        msg.setToId(1);
        msg.setCat(MsgCatEnum.MEMBER_IN_CHAT);
        msg.setType(MsgTypeEnum.TEXT);
        // msgService.save(msg);
        sender.send(msg);

        if (msgs.size() == 0) {
            List<AutoMsgType> types = autoMsgTypeService.list();

            StringBuilder sb = new StringBuilder(
                    "<div class=\"chat_faqbox\"><div class=\"chat_faq_dt\">常见问题</div><ul class=\"chat_faqlist\">");

            for (AutoMsgType autoMsgType : types) {
                String msgHtm = "<li><a href='javascript:void(0);' onClick='getAutoMsgByType(" + autoMsgType.getId()
                        + ",\" " + autoMsgType.getName() + " \")'><p>" + autoMsgType.getName() + "</p></a></li>";
                sb.append(msgHtm);
            }
            sb.append("</ul></div>");

            Msg msg2 = new Msg();
            msg2.setFromId(1);
            msg2.setToId(mid);
            msg2.setCat(MsgCatEnum.KF_TO_MEMBER);
            msg2.setType(MsgTypeEnum.TEXT);
            msg2.setContent(sb.toString());
            Integer id = msgService.saveReturnId(msg2);
            msg2.setId(id);
            msgs.add(msg2);
        }
        map.put("mid", mid);
        map.put("toId", 1);
        map.put("msgs", JSON.toJSONString(msgs));
        return "/wx/chat";
    }

    @RequestMapping("/getAutoMsgByType/{typeId}")
    @ResponseBody
    public Map<String, Object> getAutoMsgByType(@PathVariable Integer typeId)
    {
        Map<String, Object> map = new HashMap<>();
        List<AutoMsg> autoMsgs = autoMsgtService.listEq("type.id", typeId);
        map.put("autoMsgs", autoMsgs);
        return map;
    }

    @RequestMapping("/send")
    @ResponseBody
    public Map<String, Object> send(Msg msg)
    {
        Map<String, Object> map = new HashMap<>();
        msgService.save(msg);
        sender.send(msg);
        map.put("s", "ok");
        return map;
    }

    /**
     * 发送输入框文本消息
     *
     * @param msg
     * @return
     */
    @RequestMapping("/sendTextMsg")
    @ResponseBody
    public Map<String, Object> sendTextMsg(Msg msg)
    {
        Map<String, Object> map = new HashMap<>();
        msgService.sendInputTextMsgToKf(msg);
        map.put("s", "111");
        return map;
    }

    @RequestMapping("/sendToUrl")
    @ResponseBody
    public Map<String, Object> sendToUrl(Msg msg, String url)
    {
        Map<String, Object> map = new HashMap<>();
        msgService.save(msg);
        sender.sendToUrl(msg, url);
        map.put("s", "ok");
        return map;
    }

}
