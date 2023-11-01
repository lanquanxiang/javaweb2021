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
	private static DataSource ds=null; //创建空白数据源
	//静态代码块的代码在程序加载的时候运行，只运行一次
	static {
		ds = new ComboPooledDataSource();//空号中不填名字，表示使用默认配置
	}
	/**
	 * 为外部程序提供数据源
	 * @return
	 */
	public static DataSource getDs() {
		return ds;
	}
	@Test
	public void test() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getConnection());
		}
	}
	/**
	 * 自定义一个无参的获得连接的静态方法
	 * @return
	 */
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = ds.getConnection();//直接从连接池中得到连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(Connection con, Statement sta, ResultSet res) {
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
	public static void close(Connection con, Statement sta) {
		close(con, sta, null);
	}
	public static void close(Connection con, PreparedStatement sta, ResultSet res) {
		close(con, (Statement)sta, res);
	}
	public static void close(Connection con, PreparedStatement sta) {
		close(con, (Statement)sta, null);
	}

	
}
