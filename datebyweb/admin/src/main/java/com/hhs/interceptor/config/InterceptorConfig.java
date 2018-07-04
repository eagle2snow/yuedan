package com.hhs.interceptor.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hhs.interceptor.AdminInterceptor;
import com.hhs.interceptor.WeixinInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Resource
	private AdminInterceptor adminInterceptor;

	@Resource
	private WeixinInterceptor weixinInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		// 后台
		registry.addInterceptor(adminInterceptor).addPathPatterns("/admin/**").excludePathPatterns("/admin/login")
				.excludePathPatterns("/admin/login.htm").excludePathPatterns("/admin/login.html")
				.excludePathPatterns("/admin/loginAction");

		// 微信
		registry.addInterceptor(weixinInterceptor).addPathPatterns("/wx/**").excludePathPatterns("/wx/saveMember")
				.excludePathPatterns("/wx").excludePathPatterns("/wx/").excludePathPatterns("/wx/pay/paySuccess")
				.excludePathPatterns("/wx/testLogin/**");
	}

}