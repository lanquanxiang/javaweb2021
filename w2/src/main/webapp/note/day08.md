# 1. 数据库连接池
## 1. 概述
1. 原生JDBC存在的问题
	1. 频繁的创建和销毁连接（消耗时间和IO资源）-->降低效率
	2. 没有对创建数量的限制（连接加载到内存中）-->数据库崩溃
2. 数据库连接池
	1. 项目启动时，初始化一定数量（根据服务器能力以及访问量来决定）的连接
	2. 使用“申请连接”代替“创建连接”
	3. 使用“归还连接”代替“销毁连接”
3. 实现
	1. 手动：使用java集合来表示连接池，get/add/remove
	2. java 接口：
		1. 数据源 javax.sql.DataSource ds = new XXX();
		2. 从连接池中得到连接 ds.getConnetion();
# 2. 数据库连接池的实现
## 1. DBCP
1. 导入jar包
2. 编写配置文件
3. 加载配置文件
4. 初始化数据源 P235 文件11-3 line21
5. 为其他程序提供数据源或者是连接 ds.getConnection()
## 2. C3P0
1. 导入jar包
2. 编写配置文件(特殊字符需要转义)
3. 加载配置文件 自动读取根目录下的c3p0-config.xml
4. 初始化数据源 ds = new ComboPooledDataSource();
5. 为其他程序提供数据源或者是连接
## 3. Druid【阿里巴巴】
1. 导入jar包
2. 编写配置文件
3. 加载配置文件 
4. 初始化数据源ds = DruidDataSourceFactory.createDataSource(pro);
5. 为其他程序提供数据源或者是连接
	