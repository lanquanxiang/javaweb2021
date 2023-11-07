package cn.pzhu.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.pzhu.dao.UserDAO;
import cn.pzhu.pojo.User;
import cn.pzhu.util.DriudUtil;
import cn.pzhu.util.JDBCUtil;

public class UserDAOImp implements UserDAO{
	
	/*初始化jdbctemplate【考试】*/
	private JdbcTemplate template = new JdbcTemplate(DriudUtil.getDs());

	@Override
	public int insert(User e) {
		int n =0;
		Connection con = null;
		PreparedStatement sta = null;
		try {			
			 con = JDBCUtil.getConnetion();
			String sql = "insert into user values(?,?,?)";
			sta = con.prepareStatement(sql);
			sta.setString(1,e.getUsername());
			sta.setString(2,e.getPassword());
			sta.setInt(3,e.getStatus());
			n=sta.executeUpdate();				
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			JDBCUtil.close(con, sta);
		}
		return n;
	}

	@Override
	public int delete(String k) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(User e) {
		String sql = "update user set password=? , status=? where username=?";
		return template.update(sql, e.getPassword(),e.getStatus(),e.getUsername());
	}

	@Override
	public User selectById(String k) {
		Connection con = null;
		PreparedStatement sta = null;
		ResultSet res = null;
		try {			
			 con = JDBCUtil.getConnetion();
			String sql = "SELECT * FROM user where username=?";
			sta = con.prepareStatement(sql);
			sta.setString(1,k);			
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

	@Override
	public List<User> select() {
		String sql="select * from user";
		try {
			return template.query(sql, new BeanPropertyRowMapper<User>(User.class));
		} catch (Exception e) {
			return null;
		}
		
	}

}
