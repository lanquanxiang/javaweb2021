# 1. 数据加密
## 1. 概述 
1. 为什么加密？
	1. 防止密码泄露
	2. 敏感（涉及用户隐私）
2. 如何加密？
	1. 原理：使用一定的规则对数据进行变换
	2. 加密手段：
		1. 可逆的加密
		2. 不可逆的加密（md5）
## 2. MD5
1. 概念：信息摘要算法第五版
2. 作用：确保信息的一致性
3. 算法（散列）：md5（128）SHA-1（100+）SHA-224 SHA-256 SHA-384 SHA-512（512）
4. 注意：
	1. 在项目开发中，只使用一次哈希算法，不够安全
	2. 建议对数据进行多次加密，或加盐操作（username+password）
## 2. 数据保存
1. 数据保存：session（域对象-服务器）、cookie（客户端）
2. cookie创建 new Cookie(name,value)
3. name唯一标志，不能修改
4. value不能保存中文（如果有中文需要存储，需要进行编码URLEncoder和解码）
## 3. cookie的使用
1. 增加 response.addCookie(待添加的cookie) 
2. 删除 待删除的cookie.setMaxAge(0);
3. 修改 待修改的cookie.setValue(新的值);
4. 查询  ${cookie.需要的cookie的名字.value}
	1. 获得所有的cookie request.getCookies()  
	2. 遍历cookies
	3. 根据name查找所需要的cookie，取出cookie的值  cookie.getVaule()
	4. 如果是中文需要进行解码 URLDecoder
	
## 3. 分页显示
1. 为什么？
	1. 减轻网页渲染负担，防止网页崩溃
	2. 提高用户体验
2. 方法
	1. 逻辑分页（按需显示）
		查询所有数据list，通过代码将list分割成小的list（每页），显示其中一页
	2. 物理分页（按需查询）
		查询所需要的数据（只查其中一页的数据：sql限制查询范围） limit