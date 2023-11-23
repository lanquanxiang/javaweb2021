package cn.pzhu.service.imp;

import java.util.List;

import cn.pzhu.dao.FileMsgDAO;
import cn.pzhu.dao.imp.FileMsgDAOImp;
import cn.pzhu.pojo.FileMsg;
import cn.pzhu.service.FileMsgService;

public class FileMsgServieImp implements FileMsgService{
	private FileMsgDAO dao = new FileMsgDAOImp();

	@Override
	public List<FileMsg> showFileMsg() {
		return dao.selectAll();
	}

	@Override
	public List<FileMsg> showByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
