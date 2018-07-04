package com.gm.base.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * 异常统一处理，捕获异常，跳转到对应视图
 *
 */
@Component
public class SysException extends SimpleMappingExceptionResolver {

	private static final Logger logger = LoggerFactory.getLogger(SysException.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		if (ex instanceof UnauthenticatedException) {
			logger.info("未认证");
			return new ModelAndView("redirect:/admin/login");
		} else if (ex instanceof UnauthorizedException) {
			logger.info("未授权");
			return new ModelAndView("redirect:/error/403");
		} 
		else {
			logger.info("系统出错");
			ex.printStackTrace();
			//return new ModelAndView("redirect:/error/500");
			return null;
		}
	}
}