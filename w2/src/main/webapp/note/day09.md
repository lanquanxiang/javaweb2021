# 1. JDBC操作存在的问题
1. 存在大量重复的代码，降低开发效率
2. 处理结果集的时候需要手动去遍历和数据封装
# 2. JDBC操作优化
## 1. DBUtils(了解)
1. 使用数据库连接池（DataSource）来进行数据库操作（初始化）
2. 写数据：int update(String sql,Object... params)
3. 读数据（单行）：Object 
4. 读数据（多行）：List<Object>
## 2. 常见的类库(了解)
1. QueryRunner：执行CRUD（封装了对数据库的基本操作）
	1. 写： int update(String sql,Object[] params)
	2. 读： Object/List<Object> query(String sql,接口的实现类, Object[] params)
2. ResultSetHandler（接口）：能够将结果集映射为常用数据集合
	1. 单行 new BeanHandler(XXX.class)--> Object
	2. 多行 new BeanListHandler(XXX.class) --> List<Object>
## 3. JdbcTemplate（考试）
1. 初始化
2. 更新
3. 单行读取
4. 多行读取