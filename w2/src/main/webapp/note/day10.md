# 1. 数据加密
1. 为什么？
	1. 为了提高安全性，防止信息泄露
	2. 信息（敏感信息：密码、用户隐私）
2. 原理：通过一定的规则（自定义）对数据进行变换。
3. 规则分类：不可逆规则（建议）；可逆规则  g=f(x)
## 1. md5(不可逆规则)
1. 什么md5（信息摘要算法第五版）  散列函数  任意信息--> 128位字节--> 32位16进制
2. 作用：检验数据一致性
3. 特点：抗碰撞；抗修改
## 2. 实现加密
1. 尽量使用强哈希算法（SHA-224、SHA-256、SHA-384、SHA-512）
2. 设置复杂的规则，进行加盐操作

# 2. 数据存储
## 1. 方法
1. 域对象（page/request/session(重要)/application）【服务器】
2. cookie【客户端】
## 2. cookie
1. 初始化
	new Cookie(name,value);
	1. name：名称，唯一标识，不能修改
	2. value：值，不能保存中文，如果要存储中文需要进行编码ASCII
2. 操作
	1. 增加
		1. 对值进行编码 URLEncoder.encode()
		2. 构造cookie
		3. 设置有效期
		4. 写入客户端  response.addCookie()
	2. 删除 cookie.setMaxAge(0);
	3. 修改 cookie.setValue();
	4. 查询 ${cookie.名字.value}
		1. 获取所有的cookie  request.getCookies()
		2. 遍历所有的cookie 查找所需要的cookie  按照名 cookie.getName()
		3. 取值 cookie.getValue()
		4. 解码 URLDecoder.decode()

# 3. 分页显示
1. 为什么？
	1. 提高程序效率，减轻渲染负担，防止网页崩溃
	2. 提高用户体验，快速查看数据
2. 怎么实现？ page页 每页显示num条
	1. 逻辑分页（按需显示）
		查询所有数据list --> 按照需要分割所需的数据 小list --> 显示分割之后的数据
		
		
	2. 物理分页（按需查询）
		查询部分数据（根据需要，在sql中限制查询范围）
		SELECT * FROM filemsg LIMIT (page-1)*num,num