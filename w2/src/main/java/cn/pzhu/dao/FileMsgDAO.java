package cn.pzhu.dao;

import java.util.List;

import cn.pzhu.pojo.FileMsg;

public interface FileMsgDAO extends GenericDAO<FileMsg, Integer>{
	//1.查询所有
	public List<FileMsg> selectAll();
	//2.按照类别查询
	public List<FileMsg> selectByType(String type);
	//3.按照用户查询
	public List<FileMsg> selectByUsername(String username);
	//4.删除分享的文件
	public int delete(Integer fileid);
	//5.按照关键词查询
	public List<FileMsg> selectByKeyword(String keyword);

}
