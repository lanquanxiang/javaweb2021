package cn.pzhu.dao.imp;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.pzhu.dao.FileMsgDAO;
import cn.pzhu.pojo.FileMsg;
import cn.pzhu.util.DriudUtil;

public class FileMsgDAOImp  implements FileMsgDAO{
private JdbcTemplate template=new JdbcTemplate(DriudUtil.getDs());
	@Override
	public int insert(FileMsg e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer k) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(FileMsg e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FileMsg selectById(Integer k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FileMsg> select() {
		String sql="select * from filemsg";
		try {
			return template.query(sql, new BeanPropertyRowMapper<FileMsg>(FileMsg.class));
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public List<FileMsg> selectbykeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FileMsg> selectbyusername(String username) {
		// TODO Auto-generated method stub
		return null;
	}


}
