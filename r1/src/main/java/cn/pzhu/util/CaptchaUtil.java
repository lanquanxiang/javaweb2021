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
		init();
	}
	public BufferedImage getImage() {
		return image;
	}
	public String getAns() {
		return ans;
	}
	/**
	 * 初始化验证码
	 */
	private void init() {
		int width = 80;
		int height = 25;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, width, height);
		graphics.setColor(Color.black);
		Random random = new SecureRandom();
		char[] arrays = "QWERTYUPASDFGHJKLZXCVBNMqwertyuipasdfghjkzxcvbnm0123456789".toCharArray();
		String ans="";
		for(int i=0;i<4;i++) {
			ans+=arrays[random.nextInt(arrays.length)];
		}
		this.ans = ans;
		for(int j=0;j<5;j++) {
			int x1 = random.nextInt(width/4);
			int y1 = random.nextInt(height);
			//int x2 =  random.nextInt(width*3/4,width);
			int x2 =  random.nextInt(width/4)+width*3/4;
			int y2 = random.nextInt(height);
			graphics.drawLine(x1, y1, x2, y2);
		}
		graphics.setFont(new Font("Times New Roman", Font.BOLD, 20));
		graphics.drawString(ans, width/5, height*4/5);
		this.image = image;
	}
	
	

}
