# 1. 数据库操作的优化
## 1. JDBC操作存在的问题
1. 大量重复的代码，降低我们的开发效率
2. 查询中，需要将结果集映射为Java数据（Object、List），操作相对麻烦
## 2. DBUtils工具（了解）
1. 利用连接池来进行初始化并操作数据库，提高数据库操作效率
2. 使用update操作封装所有的写（增删改）
	int update(String sql, Object[] params);
3. 使用query操作封装所有的读（单条、多条），并且能够将结果集自动转换为Java数据类集合
	query(sql,ResultSetHandler接口的实现类,参数（数组）)
		ResultSetHandler接口的实现类:
			单条：new BeanHandler(XXX.class)
			多条：new BeanListHandler(XXX.class)
## 3. JdbcTemplate（Spring）考试
1. 初始化操作工具
2. 更新
3. 单条查询
4. 多条查询

# 2. Ajax实现检测用户名是否被占用
1. 在合适的位置增加提示的容器--span
2. 选择合适的事件来触发--为input账号的文本框增加onchange
3. 声明事件函数--$.post()发送异步请求
	$.get/post() 为什么使用post？--post不会缓存数据
4. 创建控制器
	1. 初始化业务层接口
	2. 接受参数
	3. 调用业务查询
	4. 输出查询结果
5. 实现了业务层（调用持久层实现）

# 3. 验证码
1. 修改视图
2. 创建控制器
3. 创建工具类