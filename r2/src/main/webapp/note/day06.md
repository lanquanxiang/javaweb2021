# 1. 三层架构
1. 表现层（用户直接访问，对用户可见）
2. 业务层（为用户提供服务，注册）
3. 持久层（对数据库进行CRUD，insert into user/userinfo）
注意：业务层、持久层：面向接口编程
# 2. 软件设计原则
1. 单一职责
2. 开闭原则（对修改关闭，对扩展开发）
3. 里氏替换（尽可能扩展父类，不重新父类方法）
4. 接口隔离（接口的职责尽可能简单）
5. 依赖倒转（依赖于抽象不依赖于实现）
6. 迪米特法则（不和陌生人说话）
7. 合成复用（尽可能使用依赖和关联，少使用继承）

# 3. JDBC
## 1. 什么是JDBC？
1. Java数据库连接
2. 本质上一套接口和类
## 2. 什么是JDBC驱动？
本质上就是接口的实现
## 3. JDBC开发
1. 注册驱动
	1. DriverManager来注册（×）底层使用了Class.forName() 驱动重复注册
	2. Class.forName()