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
	
	//初始化jdbctemplate
	private JdbcTemplate template = new JdbcTemplate(DruidUtil.getDs()); //考试

	@Override
	public boolean add(User e) {
		Connection con = null;
		PreparedStatement sta = null;	
		try {			
			con = JDBCUtil.getConnection();
			String sql = "insert into user values(?,?,?)";
			sta = con.prepareStatement(sql);
			sta.setString(1, e.getUsername()); 
			sta.setString(2,e.getPassword());
			sta.setInt(3, e.getStatus());
			int n=sta.executeUpdate();
			if(n>0) {
				return true;
			}			
		} catch (SQLException ee) {
			ee.printStackTrace();
		}finally {
			JDBCUtil.close(con, sta );
		}
		return false;
	}

	@Override
	public int delete(String k) {
		String sql = "delete from user where username=?";
		return template.update(sql, k);
	}

	@Override
	public boolean update(User e) {
		String sql = "update user set password=?, status=? where username=?";
		int n= template.update(sql, e.getPassword(),e.getStatus(),e.getUsername());
		if(n!=0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public User selectById(String k) {
		Connection con = null;
		PreparedStatement sta = null;
		ResultSet res = null;		
		try {			
			con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM user WHERE username=?";
			sta = con.prepareStatement(sql);
			sta.setString(1, k); //为第一个问号赋值一个字符串（用户名k）			
			res = sta.executeQuery();//不需要参数，如果使用了参数，会认为在调用父类Statement的方法
			if(res.next()) {
				return new User(res.getString(1),res.getString(2),res.getInt(3));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, sta ,res);
		}
		return null;
	}

}
