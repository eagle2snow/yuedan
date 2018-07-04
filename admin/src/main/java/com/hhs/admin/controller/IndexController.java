package com.hhs.admin.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hhs.service.sys.LoginLogService;
import com.hhs.service.sys.ResService;
import com.hhs.service.sys.UserResService;
import com.hhs.service.sys.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhs.base.model.sys.LoginLog;
import com.hhs.base.model.sys.Res;
import com.hhs.base.model.sys.User;
import com.hhs.base.model.sys.UserRes;
import com.hhs.utils.IPUtil;
import com.hhs.utils.StringUtil;

@Controller
@RequestMapping("/admin")
public class IndexController {

    private final static String path = "/admin/";
    @Resource
    private UserService userService;
    @Resource
    private ResService resService;
    @Resource
    private UserResService userResService;
    @Resource
    private LoginLogService loginLogService;

    @GetMapping({"/login", "login.htm", "login.html"})
    public String login()
    {
        return path + "login";
    }

    @PostMapping("/loginAction")
    @ResponseBody
    public Map<String, Object> loginAction(String username, String password, HttpServletRequest request)
    {
        Map<String, Object> map = new ConcurrentHashMap<>();

        User user = userService.login(username, password);
        if (user != null) {
            if (user.getEnable().equals(1)) {
                if ("admin".equals(user.getUsername())) {
                    List<Res> res = resService.list();
                    setRess(request, res);
                } else {
                    List<UserRes> userRes = userResService.listEq("user.id", user.getId());
                    List<Res> res = userRes.stream().map(UserRes::getRes).collect(Collectors.toList());
                    setRess(request, res);
                }
                request.getSession().setAttribute("curUser", user);
                map.put("s", 1);// 成功

                /**
                 * 保存登录日志
                 */
                saveLoginLog(request, user);

            } else {
                map.put("s", 2);// 禁用
            }
        } else {
            map.put("s", 0);// 账号密码不匹配
        }
        return map;
    }

    private void saveLoginLog(HttpServletRequest request, User user)
    {
        String ip = IPUtil.getIpAddr(request);
        LoginLog loginLog = new LoginLog(user, ip);
        loginLogService.save(loginLog);
    }

    private void setRess(HttpServletRequest request, List<Res> res)
    {
        List<Res> first = res.stream().filter(p -> null != p.getParent() && p.getParent().getId().equals(1))
                .collect(Collectors.toList());

        first.stream()
                .forEach(p -> p.setSons(res.stream().filter(
                        q -> q.getType().equals(1) && null != q.getParent() && q.getParent().getId().equals(p.getId()))
                        .collect(Collectors.toList())));
        request.getSession().setAttribute("menu", first);

        List<String> ress = res.stream().filter(p -> !StringUtil.strNullOrEmpty(p.getCode())).map(p -> p.getCode())
                .collect(Collectors.toList());
        request.getSession().setAttribute("ress", ress);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/admin/login";
    }
}
