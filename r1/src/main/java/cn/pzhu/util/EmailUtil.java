package cn.pzhu.util;

import java.security.SecureRandom;
import java.util.Random;

import org.apache.commons.mail.SimpleEmail;

import cn.pzhu.pojo.Message;

public class EmailUtil {
	public static Message sendEmail(String email) {
		SimpleEmail se = new SimpleEmail();
		se.setHostName("smtp.exmail.qq.com"); //se.setHostName("smtp.qq.com");
		se.setSmtpPort(465);
		se.setSSLOnConnect(true);
		se.setAuthentication("admin@pzhuweb.cn", "------");
		try {
			se.addTo(email);
			se.setFrom("admin@pzhuweb.cn");
			se.setSubject("文件分享系统登录验证码");
			
			Random random = new SecureRandom();
			String code="";
			for(int i=0;i<6;i++) {
				code+= random.nextInt(10);
			}			
			se.setMsg("你的验证码是："+code);
			se.send();
			return new Message(true, code);
		} catch (Exception e) {
			e.printStackTrace();
			return new Message(false, "发送失败");
		}
	}

}
