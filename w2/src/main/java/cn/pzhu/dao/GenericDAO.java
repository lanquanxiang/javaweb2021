package cn.pzhu.dao;

/**
 * 这是一个通用接口，封装了针对所有表的通用操作
 * @param <E> 表示数据表的映射类，表数据的封装
 * @param <K> 表示数据表的主键类型
 */
public interface GenericDAO<E,K> {
	//1.增加
	public boolean insert(E e);
	//2.删除
	//因为用户模块没有物理删除，所以不写在通用接口中
	//3.修改
	public int update(E e);
	//4.查询
	public E selectById(K k);
}
