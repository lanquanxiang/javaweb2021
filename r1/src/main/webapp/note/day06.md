# 1. 三层架构
1. 表现层
2. 业务层
3. 持久层
# 2. 设计原则（7种）
1. 单一原则
2. 依赖倒转（依赖接口不依赖实现）
3. 里氏替换
4. 迪米特法则（不和陌生人说话）
5. 接口隔离（尽可能的缩小接口的范围）
6. 合成复用（能够使用依赖就不使用继承）
7. 开闭原则
# 3. JDBC
## 1. 什么是JDBC？
1. Java DataBase Connectivity Java数据库连接
2. 一套访问数据库的标准（接口、类）
## 2. 为什么需要JDBC
为了实现标准化
## 3. 什么是数据库驱动
就是JDBC接口的实现（数据库厂商）
## 4. JDBC的步骤
1. 注册驱动
	不使用DriverManager进行注册，会造成驱动重复注册，底层使用了class.forName
	使用Class.forName("驱动的全类名")
2. 建立连接（URL、user、password）
	URL符合数据库地址规范 （注意高版本数据的参数设置）
3. 编写SQL语句
4. 创建命令对象（静态命令、预编译的命令）
5. 执行命令（查询executeQuery 更新 executeUpdate）
6. 处理结果
	1. 结果集
		while(res.next()){
			//循环读取每行的每个单元格
			1. getXXX()
			2. 参数可以填：1.列的索引，2.列的名字
		}
	2. 影响的行数 int
7. 释放资源
	1. 方法close
	2. 结果集 → 命令对象 → 连接
## 5. JDBC优化
1. 静态代码块来进行驱动注册
2. 将数据库配置信息（）保存到外部，程序加载时读取一次
3. 重载资源释放的方法