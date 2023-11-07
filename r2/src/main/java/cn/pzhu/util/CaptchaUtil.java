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
	private void init() {
		int width = 80;
		int height = 25;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB );
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, width, height);
		graphics.setColor(Color.black);
		char[] eles= "0123456789qwertyuipasdfghjkzxcvbnmQWERTYUPASDFGHJKLZXCVBNM".toCharArray();
		String ans="";
		Random random = new SecureRandom();
		for(int i=0;i<4;i++) {
			ans+=eles[random.nextInt(eles.length)];
		}
		this.ans = ans;
		
		//增加干扰
		for (int j = 0; j < 5; j++) {
			int x1 = random.nextInt(width/4);
			int y1 = random.nextInt(height);
			int x2 = random.nextInt(width/4) + width*3/4;
			int y2 = random.nextInt(height);
			graphics.drawLine(x1, y1, x2, y2);
		}
		
		graphics.setFont(new Font("Times new Roman", Font.BOLD, 20));
		graphics.drawString(ans, width/8, height*3/4);
		this.image = image;
		
	}
	public BufferedImage getImage() {
		return image;
	}
	public String getAns() {
		return ans;
	}
	

}
