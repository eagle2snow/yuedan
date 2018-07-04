package com.hhs.api.baidu.ueditor.upload;

import java.util.Map;

import org.apache.commons.codec.binary.Base64;

import com.hhs.api.baidu.ueditor.PathFormat;
import com.hhs.api.baidu.ueditor.define.AppInfo;
import com.hhs.api.baidu.ueditor.define.BaseState;
import com.hhs.api.baidu.ueditor.define.FileType;
import com.hhs.api.baidu.ueditor.define.State;

public final class Base64Uploader {

	public static State save(String content, Map<String, Object> conf) {

		byte[] data = decode(content);

		long maxSize = ((Long) conf.get("maxSize")).longValue();

		if (!validSize(data, maxSize)) {
			return new BaseState(false, AppInfo.MAX_SIZE);
		}

		String suffix = FileType.getSuffix("JPG");

		String savePath = PathFormat.parse((String) conf.get("savePath"), (String) conf.get("filename"));
		String localSavePathPrefix = PathFormat.parse((String) conf.get("localSavePathPrefix"), (String) conf.get("filename"));

		savePath = savePath + suffix;
		localSavePathPrefix = localSavePathPrefix + suffix;
		//String physicalPath = (String) conf.get("rootPath") + savePath;
		String physicalPath = localSavePathPrefix;

		State storageState = StorageManager.saveBinaryFile(data, physicalPath);

		if (storageState.isSuccess()) {
			storageState.putInfo("url", PathFormat.format(localSavePathPrefix));
			storageState.putInfo("type", suffix);
			storageState.putInfo("original", "");
		}

		return storageState;
	}

	private static byte[] decode(String content) {
		return Base64.decodeBase64(content);
	}

	private static boolean validSize(byte[] data, long length) {
		return data.length <= length;
	}

}