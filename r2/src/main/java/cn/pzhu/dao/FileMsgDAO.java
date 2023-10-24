package cn.pzhu.dao;

import java.util.List;

import cn.pzhu.pojo.FileMsg;

public interface FileMsgDAO extends GenericDAO<FileMsg, Integer>{
	//1.扩展查询所有的文件
	public List<FileMsg> selectAll();
	
	//2.扩展分类查看
	public List<FileMsg> selectByType(String type);
	
	//3.按照人名来查询
	public List<FileMsg> selectByUsername(String username);
	
	//4.按照关键词来查询
	public List<FileMsg> selectByKeyword(String keyword);

}
