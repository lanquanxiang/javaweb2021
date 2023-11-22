# 1. 数据加密
1. 为什么进行数据加密？
	1. 提高系统的安全性，防止密码泄露
	2. 需要对敏感信息加密，防止用户信息泄露
2. 如何加密
	1. 原理：通过一定的规则将数据进行变换
	2. 加密规则：1）可逆的规则；2：不可逆的规则
3. 不可逆算法
	1. MD5
	2. 其他...
# 2. MD5
1. 概念：信息摘要算法（第五版）
2. 作用：确保信息一致性（散列计算出32位16进制字符串）
3. 特点（了解）
4. 注意：
	1. 使用强加密的算法
	2. 可以对算法进行加盐操作
# 2. 数据存储（保存账号和密码）
1. 方法：session、cookie
2. session（服务器的会话中）
	增删改查、session的销毁（立即销毁、设置有效期）
3. cookie（客户端的浏览器中）
	1. 初始化cookie
		new Cookie(name,value)
		1. name唯一标识，不能修改，自定义名称
		2. value存储值，不能存储中文（抛异常）
		3. 如果需要存储中文，需要对中文进行编码，然后再存储；取出来之后需要解码
	2. 增删改查
		1. 增加
			1. 编码cookie的值 URLEncoder
			2. 初始化cookie
			3. 设置有效期
			4. 向浏览器写入 response.addCookie();
		2. 删除 cookie.setMaxAge(0);
		3. 修改 cookie.setValue();
		4. 查询 ${cookie.cookie的名字.value}
			1. 获取所有的cookie  request.getCookies()
			2. 遍历所有的cookie
			3. 根据名字来查找所需要的cookie
			4. 取值 cookie.getValue()
			5. 解码 URLDecoder
# 3. 分页显示
1. 为什么？
	1. 减轻网页渲染负担
	2. 提高用户体验
2. 分页方法
	1. 逻辑分页（按需显示）
		查询所有数据--> 根据需要截取其中一部分数据 -->显示这一部分
	2. 物理分页（按需查询）page num
		查询部分数据（根据需要查询）--> 显示查询结果
		对sql进行修改，使用limit来限制查询范围
		limit 起始位置index,length
		SELECT * FROM filemsg LIMIT (page-1)*num,num