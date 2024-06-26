package cn.pzhu.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;

import cn.pzhu.dao.UserDAO;
import cn.pzhu.pojo.User;
import cn.pzhu.util.DruidUtil;
import cn.pzhu.util.JDBCUtil;

public class UserDAOImp implements UserDAO{
	
	//初始化jdbctemplate(考试)
	private JdbcTemplate template = new JdbcTemplate(DruidUtil.getDs());

	@Override
	public int add(User user) {
		Connection con = null;
		PreparedStatement sta = null;
		try {
			con = JDBCUtil.getConnection();
			String sql = "INSERT INTO user values(?,?,?)"; 
			sta = con.prepareStatement(sql);
			sta.setString(1, user.getUsername());//为问号赋值
			sta.setString(2, user.getPassword());
			sta.setInt(3,user.getStatus());
			int n = sta.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {			
			JDBCUtil.close(con, sta);
		}
		return 0;
	}

	@Override
	public boolean update(User e) {
		String sql="update user set password=?, status=? where username=?";
		int num = template.update(sql, e.getPassword(),e.getStatus(),e.getUsername());
		if(num>0) {
			return true;
		}
		return false;
	}

	@Override
	public User selectById(String k) {
		Connection con = null;
		PreparedStatement sta = null;
		ResultSet res = null;
		try {
			con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM user where username=?"; 
			sta = con.prepareStatement(sql);
			sta.setString(1, k);//为问号赋值			
			res = sta.executeQuery();			
			if(res.next()) {
				return new User(res.getString(1),res.getString(2),res.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {			
			JDBCUtil.close(con, sta, res);
		}
		return null;
	}

}
