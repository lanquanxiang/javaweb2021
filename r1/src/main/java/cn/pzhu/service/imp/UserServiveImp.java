package cn.pzhu.service.imp;

import cn.pzhu.dao.UserDAO;
import cn.pzhu.dao.imp.UserDAOImp;
import cn.pzhu.pojo.Message;
import cn.pzhu.pojo.User;
import cn.pzhu.pojo.UserInfo;
import cn.pzhu.service.UserService;

public class UserServiveImp implements UserService{
	//初始化持久层接口[考试]
	private UserDAO dao = new UserDAOImp();

	@Override
	public Message login(User user) {
		if(user.getUsername()==null || user.getPassword() ==null) {
			return new Message(false, "前端数据异常!");
		}
		if("".equals(user.getUsername())) {
			return new Message(false, "用户名不能为空!");
		}
		if("".equals(user.getPassword())) {
			return new Message(false, "密码不能为空!");
		}
		if(user.getPassword().length()<6) {
			return new Message(false, "密码长度不足6位!");
		}
		//查询数据是否存在该用户
		User dbuser = dao.selectById(user.getUsername());
		if(dbuser==null) {
			return new Message(false, "此用户不存在!");
		}
		if(dbuser.getStatus()==0) {
			return new Message(false, "此用户已经被注销!");
		}
		if(!dbuser.getPassword().equals(user.getPassword())) {
			return new Message(false, "密码错误!");
		}
		return new Message(true,"登录成功!");
	}

	@Override
	public Message regist(User user, UserInfo userinfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserInfo showUserInfo(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message changeUserInfo(UserInfo userinfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message changePassword(User user, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message destroy(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}