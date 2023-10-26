package cn.pzhu.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.pzhu.dao.UserDAO;
import cn.pzhu.pojo.User;
import cn.pzhu.util.JDBCUtil;

public class UserDAOImp implements UserDAO {

	@Override
	public boolean insert(User e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int update(User e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectById(String k) {
		Connection con = null;
		PreparedStatement sta = null;
		ResultSet res= null;
		try {			
			con = JDBCUtil.getConnection();
			String sql = "select * from user where username=?";
			sta = con.prepareStatement(sql);//创建预编译的命令对象
			sta.setString(1, k);//为问号赋值
			res = sta.executeQuery();//预编译命令在执行的时候不需要SQL
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
