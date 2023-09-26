# JavaBean
## 1. 分类
1. 值JavaBean（POJO、映射类）只有数据（私有成员）
	1. 成员变量必须私有的
	2. 成员变量首字母不能大写【使用框架时可能无法找到大写开头的变量】
	3. 需要有无参构造方法、有参构造（一般要求public） 单例设计模式private
	4. 成员变量必须是包装类型（int--Integer）【方便框架使用】
	5. 提供public修饰的get/set方法
2. 工具JavaBean（模型：业务层、持久层）

# EL表达式
1. 语法 ${}
2. 作用
	1. 进行运算:算术运算、逻辑运算、关系运算、条件运算 ${1+1}
	2. 读取对象中的属性 ${user.username}
	3. 读取集合/数组中的值 ${array[index]}
	4. 判空 ${empty x} 判断x是否为null或""   ${not empty x} 
	5. ${pageContext.request.contextPath} 上下文路径：将相对路径转换为相对服务器路径