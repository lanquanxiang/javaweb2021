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

}
