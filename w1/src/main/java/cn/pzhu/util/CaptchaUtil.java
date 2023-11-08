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
	
	private void init() {
		int width = 80;
		int height = 25;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		
		String ans="";
		Random random = new SecureRandom();
		char[] arrays = "QWERTYUIOPLKJHGFDSAZXCVBNMqwertyuioplkjhgfdsazxcvbnm0123456789".toCharArray();
		for (int i = 0; i < 4; i++) {
			int index = random.nextInt(arrays.length);
			ans = ans+ arrays[index];
		}
		
		g.setColor(Color.black);
		for (int i = 0; i < 5; i++) {
			int x1 = random.nextInt(width/4);
			int y1 = random.nextInt(height);
			
			int x2 = random.nextInt(width/4)+width*3/4;
			int y2 = random.nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}
		
		g.setFont(new Font("Times new Roman", Font.BOLD, 20));		
		g.drawString(ans, width/4, height*3/4);
		
		this.ans = ans;
		this.image = image;
		
	}
	

}
