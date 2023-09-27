# 1. JavaBean
## 1. 分类
1. 值JavaBean（封装数据POJO）【考试：根据表编写映射类】
	1. 表名直接映射为类名（首字母大写）
	2. 所有字段映射为私有成员
	3. 私有成员变量名首字母不能大写（后续框架开发中可能无法找到大写的成员）
	4. 提供公开的无参构造方法或有参构造方法
	5. 提供公开的get/set方法
	6. 【重要】私有成员类型必要使用包装类型（int--> Integer）
		float-->Float  double-->Double char-->Character
2. 工具JavaBean（处理数据）--> 【表现层】、业务层、持久层

# 2. Servlet开发

