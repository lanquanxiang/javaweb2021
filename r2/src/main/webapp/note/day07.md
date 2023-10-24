# 1. PreparedStatement
## 1. Statement存在的问题
1. 编写较为复杂，参数拼接可读性差，不易编写
2. 不安全，存在SQL注入式攻击（'or'1'='1）
	原理：使用特殊字符，使得原来的SQL语句被篡改
	防止：1. 不允许输入特殊字符；2.预编译SQL
## 2. PreparedStatement
1. 使用？代替参数
2. 在执行之前使用set方法为问号赋值
3. 注意：PreparedStatement在创建的时候需要SQL，在执行的时候不需要SQL

## 3. PreparedStatement优点
1. PreparedStatement是Statement子接口
2. 优点：
	1. 可读性更高
	2. 更易于编写
	3. 更易于维护
	4. 效率更高（一次编译）
	5. 更安全（能够防止SQL注入式攻击）

# 2. 三层架构【重要】
