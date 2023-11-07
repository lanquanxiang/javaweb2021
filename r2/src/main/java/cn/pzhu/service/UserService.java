package cn.pzhu.service;

import cn.pzhu.pojo.Result;
import cn.pzhu.pojo.User;
import cn.pzhu.pojo.UserInfo;

public interface UserService {
	//登录
	public Result login(User user);
	//注册
	public Result regist(User user, UserInfo userinfo);
	//查看个人信息
	public UserInfo showUserInfo(String username);
	//修改个人信息
	public Result changeUserInfo(UserInfo userinfo);
	//修改密码
	//修改密码的时候需要验证旧密码，同时不允许旧密码和新密码一样
	public Result changePassword(String username,String oldpassword,String newpassword);
	//注销账户
	//注销账户的时候需要再次核对密码
	public Result destroy(User user);
	public boolean isExist(String username);
	
}
