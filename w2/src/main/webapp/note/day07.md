# 1. Statement存在的问题
1. 有参数的SQL需要进行参数拼接，参数拼接较为繁琐
2. 参数拼接之后的SQL语句可读性变差，可维护性也会变差
3. 存在安全问题（SQL注入式攻击）
	原理：在SQL的参数中加入特殊字符，达到篡改SQL语句的目的  eg. 'or'1'='1
	SELECT * FROM USER WHERE username=''OR'1'='1' AND PASSWORD=''OR'1'='1'
	防止：1. 不允许输入特殊字符；2. 预编译SQL
# 2. PreparedStatement预编译的命令对象
1. PreparedStatement是Statement的子接口，用于执行带参数的SQL语句
2. PreparedStatement优点
	1. 使用？占位，编写SQL更方便
	2. 可读性更高
	3. 可维护性更强
	4. 安全性更高（防止SQL注入）
	5. 执行效率更高（一次编译）
# 3. 三层架构【重要】
## 1. 设计数据访问层
1. 设计通用接口（为所有的表操作制定标准，为了方便维护）
2. 设计子接口（具体化泛型的类型，扩展接口以满足业务需求）
3. 设计子接口的实现类