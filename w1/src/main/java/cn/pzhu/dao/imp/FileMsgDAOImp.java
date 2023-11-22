package cn.pzhu.dao.imp;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.pzhu.dao.FileMsgDAO;
import cn.pzhu.pojo.FileMsg;
import cn.pzhu.util.DruidUtil;

public class FileMsgDAOImp implements FileMsgDAO{
	
	private JdbcTemplate template = new JdbcTemplate(DruidUtil.getDs());

	@Override
	public int add(FileMsg e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean update(FileMsg e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FileMsg selectById(Integer k) {
		String sql="select * from filemsg where fileid=?";
		try {
			return template.queryForObject(sql, new BeanPropertyRowMapper<FileMsg>(FileMsg.class),k);
		} catch (Exception e) {
			return null;//当没有结果集的时候，BeanPropertyRowMapper会抛异常，直接返回null，表示没有查到数据
		}
		
	}

	@Override
	public List<FileMsg> selectAll() {
		String sql="select * from filemsg";
		try {
			return template.query(sql, new BeanPropertyRowMapper<FileMsg>(FileMsg.class));
		} catch (Exception e) {
			return null;//当没有结果集的时候，BeanPropertyRowMapper会抛异常，直接返回null，表示没有查到数据
		}
	}

	@Override
	public List<FileMsg> selectByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FileMsg> selectByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Integer fileid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FileMsg> selectByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FileMsg> selectByPage(int page, int num) {
		String sql="select * from filemsg limit ?,?";
		try {
			return template.query(sql, new BeanPropertyRowMapper<FileMsg>(FileMsg.class), (page-1)*num , num);
		} catch (Exception e) {
			return null;//当没有结果集的时候，BeanPropertyRowMapper会抛异常，直接返回null，表示没有查到数据
		}
	}

	@Override
	public int selectCount() {
		String sql = "select count(*) as count from filemsg";
		return template.queryForObject(sql, Integer.class);
	}

}
