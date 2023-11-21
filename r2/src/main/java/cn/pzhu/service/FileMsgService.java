package cn.pzhu.service;

import java.util.List;

import cn.pzhu.pojo.FileMsg;

public interface FileMsgService {
	//1.显示文件列表（分页）
	public List<FileMsg> showFileMsgByPage(int page,int num);
	//2.分类查看
	
	//3.分享文件
	
	//4.按照某个人检索文件（我的分享）
	
	//5.删除我的分享
	
	//6.修改我的分享
	
	//7.按照时间排序文件
	
	//8.按照推荐指数排序文件
	//……
}
