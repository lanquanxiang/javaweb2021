package cn.pzhu.dao.imp;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.pzhu.dao.UserInfoDAO;
import cn.pzhu.pojo.UserInfo;
import cn.pzhu.util.JDBCUtil;

public class UserInfoDAOImp implements UserInfoDAO{

	@Override
	public boolean add(UserInfo e) {
		Connection con = null;
		PreparedStatement sta = null;	
		try {			
			con = JDBCUtil.getConnection();
			String sql = "insert into userinfo values(?,?,?,?)";
			sta = con.prepareStatement(sql);
			sta.setString(1, e.getUsername()); 
			sta.setString(2,e.getEmail());
			sta.setInt(3, e.getGender());
			sta.setString(4, e.getType());
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(UserInfo e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserInfo selectById(String k) {
		
		return null;
	}

}
