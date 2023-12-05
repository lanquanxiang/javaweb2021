package cn.pzhu.util;

import java.security.SecureRandom;
import java.util.Random;

import org.apache.commons.mail.SimpleEmail;

import cn.pzhu.pojo.Result;

public class EmailUtil {
	public static Result sendEmail(String email) {
		SimpleEmail se = new SimpleEmail();
		se.setHostName("smtp.exmail.qq.com");  //se.setHostName("smtp.qq.com");//个人QQ邮箱
		se.setSmtpPort(465);
		se.setSSLOnConnect(true);
		se.setAuthentication("admin@pzhuweb.cn", "uSzTbaPdqkUfHSWD"); //请使用自己的邮箱和授权码
		
		try {
			se.addTo(email);
			se.setFrom("admin@pzhuweb.cn");
			se.setSubject("文件分享系统登录验证码");
			
			Random random = new SecureRandom();
			String code="";
			for(int i = 0;i<6;i++) { //随机6次
				code+=random.nextInt(10); //随机0-9的数字
			}			
			se.setMsg("你的登录验证码是："+code);
			se.send();
			return new Result(true, code);//如果发送成功，在消息中返回验证码，提供给控制器校验
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "邮件发送失败");
		}
	}

}
