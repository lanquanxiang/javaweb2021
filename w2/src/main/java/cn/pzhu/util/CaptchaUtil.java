package cn.pzhu.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.security.SecureRandom;
import java.util.Random;

public class CaptchaUtil {
	private BufferedImage image;
	private String ans;
	public CaptchaUtil() {
		//在构造器中初始化验证码
		int width = 80;
		int height = 25;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, width, height);
		
		ans="";
		char[] elements="0123456789QWERTYUIOPLKJHGFDSAZXCVBNMmnbvcxzasdfghjklpoiuytrewq".toCharArray();
		Random random = new SecureRandom();
		for (int i = 0; i < 4; i++) {
			int index = random.nextInt(0,elements.length);
			ans+=elements[index];
		}
		graphics.setColor(Color.black);
		for (int i = 0; i <5; i++) {
			int x1 = random.nextInt( 0, width/4);
			int y1 = random.nextInt(0,height);
			//int x2 = random.nextInt( 0, width/4) + width*3/4;
			int x2 = random.nextInt(width*3/4,width);
			int y2 = random.nextInt(0,height);
			graphics.drawLine(x1, y1, x2, y2);
		}
		graphics.setFont(new Font("Times new Roman", Font.BOLD, 20));
		graphics.drawString(ans, width/8, height*4/5);
	}
	public BufferedImage getImage() {
		return image;
	}
	public String getAns() {
		return ans;
	}
	
	

}
