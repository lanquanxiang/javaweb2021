package cn.pzhu.service.imp;

import java.util.List;

import cn.pzhu.dao.FileMsgDAO;
import cn.pzhu.dao.imp.FileMsgDAOImp;
import cn.pzhu.pojo.FileMsg;
import cn.pzhu.service.FileMsgService;

public class FileMsgServiceImp implements FileMsgService{
	
	private FileMsgDAO dao = new FileMsgDAOImp();

	@Override
	public List<FileMsg> showFileMsgByPage(int page, int num) {
		if (num < 1) {
			num = 10;
		}
		if (num > 100) {
			num = 100;
		}
		if (page < 1) {
			page = 1;
		}
		int n = dao.countFileMsg(); // 总条数
		int pages = (n % num == 0) ? (n / num) : (n / num + 1);
		if(page > pages) {
			page = pages;
		}

		return dao.selectAll(page, num);
	}

	@Override
	public StringBuffer createBar(int page, int num, String path) {
		if (num < 1) {
			num = 10;
		}
		if (num > 100) {
			num = 100;
		}
		if (page < 1) {
			page = 1;
		}
		int n = dao.countFileMsg(); // 总条数
		int pages = (n % num == 0) ? (n / num) : (n / num + 1);
		if(page > pages) {
			page = pages;
		}
		
		StringBuffer bar = new StringBuffer();
		if(page!=1) {
			bar.append("<a href='"+path+"?page="+(page-1)+"&num="+num+"'>上一页</a>");
		}
		
		for(int i=1;i<=pages;i++) {
			if(page==i) {
				bar.append("["+i+"]");
			}else {
				bar.append("<a href='"+path+"?page="+i+"&num="+num+"'>"+i+"</a>");
			}
			   //如果页数可能很多的情况下，建议只显示当前页的前后5条
		}
		
		if(page!=pages) {
			bar.append("<a href='"+path+"?page="+(page+1)+"&num="+num+"'>下一页</a>");
		}
		
		return bar;
	}

}
