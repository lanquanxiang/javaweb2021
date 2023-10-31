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
	//静态代码块：程序启动自动运行，只运行一次
	static {
		//1.读取配置文件的参数
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
			e.printStackTrace();
		}		
	}
	public static DataSource getDs() {
		return ds;
	}
	@Test
	public void test() {
		for(int i=0;i<11;i++) {
			Connection con = getConnection();
			System.out.println(con);
			if(i==5) {
				try {
					con.close();//归还一次
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 创建一个无参的获取连接的静态方法
	 * @return
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return con;
	}
	
	public static void close(Connection con,Statement sta,ResultSet res) {
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
		close(con, sta ,null);
	}
	public static void close(Connection con,PreparedStatement sta,ResultSet res) {
		close(con, (Statement)sta ,res);
		
	}
	public static void close(Connection con,PreparedStatement sta) {
		close(con,  (Statement)sta ,null);
		
	}

}
