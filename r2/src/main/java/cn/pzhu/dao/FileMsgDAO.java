package cn.pzhu.dao;

import java.util.List;

import cn.pzhu.pojo.FileMsg;

public interface FileMsgDAO extends GenericDAO<FileMsg, Integer>{
	//1.扩展查询所有的文件
	public List<FileMsg> selectAll();
	
	public List<FileMsg> selectAll(int page,int num);//重载一个分页查询的方法
	public int countFileMsg(); //统计数据库中有多少条数据
	
	//2.扩展分类查看
	public List<FileMsg> selectByType(String type);
	
	//3.按照人名来查询
	public List<FileMsg> selectByUsername(String username);
	
	//4.按照关键词来查询
	public List<FileMsg> selectByKeyword(String keyword);

}
