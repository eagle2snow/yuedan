package com.gm.api.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.gm.base.config.BaseConfig;

@Component
public class SendMail {

	private static final Logger logger = LoggerFactory.getLogger(SendMail.class);

	@Autowired
	private JavaMailSender mailSender;

	public void sendSimpleMail(String to, String subject, String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("349424253@qq.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);
		try {
			mailSender.send(message);
			logger.info("简单邮件已经发送。");
		} catch (Exception e) {
			logger.error("发送简单邮件时发生异常！", e);
		}

	}

	public void sendHtmlMail(String to, String subject, String content) {
		try {
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setFrom("349424253@qq.com");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content, true);
			mailSender.send(mail);
			logger.info("html邮件已经发送。");
		} catch (MessagingException e) {
			logger.error("发送html邮件时发生异常！", e);
		}
	}

	/**
	 * 注册成功，发送激活邮件
	 */
	public void sendRegSuccess(String to, String auth) {
		String content = "尊敬的商家：<br>" + "感谢您注册使用《如你网》。<br>" + "请点击如下链接进行账号激活，激活后您可继续进行入驻申请： <br>" + BaseConfig.baseUrl
				+ "/web/store/activeEmailAccount?auth=" + auth + "<br><br>" + "如果链接无法打开浏览器窗口，请直接复制上述地址到浏览器地址栏中打开。<br>"
				+ "如果不是您本人申请，请直接删除此邮件，抱歉给您带来的不便。<br>" + "本邮件为系统自动发送，不受理客户在线回复，如果您需要与我们联络，请致电0771-5850332<br>" + "《如你网》";
		sendHtmlMail(to, "激活账号", content);
	}

	/**
	 * 发送重置密码链接
	 * 
	 * @param email
	 */
	public void sendResetPasswordLink(String email, String auth) {
		String content = "尊敬的商家：<br>" + "感谢您使用《如你网》。<br>" + "请点击如下链接进行重置密码： <br>" + BaseConfig.baseUrl
				+ "/web/store/reSetPassword?e=" + email + "&auth=" + auth + " <br><br>"
				+ "如果链接无法打开浏览器窗口，请直接复制上述地址到浏览器地址栏中打开。<br>" + "如果不是您本人申请，请直接删除此邮件，抱歉给您带来的不便。<br>"
				+ "本邮件为系统自动发送，不受理客户在线回复，如果您需要与我们联络，请致电0771-5850332<br>" + "《如你网》";
		sendHtmlMail(email, "重置密码", content);

	}



	/**
	 * 更换邮箱成功，发送激活邮件
	 */
	public void sendModifiyEmail(String to, String auth) {
		String content = "尊敬的商家：<br>" + "您的邮箱已更换成功。<br>" + "请点击如下链接进行账号激活，激活后您可继续进行入驻申请： <br>" + BaseConfig.baseUrl
				+ "/web/store/activeEmailAccount?auth=" + auth + "<br><br>" + "如果链接无法打开浏览器窗口，请直接复制上述地址到浏览器地址栏中打开。<br>"
				+ "如果不是您本人申请，请直接删除此邮件，抱歉给您带来的不便。<br>" + "本邮件为系统自动发送，不受理客户在线回复，如果您需要与我们联络，请致电0771-5850332<br>" + "《如你网》";
		sendHtmlMail(to, "激活账号", content);
	}
	/**
	 * 修改邮箱验证码
	 * @param to
	 * @param code
	 */
	public void updateEmailCode(String to,String code){
		String content = "尊敬的商家：<br>"+"本次邮箱验证码为：<span style='color: #CE0000;font-size: 30px'>"+code+"</span><br>验证码10分钟内有效。"
				+"<br>如果不是您本人申请，请直接删除此邮件，抱歉给您带来的不便<br>"+"本邮件为系统自动发送，不受理客户在线回复，如果您需要与我们联络，请致电0771-5850332<br>" + "《如你网》";
		sendHtmlMail(to, "邮箱验证码", content);
	}

}
