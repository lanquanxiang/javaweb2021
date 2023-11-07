package cn.pzhu.service.imp;

import java.util.regex.Pattern;

import cn.pzhu.dao.UserDAO;
import cn.pzhu.dao.UserInfoDAO;
import cn.pzhu.dao.imp.UserDAOImp;
import cn.pzhu.dao.imp.UserInfoDAOImp;
import cn.pzhu.pojo.Result;
import cn.pzhu.pojo.User;
import cn.pzhu.pojo.UserInfo;
import cn.pzhu.service.UserService;

public class UserServiceImp implements UserService {
	//初始化持久层接口【考试】
	private UserDAO dao = new UserDAOImp();
	private UserInfoDAO userinfodao = new UserInfoDAOImp();

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
		/*
		if(user.getPassword().length()<6) {
			return new Result(false, "密码长度不足6位!");
		}
		*/
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
		if(user==null || user.getUsername()==null || user.getPassword()==null) {
			return new Result(false, "数据异常!");
		}
		if("".equals(user.getUsername())) {
			return new Result(false, "用户名不能为空!");
		}
		if("".equals(user.getPassword())) {
			return new Result(false, "密码不能为空!");
		}
		String reg = "^[a-zA-Z0-9]{1,}@[a-zA-Z0-9]{1,}\\.[a-zA-Z0-9]{1,}$";
		if("".equals(userinfo.getEmail())) {
			return new Result(false, "邮箱不能为空!");
		}
		if(!Pattern.matches(reg, userinfo.getEmail())) {
			return new Result(false, "邮箱格式不正确!");
		}
		if("null".equals(userinfo.getType())) {
			return new Result(false, "没有选择关注的类型!");
		}
		if(dao.selectById(user.getUsername())!=null) {
			return new Result(false, "此账号已经被注册!");
		}
		if(dao.add(user)&&userinfodao.add(userinfo)) {//在实际开发过程中，如果只成果了一半，需要进行回退（删除已经成功插入的数据）
			return new Result(true, "注册成功!");
		}else {
			return new Result(false, "注册失败!");
		}
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

	@Override
	public boolean isExist(String username) {
		if(dao.selectById(username)==null) {
			return false;
		}
		return true;
	}

}
