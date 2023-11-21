package cn.pzhu.dao;

import java.util.List;

import cn.pzhu.pojo.FileMsg;

public interface FileMsgDAO extends GenericDAO<FileMsg, Integer>{
	public List<FileMsg> selectbykeyword(String keyword);
	public List<FileMsg> selectbyusername(String username);
}
