package cn.pzhu.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
	private static String driver=null;
	private static String url=null;
	private static String user=null;
	private static String password=null;
	//确保下面的代码只运行一次
	static {
		//读文件
		InputStream in = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
		Properties pro = new Properties();
		try {
			pro.load(in);
		} catch (IOException e) {			
			e.printStackTrace();
		}
		driver = pro.getProperty("driver");
		url = pro.getProperty("url");
		user = pro.getProperty("user");
		password = pro.getProperty("password");
		//注册驱动
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//2.封装一个不需要参数的获取连接的方法
	public static Connection getConnetion() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//3.封装释放资源的方法
	public static void close(Connection con, Statement sta, ResultSet res) {
		if(res!=null) {
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(sta!=null) {
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void close(Connection con, Statement sta) {
		close(con,sta,null);	
	}
	public static void close(Connection con, PreparedStatement sta, ResultSet res) {
		close(con,(Statement)sta,res);
	}
	public static void close(Connection con, PreparedStatement sta) {
		close(con,(Statement)sta,null);
	}

}
