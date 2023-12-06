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
	/*旧密码用来验证用户*/
	public Result changePassword(String username,String oldpassword,String newpassword);
	//6.注销账户
	public boolean destroy(String username);
	public boolean isAvaliable(String username);
	
	//7. 发送邮件
	public Result sendEmail(String username, String email);
}
