package cn.pzhu.dao;

import cn.pzhu.pojo.User;

public interface UserDAO extends GenericDAO<User, String>{
	//因为通用接口中已经能够满足需求，不再派生新的接口方法
}
