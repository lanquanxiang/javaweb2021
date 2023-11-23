package cn.pzhu.service;

import java.util.List;

import cn.pzhu.pojo.FileMsg;

public interface FileMsgService {
	//1. 显示文件列表
	public List<FileMsg> showFileMsg();
	//2. 分类查看
	public List<FileMsg> showByType(String type);
	//3. 分享文件（文件上传并且将上传的文件信息写入数据库）
	
	//4. 我的分享（按照用户名来查询分享的文件）
	
	//5. 修改我的分享、删除我的分享
	
	//6. 文件检索（模糊查询）
	
	//7. 其他(按照发布时间排序文件、按照推荐指数排序。。。)

}
