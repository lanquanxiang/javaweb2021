# 1. 三层架构
1. 表现层（用户直接访问，直接可见的--JSP、HTML、Servlet）
2. 业务层（进行业务处理，eg.登录、注册、修改密码）
3. 持久层（对数据表进行增删改查，eg.select、insert、update  CRUD）
# 2. 设计原则
1. 依赖倒转（依赖于抽象不依赖于具体实现）——面向接口编程
2. 单一职责（一个类的功能尽可能的单一）
3. 开闭原则（对扩展开放，对修改关闭）
4. 接口隔离（尽可能的缩小接口的范围）
5. 里氏替换（在继承中，尽可能的扩展父类方法，不重写方法）
6. 迪米特法则（不和陌生人说话）
7. 合成复用（尽可能的使用关联和依赖，不使用继承）
# 3. JDBC
## 1. 什么是JDBC
1. 一套Java的类和接口（标准）
2. 是用来进行数据库操作
3. 位于java.sql.*
## 2. 什么是数据库驱动
接口的实现
## 3. 数据库连接步骤
1. 注册驱动
	不使用DriverManager的方法，原因是因为会造成驱动重复注册
	使用Class.forName
2. 建立连接
	1. url【重点】
	2. 用户名
	3. 密码
3. 编写SQL
	1. 无参
	2. 有参数
4. 创建命令对象
	1. Statement
	2. PreparedStatement【执行有参数的SQL】
5. 执行SQL
	1. 执行查询 executeQuery 返回的是ResultSet
	2. 执行更新 executeUpdate 返回的是影响的行数 int
6. 处理结果
	1. 结果集
		读行：很多条while(res.next()) 最多只有一条 if(res.next())
 		读列：getXXX(第n列  或 列的名字) X表示类型
	2. 影响行数
7. 释放资源
	1. 释放的方法close
	2. 释放资源及顺序：结果集-->命令对象-->连接
	3. 注意：实际开发过程中，一般会采用连接池，释放连接并不是真正的关闭，而是归还连接，这个时候连接上面的命令和结果集都没有被释放
# 4. JDBC优化
1. 驱动只注册一次
2. 获得连接不需要参数（参数在程序加载的时候自动获取）
	1. 所有的参数保存到外部文件
	2. 在程序运行过程中读入参数
3. 释放资源（针对不用场景进行资源释放）函数重载