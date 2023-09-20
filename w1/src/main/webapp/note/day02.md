# 1. JSP基础知识
## 1. JSP概念
1. JSP（*.jsp 本质上也是Java） --> Servlet(*.java 附带了处理请求和相应的功能) --> Java (*.java)
2. JSP：可以直接编写HTML的Java
## 2. JSP执行机制【简答题】
1. JSP转换为Servlet（index.jsp-->index_jsp.java）
2. servlet编译为class文件
3. 再执行class文件
## 3. JSP构成
1. JSP指令
2. HTML、CSS、JavaScript
3. Java代码段 <% java代码(句子) %>
4. java表达式（显示内容） <%=  %>
5. JSP动作元素、注释<%--  --%>
6. JSP全局变量 <%! 全局的变量或者静态函数  %>
## 4. JSP指令（page、include、taglib）
### 1. page
1. errorPage="URI" 表示如果出现错误，应该跳转到URI继续处理
2. isErrorPage="true" 表示该页面用于处理错误，增加一个exception对象
3. 常见的运行时异常有哪些？【考试】
	1. 空指针异常
	2. 数组下标越界
	3. 算术运算异常（除数为0）
	4. 数字格式化异常
	5. 类转换异常
	6. 输入输出异常
4. 如何显示正常的错误页面，不显示IE友好提示信息。
	1. 手动关闭IE高级选项中的友好提示消息
	2. 增加错误页面内容，超过默认值
	3. （推荐）手动设置服务器状态为200（500-->200）
5. 为网站增加全局的错误页面404
### 2. include包含
1. 需要共同的菜单、页脚（导入其他页面：将公共页面部分抽取为单独的新页面）
2. <%@ include file="" %>
3. 此命令包含的是源代码（要注意是否存在代码冲突）
4. 相对路径以“/”开头，是相对于项目根目录，不是站点根目录（服务器）
5. 为了防止源码冲突，建议使用include动作元素
	1. <jsp:include page=""></jsp:include>
	2. 包含的是结果，建议使用此方法导入其他页面
### 3. taglib标签库
1. prefix标签前缀  <c:if></c:if>
2. uri库的地址

# 2. JSP内置对象【重点】
1. out
2. request response【重要】
3. request session application
4. page pageContext config exception
## 1. out输出（JspWriter）
1. 作用：向客户端输出内容（很少在JSP中使用）
2. 通过response得到一个printWriter的out实例（建议）
## 2. 请求和响应
### 1. request
1. 获得请求方式 getMethod():限制服务的访问方式
2. 获取指定的请求头信息getHeader("referer")获取访问来源，用来防盗链
3. 获取web应用程序路径 getContextPath() ：将相对路径转换为绝对路径
4. 获取客户端的IP或主机 getRemoteAddr/Host()：黑白名单
5. [重要]获得请求参数 getParamter(参数的名字)
	1. 返回的是字符串，有可能需要进行类型转换，有可能产生类型转换异常
	2. 如果文本框什么都不填，服务器得到的是""，x!=null&&!x.equals("")
	3. 如果参数名不存在（没有取名字，打错了），得到null
	4. 此方式不适用于多选框、可多选的下拉列表
	5. 如果可能存在多个值，应该使用getParameterValues(java.lang.String)
		1. 返回的是字符串数组，如果要显示具体内容，需要进行遍历
		2. 如果参数不存在，返回null
		3. 如果参数值只有一个，依旧是数组，只是数组的长度是1
	6. 如果用此方法去获取多个值，只能得到第一个值
6. 重置请求参数编码 setCharacterEncoding​() 
	1. 一般编码设置UTF-8
	2. 必须在获得参数之前调用此方法
	3. 此方法只适用于post提交乱码
	4. 如果get提交乱码，XXX-->iso8859-1字节数组--> 再UTF-8构造为字符串
	``` new String(username.getBytes("ISO8859-1"),"UTF-8");```
7. 执行请求转发
	```request.getRequestDispatcher("新的地址").forward(request, response);```
8. 读取cookie
### 2. response
1. 设置响应状态码setStatus(200)[正常]  sendError(500)[异常];
```
response.sendError(404);
```
2. 设置指定的头信息setHeader() 
```
设置响应内容类型
response.setHeader("content-type", "MIME");
禁止缓存
response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache");
response.setDateHeader("Expires", 0);	
自动刷新和跳转
response.setHeader("refresh", "1");
response.setHeader("refresh", "1;URL=''");
```
3. 设置响应内容类型response.setContentType()
4. 执行重定向
	```response.sendRedirect("新的地址");```
5. 写入cookie 
### 3. 请求转发和重定向的区别【简答题】
1. 请求响应次数：一次请求一次响应						多次请求多次响应
2. 地址栏变化：显示请求地址（B和D不一致）相对路径异常 	显示最后一次请求的地址（D）
3. 新地址范围：只能是服务器内部（可以到不能直接访问路径WEB_INF）	任意地址
4. 参数有效期：request一直携带参数			参数失效
应用：不需要隐藏路径，不需要到达不可访问路径，都可以使用重定向