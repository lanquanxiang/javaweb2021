package cn.pzhu.dao;

import java.util.List;

import cn.pzhu.pojo.FileMsg;

public interface FileMsgDAO extends GenericDAO<FileMsg, Integer>{
	//查询所有
	public List<FileMsg> selectAll();
	//根据类别查询
	public List<FileMsg> selectByType(String type);
	//根据分享者查询
	public List<FileMsg> selectByUsername(String username);
	//删除文件
	public int delete(Integer fileid);
	//根据关键词查询
	public List<FileMsg> selectByKeyword(String keyword);
	

}
