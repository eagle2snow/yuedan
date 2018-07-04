package com.gm.api.wx;

import com.github.sd4324530.fastweixin.api.JsAPI;
import com.github.sd4324530.fastweixin.api.MaterialAPI;
import com.github.sd4324530.fastweixin.api.MediaAPI;
import com.github.sd4324530.fastweixin.api.OauthAPI;
import com.github.sd4324530.fastweixin.api.QrcodeAPI;
import com.github.sd4324530.fastweixin.api.UserAPI;
import com.github.sd4324530.fastweixin.api.config.ApiConfig;
import com.gm.base.consts.Const;

/**
 * 微信api
 * 
 * @author ying-pc
 *
 */
public class WeiXinApi {

	private static ApiConfig apiConfig;

	private WeiXinApi() {
	}

	/**
	 * 获取ApiConfig
	 * 
	 * @return
	 */
	public static ApiConfig getApiConfig() {
		if (apiConfig == null) {
			synchronized (ApiConfig.class) {
				if (apiConfig == null) {
					apiConfig = new ApiConfig(Const.APPID, Const.SECRET, true);
				}
			}
		}
		return apiConfig;
	}

	public static OauthAPI getOauthAPI() {
		OauthAPI oauthAPI = new OauthAPI(getApiConfig());
		return oauthAPI;
	}

	public static UserAPI getUserAPI() {
		UserAPI userAPI = new UserAPI(getApiConfig());
		return userAPI;
	}

	public static JsAPI getJsAPI() {
		JsAPI jsAPI = new JsAPI(getApiConfig());
		return jsAPI;
	}

	public static MediaAPI getMediaAPI() {
		MediaAPI mediaAPI = new MediaAPI(getApiConfig());
		return mediaAPI;
	}

	public static MaterialAPI getMaterialAPI() {
		MaterialAPI materialAPI = new MaterialAPI(getApiConfig());
		return materialAPI;
	}

	public static QrcodeAPI getQrcodeAPI() {
		QrcodeAPI qrcodeAPI = new QrcodeAPI(getApiConfig());
		return qrcodeAPI;
	}

}
