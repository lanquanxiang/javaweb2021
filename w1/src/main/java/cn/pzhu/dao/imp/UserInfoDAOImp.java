package cn.pzhu.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.pzhu.dao.UserInfoDAO;
import cn.pzhu.pojo.UserInfo;
import cn.pzhu.util.JDBCUtil;

public class UserInfoDAOImp implements UserInfoDAO {

	@Override
	public int add(UserInfo userinfo) {
		Connection con = null;
		PreparedStatement sta = null;
		try {
			con = JDBCUtil.getConnection();
			String sql = "INSERT INTO userinfo values(?,?,?,?)"; 
			sta = con.prepareStatement(sql);
			sta.setString(1, userinfo.getUsername());//为问号赋值
			sta.setString(2, userinfo.getEmail());
			sta.setInt(3,userinfo.getGender());
			sta.setString(4, userinfo.getType());
					
			int m = sta.executeUpdate();
			return m;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {			
			JDBCUtil.close(con, sta);
		}
		
		return 0;
	}

	@Override
	public boolean update(UserInfo e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserInfo selectById(String k) {
		// TODO Auto-generated method stub
		return null;
	}

}
