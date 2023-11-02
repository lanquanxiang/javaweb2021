package cn.pzhu.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class DruidUtil {
	private static DataSource ds = null;
	//静态代码块中的代码只运行一次，且在程序加载时运行
	static {
		//1. 读文件，给变量赋值
		InputStream in = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
		Properties pro = new Properties();
		try {
			pro.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ds = DruidDataSourceFactory.createDataSource(pro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static DataSource getDs() {
		return ds;
	}
	/**
	 * 创建了一个无参的获得连接的方法
	 * @return
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			con =  ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	@Test
	public void test() {
		for(int i= 0;i<10;i++) {
			System.out.println(getConnection());
		}
	}
	
	public static void close(Connection con,Statement sta, ResultSet res) {
		if(res!=null) {
			try {
				res.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(sta!=null) {
			try {
				sta.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void close(Connection con,Statement sta) {
		close(con, sta, null);			
	}
	public static void close(Connection con,PreparedStatement sta, ResultSet res) {
		close(con, (Statement)sta, res);
	}
	public static void close(Connection con,PreparedStatement sta) {
		close(con, (Statement)sta, null);
	}
	
	
	
	
	
	
	

}
