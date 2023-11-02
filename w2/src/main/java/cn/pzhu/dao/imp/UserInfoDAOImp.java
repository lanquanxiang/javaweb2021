package cn.pzhu.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.pzhu.dao.UserInfoDAO;
import cn.pzhu.pojo.UserInfo;
import cn.pzhu.util.JDBCUtil;

public class UserInfoDAOImp implements UserInfoDAO {

	@Override
	public boolean insert(UserInfo userinfo) {
		Connection con = null;
		PreparedStatement sta = null;
		try {			
			con = JDBCUtil.getConnection();
			String sql = "insert into userinfo values(?,?,?,?)";
			sta = con.prepareStatement(sql);//创建预编译的命令对象
			sta.setString(1, userinfo.getUsername());//为问号赋值
			sta.setString(2, userinfo.getEmail());
			sta.setInt(3, userinfo.getGender());
			sta.setString(4, userinfo.getType());
			int n = sta.executeUpdate();//n表示影响的行数
			if(n!=0) {
				return true;
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {			
			JDBCUtil.close(con, sta);			
		}	
		return false;
		
	}

	@Override
	public int update(UserInfo e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserInfo selectById(String k) {
		// TODO Auto-generated method stub
		return null;
	}

}
