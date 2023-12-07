package cn.pzhu.util;

import java.security.SecureRandom;
import java.util.Random;

import org.apache.commons.mail.SimpleEmail;

import cn.pzhu.pojo.Result;

public class EmailUtil {
	public static Result sendemail(String email) {
		SimpleEmail se = new SimpleEmail();
		//se.setHostName("smtp.qq.com");
		se.setHostName("smtp.exmail.qq.com");
		se.setSmtpPort(465);
		se.setSSLOnConnect(true);
		//修改为自己的邮箱和授权码
		se.setAuthentication("admin@pzhuweb.cn", "uSzTbaPdqkUfHSWD");
		try {
			se.addTo(email);
			se.setFrom("admin@pzhuweb.cn");
			se.setSubject("文件分享系统登录验证码");
			
			String code="";
			Random random = new SecureRandom();
			for (int i = 0; i < 8; i++) {
				code+=random.nextInt(10);
			}			
			se.setMsg("你的登录验证码是："+code);
			se.send();
			return new Result(true, code);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "邮件发送异常");
		}
	}
}
