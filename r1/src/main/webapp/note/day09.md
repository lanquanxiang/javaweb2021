# 1. 数据库操作优化
## 1. 存在问题
1. CRUD操作存在大量重复的代码
2. 代码不够精简，代码量太大，效率不高
## 2. DBUtils(了解)
1. 初始化（利用连接池进行初始化工具类）
2. 更新update     int runner.update(sql,Object[] params)
3. 单条查询 Object  Object dao.query(sql,new BeanHander(类的反射),Object[] params)
4. 多条查询 List<Object> dao.query(sql,new BeanListHander(类的反射),Object[] params)
## 3. JdbcTemplate（考试）
1. 初始化
	1. 导入jar包
	2. 你用连接池初始化jdbctemplate
2. 更新template.update(sql, Object...)
3. 单条查询template.queryForObject(sql, new BeanPropertyRowMapper<XXX>(XXX.class),Object...);
4. 多条查询template.query(sql, new BeanPropertyRowMapper<XXX>(XXX.class),Object...);

# 2. 检测用户名是否存在
1. 为用户名的文本框添加事件（onchange）
2. 在文本框后面增加提示的文本（span）为了不影响布局，position绝对定位
3. 基于jQuery的Ajax（$.get/post） 使用post（防止用户名的检测结果缓存）
4. 控制器（接收参数，调用业务层查看用户）
5. 业务层（增加了判断用户是否存在的接口）

# 3. 验证码
1. 验证码的作用
2. 修改视图层
3. 创建控制器
4. 创建工具类
5. 刷新验证码