package cn.pzhu.service;

import java.util.List;

import cn.pzhu.pojo.FileMsg;
import cn.pzhu.pojo.Message;

public interface FileMsgService {
	//文件列表
	public List<FileMsg> showFileMsg();
	//分类查看
	public List<FileMsg> showFileMsgbyType(String type);
	//分享文件
	public Message shareFileMsg(FileMsg filemsg);
	//我的分享
	public List<FileMsg> showFileMsgbyUser(String username);
	//文件检索
	
	//删除分享
	
	//修改分享
	

}
