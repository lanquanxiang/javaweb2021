package cn.pzhu.dao;

import cn.pzhu.pojo.User;

public interface UserDAO extends GenericDAO<User, String>{
	//不需要扩展接口，通用接口已经能够满足需求
}
