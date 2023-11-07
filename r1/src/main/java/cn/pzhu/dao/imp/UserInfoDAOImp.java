package cn.pzhu.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.pzhu.dao.UserInfoDAO;
import cn.pzhu.pojo.UserInfo;
import cn.pzhu.util.DriudUtil;
import cn.pzhu.util.JDBCUtil;

public class UserInfoDAOImp implements UserInfoDAO{
	
	private JdbcTemplate template = new JdbcTemplate(DriudUtil.getDs());

	@Override
	public int insert(UserInfo e) {
		int n =0;
		Connection con = null;
		PreparedStatement sta = null;
		try {			
			 con = JDBCUtil.getConnetion();
			String sql = "insert into userinfo values(?,?,?,?)";
			sta = con.prepareStatement(sql);
			sta.setString(1,e.getUsername());
			sta.setString(2,e.getEmail());
			sta.setInt(3,e.getGender());
			sta.setString(4,e.getType());
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
	public int update(UserInfo e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserInfo selectById(String k) {
		String sql="select * from userinfo where username=?";
		try {
			return template.queryForObject(sql, new BeanPropertyRowMapper<UserInfo>(UserInfo.class),k);
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public List<UserInfo> select() {
		// TODO Auto-generated method stub
		return null;
	}

}
