package cn.pzhu.service.imp;

import cn.pzhu.dao.UserDAO;
import cn.pzhu.dao.imp.UserDAOImp;
import cn.pzhu.pojo.Result;
import cn.pzhu.pojo.User;
import cn.pzhu.pojo.UserInfo;
import cn.pzhu.service.UserService;

public class UserServiceImp implements UserService{
	//初始化数据访问层接口【考试】
	private UserDAO userdao = new UserDAOImp();

	@Override
	public Result login(User user) {
		if(user==null || user.getUsername()==null || user.getPassword()==null) {
			return new Result(false, "前端数据异常！");
		}
		if(user.getUsername().equals("")) {
			return new Result(false, "用户名不能为空！");
		}
		if(user.getPassword().equals("")) {
			return new Result(false, "密码不能为空！");
		}
		User dbuser = userdao.selectById(user.getUsername());
		if(dbuser==null) {
			return new Result(false, "用户不存在！");
		}
		if(dbuser.getStatus()==0) {
			return new Result(false, "此用户已经被注销！");
		}
		if(!dbuser.getPassword().equals(user.getPassword())) {
			return new Result(false, "密码输入错误！");
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
	public boolean destroyAccount(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
