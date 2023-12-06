package cn.pzhu.service;

import java.util.List;

import cn.pzhu.pojo.FileMsg;

public interface FileMsgService {
	//1. 分页显示文件列表
	public List<FileMsg> showFileMsgByPage(int page ,int num);
	//2. 分类查看	
	//3. 分享文件
	//4. 我的分享（查询某个人分享的所有文件）
	//5. 删除我的分享
	//6. 修改我的分享
	//7. 文件模糊查询
	//8. 按照日期排序、按照推荐指数排序……
	//9. 创建导航栏
	public StringBuffer createBar(int page,int num);
}
