package cn.pzhu.dao;

import java.util.List;

/**
 * 
 * @param <E> 表示数据表的映射类，包含所有字段
 * @param <K> 表示数据表的主键
 */
public interface GenericDAO<E,K> {
	//在通用接口中定义针对所有数据表的通用操作，如增删改查
	public int insert(E e);
	
	public int delete(K k);
	
	public int update(E e);
	
	public E selectById(K k);
	public List<E> select();
}
