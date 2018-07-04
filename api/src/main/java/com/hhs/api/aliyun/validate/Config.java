package com.hhs.api.aliyun.validate;


import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class Config {

	static IAcsClient client = null;
	static IClientProfile profile = null;
	private static final String regionid = "cn-hangzhou";
	private static final String accessKeyId = "LTAIq9rwEtmwppUA";
	private static final String accessKeySecret = "f4buUVduxy87i6ZRdSZ7fjuISR6Xmd";

	static {
		profile = DefaultProfile.getProfile(regionid, accessKeyId, accessKeySecret);
		try {
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "lexing", "www.lexingditie.com");
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}

	public static IAcsClient getAcsClient() {
		client = new DefaultAcsClient(profile);
		return client;
	}

}
