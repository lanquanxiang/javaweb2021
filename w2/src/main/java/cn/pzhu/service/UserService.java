package cn.pzhu.service;

import cn.pzhu.pojo.Result;
import cn.pzhu.pojo.User;
import cn.pzhu.pojo.UserInfo;

public interface UserService {
	//1.登录
	public Result login(User user);
	//2.注册
	public Result regist(User user,UserInfo userinfo);
	//3.查看个人信息
	public UserInfo showUserInfo(String username);
	//4.修改个人信息
	public Result changeUserInfo(UserInfo userinfo);
	//5.修改密码
	//需要旧密码：确认身份；新密码和旧密码不能一样
	public Result changePassword(String username,String oldpassword,String newpassword);
	//6.注销账号
	public boolean destroyAccount(String username);
	
	public String check(String username);
}
