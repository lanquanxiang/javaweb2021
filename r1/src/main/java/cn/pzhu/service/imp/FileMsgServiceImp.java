package cn.pzhu.service.imp;

import java.util.List;

import cn.pzhu.dao.FileMsgDAO;
import cn.pzhu.dao.imp.FileMsgDAOImp;
import cn.pzhu.pojo.FileMsg;
import cn.pzhu.pojo.Message;
import cn.pzhu.service.FileMsgService;

public class FileMsgServiceImp implements FileMsgService{
	private FileMsgDAO dao = new FileMsgDAOImp();
	@Override
	public List<FileMsg> showFileMsg() {
		
		return dao.select();
	}

	@Override
	public List<FileMsg> showFileMsgbyType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message shareFileMsg(FileMsg filemsg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FileMsg> showFileMsgbyUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
