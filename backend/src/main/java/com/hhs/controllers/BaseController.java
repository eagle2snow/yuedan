package com.hhs.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @Auther: Eagle
 * @Date: 2018/7/11 10:07
 * @Description: 基础控制器
 */
@Slf4j//通过log直接可以写出日志
public class BaseController {

    public ModelAndView getModelAndView() {
        return new ModelAndView();
    }

    public HashMap<String, Object> getMap() {
        return new HashMap<>();
    }

    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        return request;
    }

    public HttpServletResponse getResponse() {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getResponse();
        return response;
    }

}
