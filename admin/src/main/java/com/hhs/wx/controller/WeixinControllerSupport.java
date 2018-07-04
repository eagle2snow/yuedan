package com.hhs.wx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.sd4324530.fastweixin.servlet.WeixinSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 微信公众平台交互操作基类，提供几乎所有微信公众平台交互方式 基于springmvc框架，方便使用此框架的项目集成
 *
 * @author ying
 */
@Controller
public abstract class WeixinControllerSupport extends WeixinSupport {

	/**
	 * 绑定微信服务器
	 *
	 * @param request
	 *            请求
	 * @return 响应内容
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	protected final void bind(HttpServletRequest request, HttpServletResponse response) {
		if (isLegal(request)) {
			// 绑定微信服务器成功
			try {
				response.getWriter().write(request.getParameter("echostr"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// 绑定微信服务器失败
			System.out.println("绑定失败");
		}
	}

	/**
	 * 微信消息交互处理
	 *
	 * @param request
	 *            http 请求对象
	 * @param response
	 *            http 响应对象
	 * @throws ServletException
	 *             异常
	 * @throws IOException
	 *             IO异常
	 */
	@RequestMapping(method = RequestMethod.POST)
	protected final void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (isLegal(request)) {
			String result = processRequest(request);
			// 设置正确的 content-type 以防止中文乱码
			response.setContentType("text/xml;charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.write(result);
			writer.close();
		}
	}
}