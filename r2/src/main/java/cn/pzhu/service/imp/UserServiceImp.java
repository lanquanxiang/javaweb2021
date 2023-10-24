package cn.pzhu.service.imp;

import cn.pzhu.dao.UserDAO;
import cn.pzhu.dao.imp.UserDAOImp;
import cn.pzhu.pojo.Result;
import cn.pzhu.pojo.User;
import cn.pzhu.pojo.UserInfo;
import cn.pzhu.service.UserService;

public class UserServiceImp implements UserService {
	//初始化持久层接口【考试】
	private UserDAO dao = new UserDAOImp();

	@Override
	public Result login(User user) {
		if(user==null || user.getUsername()==null || user.getPassword()==null) {
			return new Result(false, "数据异常!");
		}
		if("".equals(user.getUsername())) {
			return new Result(false, "用户名不能为空!");
		}
		if("".equals(user.getPassword())) {
			return new Result(false, "密码不能为空!");
		}
		if(user.getPassword().length()<6) {
			return new Result(false, "密码长度不足6位!");
		}
		
		User dbuser = dao.selectById(user.getUsername());
		if(dbuser==null) {
			return new Result(false, "此用户不存在!");
		}
		if(dbuser.getStatus()==0) {
			return new Result(false, "此用户已经被注销!");
		}
		if(!user.getPassword().equals(dbuser.getPassword())) {
			return new Result(false, "你输入的密码错误!");
		}		
		return new Result(true, "登录成功！");
	}

	@Override
	public Result regist(User user, UserInfo userinfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo showUserInfo(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result changeUserInfo(UserInfo userinfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result changePassword(String username, String oldpassword, String newpassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result destroy(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
