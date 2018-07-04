package com.gm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;

/**
 * base64工具
 * 
 * @author pqr
 *
 */
public class Base64Util {
	public static void main(String[] args) {
		// String strImg = GetImageStr();
		// System.out.println(strImg);
		String a = GetImageStr("d://test.jpg");
		GenerateImage(a, "d://2/test3.jpg");
		File file = new File("d://2/test3.jpg");
		System.out.println(file.exists());
	}
	
	/**
	 * base64图片写入硬盘
	 * @param request
	 * @param pics
	 * @return
	 */
	public static String base64UploadToFile(HttpServletRequest request, String pics) {
		if (pics == null || "".equals(pics)) {
			return "";
		}
		String images = "";
		String imagesUrl = "";
		try {
			images = new StringBuilder().append(URLDecoder.decode(pics, "UTF-8")).toString();
			String webUrl = "/static/upload/image/" + LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE) + "/";
			String url = request.getServletContext().getRealPath(File.separator);
			url = url + File.separator + "static" + File.separator + "upload" + File.separator + "image"
					+ File.separator + LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE) + File.separator;
			String[] picArr = images.split(",");
			for (String pic : picArr) {
				String fileName = Instant.now().toEpochMilli() + RandomUtil.getRandomNum(6) + ".jpg";
				String fileUrl = url + fileName;
				if (!"data:image/png;base64".equals(pic)) {
					Base64Util.GenerateImage(pic.replace(" ", ""), fileUrl);
					imagesUrl = webUrl + fileName + "|" + imagesUrl;
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return imagesUrl;

	}

	/**
	 * 图片转化成base64字符串
	 * 
	 * @param imgFile图片路径
	 * @return
	 */
	public static String GetImageStr(String imgFile) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return Base64.getEncoder().encodeToString(data);// 返回Base64编码过的字节数组字符串
	}

	/**
	 * base64字符串转化成图片
	 * 
	 * @param imgBase64
	 *            base64图片
	 * @param imgFileOut
	 *            图输出路径
	 * @return
	 */
	public static String GenerateImage(String imgBase64, String imgFileOut) { // 对字节数组字符串进行Base64解码并生成图片
		if (imgBase64 == null) // 图像数据为空
			return "error";
		imgBase64 = imgBase64.replace("data:image/jpeg;base64,", "");
		if (!"".equals(imgFileOut)) {
			File imgFile = new File(imgFileOut);
			if (!imgFile.getParentFile().exists()) {// 判断目标文件所在的目录是否存在
				// 如果目标文件所在的文件夹不存在，则创建父文件夹
				// System.out.println("目标文件所在目录不存在，准备创建它！");
				if (!imgFile.getParentFile().mkdirs()) {// 判断创建目录是否成功
					// System.out.println("创建目标文件所在的目录失败！");
				}
			}
		}

		try {
			// Base64解码
			byte[] b = Base64.getDecoder().decode(imgBase64);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpeg图片
			OutputStream out = new FileOutputStream(imgFileOut);
			out.write(b);
			out.flush();
			out.close();
			//System.out.println("图片输出路径为:"+imgFileOut);
			File file = new File(imgFileOut);
			if (!file.exists()) {
				System.err.println("生成文件失败");
				imgFileOut = "";
			}
			return imgFileOut;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		} finally {

		}
	}
}
