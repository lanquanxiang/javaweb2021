package cn.pzhu.service.imp;

import java.util.List;

import cn.pzhu.dao.FileMsgDAO;
import cn.pzhu.dao.imp.FileMsgDAOImp;
import cn.pzhu.pojo.FileMsg;
import cn.pzhu.service.FileMsgService;

public class FileMsgServiceImp implements FileMsgService {
	
	private FileMsgDAO dao = new FileMsgDAOImp();

	@Override
	public List<FileMsg> showFileMsgByPage(int page, int num) {
		// 业务层的实现（数据校验、执行业务）
		if (num <= 0) {
			num = 10; // 如果数据不合法，重置为默认值
		}
		if (num > 50) {
			num = 50;
		}

		if (page <= 0) {
			page = 1; // 如果page为0或者是负数，默认显示第一页
		}
		int n = dao.selectCount();// 计算数据的总数量
		int pages = (n % num == 0) ? n / num : n / num + 1;
		if(page > pages) {
			page = pages; //如果page超过了总页数，重置为最后一页
		}
		return dao.selectByPage(page, num); //调用持久层接口进行查询
	}

	@Override
	public StringBuffer createBar(int page, int num) {
		if (num <= 0) {
			num = 10; // 如果数据不合法，重置为默认值
		}
		if (num > 50) {
			num = 50;
		}
		if (page <= 0) {
			page = 1; // 如果page为0或者是负数，默认显示第一页
		}
		int n = dao.selectCount();// 计算数据的总数量
		int pages = (n % num == 0) ? n / num : n / num + 1;
		if(page > pages) {
			page = pages; //如果page超过了总页数，重置为最后一页
		}
		
		StringBuffer bar = new StringBuffer();
		if(page>1) {
			bar.append("<a href='show?page="+(page-1)+"&num="+num+"'>上一页</a>");
		}
		
		for (int i = 1; i <= pages; i++) { //如果页数非常多，建议只显示当前页的前后5页 page-5 page+5
			if(page ==i) {
				bar.append("["+i+"]");
			}else {
				bar.append("<a href='show?page="+i+"&num="+num+"'>"+i+"</a>");
			}
		}
		
		if(page<pages) {
			bar.append("<a href='show?page="+(page+1)+"&num="+num+"'>下一页</a>");
		}
		return bar;
	}

}
