# 1. JDBC在操作中存在的问题
1. 存在大量重复代码，降低开发效率
2. 查询操作产生的结果集，处理效率低
# 2. JDBC操作优化
## 1. DBUtils（了解）
1. 利用连接池提高数据库连接效率（性能优化）
2. 封装了增删改操作update（返回值都是int）
	int update(String sql,Object[] params); //params表示的sql中?的值
3. 封装了查询操作query（返回的可能是object[单条]、List<object>[多条]）
	单条查询：XXX object = (XXX) runner.query(sql, new BeanHandler(XXX.class), Object[] params);
	多条查询：List<XXX> list = (List) runner.query(sql, new BeanListHandler(XXX.class), Object []params);
## 2. JdbcTemplate(掌握)
1. 初始化
	```private JdbcTemplate template = new JdbcTemplate(DruidUtil.getDs());```
2. 更新
3. 单条查询
4. 多条查询

# 3. 检测用户名是否被占用
1. JS事件onchange
2. 在页面增加显示提示的容器--span
3. 基于jQuery的Ajax $.post--防止数据被缓存，显示的信息与服务器不一致
4. 创建了控制器--初始化业务层接口
5. 实现了业务层接口

# 4. 验证码
1. 修改验证码请求地址
2. 创建控制器
3. 创建工具类
4. 绘制验证码
5. 扩展（中文）
	1. GB2312编码（区位码、双字节16位）区码（AA）+位码(BB)
	2. 16-55区（B0-D7区：176-215，A1-FE位：161-254）收录3755个一级汉字
	3. 验证码的分类
		1. 图像识别
		2. 行为验证码（拼图、旋转、点击特定的汉字（识别+行为））
		3. 推理计算（识别+计算）