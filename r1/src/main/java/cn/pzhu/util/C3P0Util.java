package cn.pzhu.util;

import java.sql.*;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	private static DataSource ds = null;
	// 确保下面的代码只运行一次
	static {
		ds = new ComboPooledDataSource();
	}

	public static DataSource getDs() {
		return ds;
	}

	// 2.封装一个不需要参数的获取连接的方法
	public static Connection getConnetion() {
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	// 测试
	@Test
	public void test() {
		for (int i = 0; i < 11; i++) {
			Connection con = getConnetion();
			System.out.println(con);
			if (i == 5) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// 3.封装释放资源的方法
	public static void close(Connection con, Statement sta, ResultSet res) {
		if (res != null) {
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (sta != null) {
			try {
				sta.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void close(Connection con, Statement sta) {
		close(con, sta, null);
	}

	public static void close(Connection con, PreparedStatement sta, ResultSet res) {
		close(con, (Statement) sta, res);
	}

	public static void close(Connection con, PreparedStatement sta) {
		close(con, (Statement) sta, null);
	}

}
