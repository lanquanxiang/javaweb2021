package cn.pzhu.dao;

/**
 * 通用接口，针对所有数据表的操作
 * @param <E> 数据表的映射类型（表的所有字段封装的POJO）
 * @param <K> 数据表主键的类型，必须是包装类型
 */
public interface GenericDAO<E,K> {
	//增加
	public int add(E e);
	//删除（用户表没有删除--逻辑删除update）
	//修改
	public boolean update(E e);
	//查询
	public E selectById(K k);

}
