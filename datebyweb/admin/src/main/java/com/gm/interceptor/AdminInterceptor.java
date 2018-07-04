package com.gm.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gm.service.sys.OptLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gm.base.model.sys.OptLog;
import com.gm.base.model.sys.User;
import com.gm.utils.IPUtil;
import com.gm.utils.StringUtil;
import com.xiaoleilu.hutool.util.ArrayUtil;

/**
 * 后台拦截器
 */
@Component
public class AdminInterceptor implements HandlerInterceptor {

    @Resource
    private OptLogService optLogService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception
    {
        User user = (User) request.getSession().getAttribute("curUser");
        if (user != null) {
            if (handler instanceof HandlerMethod) {
                HandlerMethod method = (HandlerMethod) handler;
                RequiresPermissions permision = method.getMethodAnnotation(RequiresPermissions.class);
                if (permision == null) {
                    return true;
                } else {
                    String[] codes = permision.value();
                    List<String> ress = (List<String>) request.getSession().getAttribute("ress");
                    if (ress == null) {
                        return false;
                    } else {
                        boolean b = ress.stream().anyMatch(p -> ArrayUtil.contains(codes, p));
                        if (b) {
                            saveOptLog(request, user, 1);
                        } else {
                            response.sendRedirect("/error/403");
                        }
                        return b;
                    }
                }
            }
            return true;
        } else {
            response.sendRedirect("/admin/login.htm");
            return false;
        }
    }

    private void saveOptLog(HttpServletRequest request, User user, Integer enable)
    {
        String ip = IPUtil.getIpAddr(request);
        String uri = request.getRequestURI();
        String queryStr = request.getQueryString();
        if (!StringUtil.strNullOrEmpty(queryStr)) {
            uri = uri + queryStr;
        }
        OptLog optLog = new OptLog(user, ip, uri);
        optLogService.save(optLog);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception
    {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception
    {
    }

}