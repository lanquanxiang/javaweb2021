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
1. 初始化  private JdbcTemplate template = new JdbcTemplate(DruidUtil.getDs());
2. 更新 int num = template.update(sql, Object... params);
3. 单行读取 XXX object = template.queryForObject(sql,new BeanPropertyRowMapper<XXX>(XXX.class), Object... params);
4. 多行读取List<XXX> list = (List<XXX>)  template.query(sql,new BeanPropertyRowMapper<XXX>(XXX.class), Object... params);

# 3. Ajax异步请求（验证用户名是否被占用）
1. JS事件判断用户是否已经输入完用户名 onchange
2. 基于jQuery的Ajax  $.get()  $.post("url",jsondata,function(data){})【数据不会被缓存】
3. 使用DOM将data显示在网页上  $("#note").html(data)

# 4. 验证码
1. 为什么需要验证码？ 防止恶意用户和机器滥用网站服务
2. 目的：区分人和计算机
3. 分类：
	1. 图像（语音）识别类
	2. 用户行为类
	3. 逻辑推理类

