# 1. JSP
## 1. 概念
1. JSP（Java Server Page），java服务器页面
2. 可以编写HTML的Java
3. 本质：JSP(*.jsp)-->servlet（*.java）【HTTP请求和响应的处理】--> java（*.java）--> class(*.class)
## 2. JSP执行过程【简答】
1. JSP文件转换为Servlet
2. Servlet（*.java）编译为class文件
3. 执行class文件（JVM）
## 3. JSP构成
1. 指令
2. HTML、CSS、JS
3. java代码片段、java表达式、注释
## 4. JSP语法
1. 代码段 <%  java代码 %>
2. java表达式 <%=式子（不要加分号）   %>
3. 全局变量声明 <%!  全局代码 %>
4. 注释 <%--    --%>
# 2. JSP指令
## 1. page
1. isErrorPage声明该页面是否为处理错误的页面【是否具有exception】
2. errorPage 用来指定处理错误的路径
3. 常见的Java运行时异常有哪些？【简答题】
	1. 空指针异常
	2. 数组索引越界
	3. 算术逻辑异常
	4. 数字格式化异常
	5. 类转换异常
4. 如何不显示HTTP友好错误消息，显示自定义的错误页面？
	1. 关闭IE高级选项中的好友提示消息（不推荐）
	2. 自定义错误页面内容太少，没有价值
	3. 重置状态码（500-->200） ```response.setStatus(200);```
5. 如何给网站配置全局的404页面。
	1. 需要web.xml中配置
	2. 错误代码和错误类型同一个标签中只能选一个
## 2. include
1. 将页面的公共部分做成一个文件，然后导入到其他文件中
2. <%@ include file="" %>
3. 被包含的页面包含的是【源代码】--可能产生变量或代码冲突
	1. 使用动作元素代替，防止冲突
	2. <jsp:include page=""></jsp:include>包含的是【结果】
4. 以/开头，不是相对于服务器，而是相对于项目
5. 被包含的页面中建议删除html结构标记
## 3. taglib
1. prefix <c:if>
2. uri库的地址

# 3. [重要]JSP内置对象
1. out
2. request response
3. request session application
4. page pageContext config exception
## 1. out【JspWriter】
1. 向客户端输出内容
2. JspWriter输出内容到JSPWriter缓冲区，可能造成代码执行顺序和结果不一致
3. response.getWriter()得到一个PrintWriter对象【建议】
## 2. 【重要】request和response
### 1. request
1. getMethod()获得请求方式：限制提交方式
2. 获得请求头信息
	1. getContextPath() 获得项目根路径:将相对路径转换为绝对路径
	2. getRemoteAddr/Host()获得客户端IP地址：制作黑白名单
	3. getHeader("头字段") eg。referer 获得网站访问来源：防盗链
3. 【重点】request.getParamter()获得请求参数
	1. 返回的是一个字符串，可能需要进行类型转换，可能产生数字格式化异常
	2. 如果什么内容都不填写，得到的是""，if(x!=null&&x.equals(""))  if("".equals(x))
 	3. 如果参数参数名字不存在（忘记取名字，打错字母了），得到null，可能产生空指针异常
	4. 此方式不适用于多个值（多选框、可多选的下拉列表）
	5. 如果可能存在多个值，应该使用 getParameterValues(java.lang.String)
		1. 得到的是字符串数组，如果需要显示数组中的内容，需要遍历
		2. 如果参数不存在，得到null
		3. 如果只有一个值，得到的依旧是数组，只是长度为1
	6. 如果使用此方法来获取多个值，只能得到第一个值
4. 解决乱码 setCharacterEncoding​(java.lang.String encoding)
	1. 此方法必须在获取参数之前被调用
	2. 此方法只适用于post提交乱码
	3. get乱码：重构编码 xxx.getBytes("ISO8859-1")   new String(xxx.getBytes("ISO8859-1"),"utf-8")
5. 可以执行请求转发
	```request.getRequestDispatcher("path").forward(request, response);```
6. 读取cookie
### 2. response
1. setStatus() 设置服务器状态码 如果状态码表示异常，需要使用sendError()
2. 设置响应头信息
	1. response.setHeader(key,value) 设置任意头信息的值
	2. 禁止缓存【应用：验证码不能缓存】
	3. 自动跳转或自动刷新 
		```response.setHeader("refresh","时间-秒");response.setHeader("refresh","时间-秒;URL=''");```
3. 得到输出流response.getWriter()【printWriter】，向客户端输出内容
4. 解决响应乱码 response.setContentType("text/html; charset=UTF-8") 
5. 可以执行重定向
	```response.sendRedirect("path");```
6. 写入cookie 
### 3. 请求转发和重定向的区别
1. 请求响应次数：一次请求一次响应				多次请求多次响应
2. 请求参数有效：request携带参数				参数全部失效
3. path范围：服务器内部（转到不能直接访问的路径）任意路径
4. 地址栏变化：地址栏不变（第一次请求地址）[相对路径错误]	地址栏变化（最后一次请求地址）
总结：隐藏地址或达到不能直接访问的路径，使用请求转发。
	如果需要参数，可以使用存储对象进行数据存储。