package cn.pzhu.dao;

import java.io.Serializable;

/**
 * 定义针对所有表的通用操作：增删改查
 * @param <E> 表的映射类
 * @param <K> 表的主键类型
 */
public interface GenericDAO<E,K extends Serializable> {
	
	//1. 增加
	public boolean add(E e);
	//2. 删除
	public int delete(K k);
	//3. 修改
	public boolean update(E e);
	//4. 查询（精确查找）
	public E selectById(K k);
	
	
	
}
