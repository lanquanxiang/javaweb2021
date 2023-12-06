package cn.pzhu.util;

import java.security.SecureRandom;
import java.util.Random;

import org.apache.commons.mail.SimpleEmail;

import cn.pzhu.pojo.Result;

public class EmailUtil {
	public static Result sendemail(String email) {
		SimpleEmail se = new SimpleEmail();
		//se.setHostName("smtp.qq.com");//个人邮箱
		se.setHostName("smtp.exmail.qq.com"); //企业邮箱
		se.setSmtpPort(465);
		se.setSSLOnConnect(true);
		//设置发送的账号和授权码（管理员的账号：用你自己的账号）
		se.setAuthentication("admin@pzhuweb.cn", "uSzTbaPdqkUfHSWD");
		try {
			se.addTo(email);//收件人（数据库中的用户邮箱）记得修改数据库的邮箱
			se.setFrom("admin@pzhuweb.cn");//发件人：修改成你自己的
			se.setSubject("文件分享系统验证码");
			String code="";
			Random random = new SecureRandom();
			for (int i = 0; i < 6; i++) {
				code += random.nextInt(10);
			}
			se.setMsg("你的登录验证码是："+code);
			System.out.println(code);
			return new Result(true, code);//返回正确的验证码，用于登录的时候验证用户输入的是否正确
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "邮件发送失败");
		}
	}

}
