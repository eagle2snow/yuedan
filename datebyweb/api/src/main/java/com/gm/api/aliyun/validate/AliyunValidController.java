package com.gm.api.aliyun.validate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyuncs.jaq.model.v20161123.AfsCheckRequest;
import com.aliyuncs.jaq.model.v20161123.AfsCheckResponse;

/**
 * 阿里云验证
 * 
 * @author ying
 *
 */

@Controller
@RequestMapping("/aliyunValid")
public class AliyunValidController {

	@RequestMapping("/test")
	public String v() {
		return "/pc/validation";
	}

	/**
	 * 验证
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/vcode.json")
	@ResponseBody
	public AfsCheckResponse vd(AfsCheckRequest request) throws Exception {

		request.setPlatform(3);
		// 必填参数，请求来源： 1：Android端； 2：iOS端； 3：PC端及其他

		AfsCheckResponse response = null;
		try {
			response = Config.getAcsClient().getAcsResponse(request);
			System.out.println(response.getErrorCode());
			System.out.println(response.getErrorMsg());
			System.out.println(response.getData());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}