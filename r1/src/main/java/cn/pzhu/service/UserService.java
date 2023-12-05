package cn.pzhu.service;
/**
 * 用户模块的服务
 */

import cn.pzhu.pojo.Message;
import cn.pzhu.pojo.User;
import cn.pzhu.pojo.UserInfo;

public interface UserService {
	//登录
	public Message login(User user);
	
	public Message sendEmail(String username, String email);
	
	
	
	//注册
	public Message regist(User user, UserInfo userinfo);
	
	//个人信息查看
	public UserInfo showUserInfo(String username); 
	
	//个人信息修改
	public Message changeUserInfo(UserInfo userinfo);
	
	//修改密码
	/**
	 * 需要验证旧密码是否正确，而且新密码和旧密码不能一样
	 * @param user 包含用户名，旧密码
	 * @param newPassword 新密码
	 * @return
	 */
	public Message changePassword(User user,String newPassword);
	
	//注销账户
	public Message destroy(String username);
	public boolean isExist(String username);

}
