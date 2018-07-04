package com.gm.admin.controller.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.gm.service.MemberService;
import com.gm.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.gm.api.websocket.WebSokectMsgSender;
import com.gm.base.dto.ChatMember;
import com.gm.base.enums.MsgTypeEnum;
import com.gm.base.model.Member;
import com.gm.base.model.Msg;

import static com.gm.controllerUtil.Admin.getCurUser;

@Controller
@RequestMapping("/admin/chat")
public class AdminChatController {
    @Resource
    private MsgService msgService;
    @Resource
    private MemberService memberService;

    @Autowired
    WebSokectMsgSender sender;

    private final static String path = "/admin/chat/";

    /**
     * 进入聊天
     *
     * @param memberId
     * @return
     */
    @RequestMapping("/to/{memberId}")
    public String contact(@PathVariable Integer memberId, ModelMap map, HttpSession session)
    {
        if (!memberId.equals(0)) {
            Member toMember = memberService.get(memberId);
            map.put("toName", toMember.getName());
            map.put("toAvatar", toMember.getIocUrl());
            List<Msg> msgs = msgService.listOurChatMsgs(getCurUser().getId(), memberId);
            map.put("msgs", JSON.toJSONString(msgs));
            map.put("toId", memberId);
        } else {
            map.put("toId", 0);
            map.put("msgs", "[]");
        }

        // List members =
        // memberService.go().pq("id").pq("nickname").pq("iocUrl").pqList();
        List<Member> members = memberService.list();
        List<Msg> msgs = msgService.getNotReadMemberToKfMsgs();
        Map<Integer, List<Msg>> msgMap = msgs.parallelStream().collect(Collectors.groupingBy(Msg::getFromId));
        List<ChatMember> chatMembers = new ArrayList<>();
        for (Member member : members) {
            List<Msg> msgs2 = msgMap.get(member.getId());
            Integer n = 0;
            if (msgs2 != null) {
                n = msgs2.size();
            }
            ChatMember chatMember = new ChatMember(member, n);
            chatMembers.add(chatMember);
        }

        map.put("memberList", JSON.toJSONString(chatMembers));
        map.put("path", path);
        return path + "chat";
    }

    /**
     * 客服给会员发消息
     *
     * @param memberId
     * @param text
     * @return
     */
    @RequestMapping("/sendToMember")
    @ResponseBody
    public Map<String, Object> sendToMember(Integer memberId, String text)
    {
        return msgService.snedToMember(getCurUser().getId(), memberId, MsgTypeEnum.TEXT, text);
    }

    /**
     * 获取获取记录
     */
    @RequestMapping("/getChatMsgs/{memberId}")
    @ResponseBody
    public Map<String, Object> getChatMsgs(@PathVariable Integer memberId)
    {
        Map<String, Object> map = new HashMap<>();
        List<Msg> msgs = msgService.listOurChatMsgs(getCurUser().getId(), memberId);

        // 把消息设为已读
        List<Integer> ids = msgs.parallelStream().map(Msg::getId).collect(Collectors.toList());
        if (ids.size() > 0) {
            msgService.update("readed", 2, ids);
        }

        map.put("msgs", msgs);
        return map;
    }

}
