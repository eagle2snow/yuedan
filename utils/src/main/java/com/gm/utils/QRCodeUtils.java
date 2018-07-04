package com.gm.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;
import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;
import jp.sourceforge.qrcode.exception.DecodingFailedException;

/**
 * 生成qr码
 * 
 * @author pqr
 *
 */
public class QRCodeUtils {
	/**
	 * 编码字符串内容到目标File对象中
	 * 
	 * @param encodeddata
	 *            编码的内容
	 * @param destFile
	 *            生成file文件
	 * @throws IOException
	 */
	private static String qrCodeEncode(String encodeddata, String destFile) throws IOException {
		Qrcode qrcode = new Qrcode();
		qrcode.setQrcodeErrorCorrect('M'); // 纠错级别（L 7%、M 15%、Q 25%、H 30%）和版本有关
		qrcode.setQrcodeEncodeMode('B');
		qrcode.setQrcodeVersion(7); // 设置Qrcode包的版本
		byte[] d = encodeddata.getBytes("UTF-8"); // 字符集
		BufferedImage bi = new BufferedImage(139, 139, BufferedImage.TYPE_INT_RGB);
		// createGraphics // 创建图层
		Graphics2D g = bi.createGraphics();

		g.setBackground(Color.WHITE); // 设置背景颜色（白色）
		g.clearRect(0, 0, 139, 139); // 矩形 X、Y、width、height
		g.setColor(Color.BLACK); // 设置图像颜色（黑色）

		if (d.length > 0 && d.length < 123) {
			boolean[][] b = qrcode.calQrcode(d);
			for (int i = 0; i < b.length; i++) {
				for (int j = 0; j < b.length; j++) {
					if (b[j][i]) {
						g.fillRect(j * 3 + 2, i * 3 + 2, 3, 3);
					}
				}
			}
		}
		// Image img = ImageIO.read(new File("D:/tt.png")); logo
		// g.drawImage(img, 25, 55,60,50, null);

		g.dispose(); // 释放此图形的上下文以及它使用的所有系统资源。调用 dispose 之后，就不能再使用 Graphics 对象
		bi.flush(); // 刷新此 Image 对象正在使用的所有可重构的资源
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		if (!"".equals(destFile)) {
			File qrFile = new File(destFile);
			if (!qrFile.getParentFile().exists()) {// 判断目标文件所在的目录是否存在
				// 如果目标文件所在的文件夹不存在，则创建父文件夹
				if (!qrFile.getParentFile().mkdirs()) {// 判断创建目录是否成功
					System.out.println("创建目标文件所在的目录失败！");
				}
			}
			ImageIO.write(bi, "png", qrFile);
		}
		ImageIO.write(bi, "png", out);
		String base64Qr = Base64.getEncoder().encodeToString(out.toByteArray());
		out.flush();
		// System.out.println("Input Encoded data is：" + encodeddata);
		return base64Qr;
	}

	//

	/**
	 * 解析二维码，返回解析内容
	 * 
	 * @param imageFile
	 *            //二维码路径
	 * @return
	 */
	public static String qrCodeDecode(File imageFile) {
		String decodedData = null;
		QRCodeDecoder decoder = new QRCodeDecoder();
		BufferedImage image = null;
		try {
			image = ImageIO.read(imageFile);
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		try {
			decodedData = new String(decoder.decode(new J2SEImage(image)), "UTF-8");
			System.out.println("Output Decoded Data is：" + decodedData);
		} catch (DecodingFailedException dfe) {
			System.out.println("Error: " + dfe.getMessage());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return decodedData;
	}

	/**
	 * 生成二维码图片
	 * 
	 * @param filePath
	 *            生成路径和名称(为""不写入硬盘)
	 * @param encodeddata
	 *            二维码内容
	 * @return base64Qr
	 */
	public static String createQrcode(String filePath, String encodeddata) {
		String base64Qr = "";
		try {
			base64Qr = QRCodeUtils.qrCodeEncode(encodeddata, filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return base64Qr;
	}

	/**
	 * 生成二维码图片
	 * 
	 * @param filePath
	 *            生成路径和名称(为""不写入硬盘)
	 * @param encodeddata
	 *            二维码内容
	 * @return
	 */
	public static boolean createQrcodeReturn(String filePath, String encodeddata) {
		String base64Qr = "";
		try {
			String content = new String(encodeddata.getBytes(), "UTF-8");
			base64Qr = QRCodeUtils.qrCodeEncode(content, filePath);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		// String qr = createQrcode("D:\\qrcode\\a.png", "测试二维码");
		// System.out.println(qr);
		qrCodeDecode(new File("D:\\qrcode\\a.png"));

	}
}

class J2SEImage implements QRCodeImage {
	BufferedImage image;

	public J2SEImage(BufferedImage image) {
		this.image = image;
	}

	public int getWidth() {
		return image.getWidth();
	}

	public int getHeight() {
		return image.getHeight();
	}

	public int getPixel(int x, int y) {
		return image.getRGB(x, y);
	}
}
