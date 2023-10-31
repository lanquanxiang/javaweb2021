package cn.pzhu.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	private static DataSource ds = null;
	//静态代码块：程序启动自动运行，只运行一次
	static {
		ds = new ComboPooledDataSource();//没有参数，默认使用default-config
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
