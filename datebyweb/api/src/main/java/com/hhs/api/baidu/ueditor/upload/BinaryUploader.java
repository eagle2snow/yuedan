package com.hhs.api.baidu.ueditor.upload;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.hhs.api.baidu.ueditor.PathFormat;
import com.hhs.api.baidu.ueditor.define.AppInfo;
import com.hhs.api.baidu.ueditor.define.BaseState;
import com.hhs.api.baidu.ueditor.define.FileType;
import com.hhs.api.baidu.ueditor.define.State;

public class BinaryUploader {

	public static final State save(HttpServletRequest request, Map<String, Object> conf) {
		FileItemStream fileStream = null;
		boolean isAjaxUpload = request.getHeader("X_Requested_With") != null;

		if (!ServletFileUpload.isMultipartContent(request)) {
			return new BaseState(false, AppInfo.NOT_MULTIPART_CONTENT);
		}

		ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());

		if (isAjaxUpload) {
			upload.setHeaderEncoding("UTF-8");
		}

		try {
			FileItemIterator iterator = upload.getItemIterator(request);

			while (iterator.hasNext()) {
				fileStream = iterator.next();

				if (!fileStream.isFormField())
					break;
				fileStream = null;
			}

			if (fileStream == null) {
				return new BaseState(false, AppInfo.NOTFOUND_UPLOAD_DATA);
			}
			
			//String savePath = (String) conf.get("savePath");
			String localSavePathPrefix = (String) conf.get("localSavePathPrefix");
			String originFileName = fileStream.getName();
			String suffix = FileType.getSuffixByFilename(originFileName);

			originFileName = originFileName.substring(0, originFileName.length() - suffix.length());
			//savePath = savePath + suffix;
			localSavePathPrefix = localSavePathPrefix + suffix;

			long maxSize = ((Long) conf.get("maxSize")).longValue();

			if (!validType(suffix, (String[]) conf.get("allowFiles"))) {
				return new BaseState(false, AppInfo.NOT_ALLOW_FILE_TYPE);
			}

			//savePath = PathFormat.parse(savePath, originFileName);
			localSavePathPrefix = PathFormat.parse(localSavePathPrefix, originFileName);

			//String physicalPath = (String) conf.get("rootPath") + savePath;
			String physicalPath = localSavePathPrefix;

			InputStream is = fileStream.openStream();
			State storageState = StorageManager.saveFileByInputStream(is, physicalPath, maxSize);
			is.close();

			if (storageState.isSuccess()) {
				//storageState.putInfo("url", PathFormat.format(savePath));
				storageState.putInfo("url", PathFormat.format(localSavePathPrefix));
				storageState.putInfo("type", suffix);
				storageState.putInfo("original", originFileName + suffix);
			}

			return storageState;
		} catch (FileUploadException e) {
			return new BaseState(false, AppInfo.PARSE_REQUEST_ERROR);
		} catch (IOException e) {
		}
		return new BaseState(false, AppInfo.IO_ERROR);
	}

	private static boolean validType(String type, String[] allowTypes) {
		List<String> list = Arrays.asList(allowTypes);

		return list.contains(type);
	}
}
