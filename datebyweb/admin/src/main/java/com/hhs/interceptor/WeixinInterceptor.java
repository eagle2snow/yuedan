package com.hhs.interceptor;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.github.sd4324530.fastweixin.api.enums.OauthScope;
import com.hhs.api.wx.WeiXinApi;
import com.hhs.base.consts.Const;
import com.hhs.base.model.Member;
import com.hhs.utils.StringUtil;

/**
 * 微信拦截器
 *
 */
@Component
public class WeixinInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Member member = (Member) request.getSession().getAttribute(Const.CUR_WX_MEMBER);
		if (null == member) {
			String domain = request.getScheme() + "://" + request.getServerName();
			String qrStr = request.getQueryString();
			String currentUrl = request.getRequestURL().toString();
			if (!StringUtil.strNullOrEmpty(qrStr)) {
				currentUrl += "?" + qrStr;
			}
			currentUrl = URLEncoder.encode(currentUrl, "utf-8");
			String url = WeiXinApi.getOauthAPI().getOauthPageUrl(domain + "/wx/saveMember", OauthScope.SNSAPI_BASE,
					currentUrl);
			response.sendRedirect(url);
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}