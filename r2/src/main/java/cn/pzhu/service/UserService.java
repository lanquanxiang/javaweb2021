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
	
	//检验用户名和邮箱，如果数据库中存在就发送邮件
	/***
	 * 
	 * @param username 用户名
	 * @param email 邮箱
	 * @return 如果发送成功，返回发送的验证码，用于登录校验；如果失败，返回失败的原因
	 */
	public Result sendEmail(String username, String email);
	
}
