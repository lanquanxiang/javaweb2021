# JSP基础
## 1. 什么是JSP？
Java服务器页面（可以编写HTML的Java文件）
JSP（.jsp 内置了很多对象（8个）） → Servlet（.java 处理HTTP请求和响应） → Java(.java) → class文件（*.class）
## 2. JSP运行原理【考试：简答题】
	JSP转换为Servlet（Java文件），编译为class文件，再执行
## 3. JSP构成
1. JSP指令 page
2. html、css、js
3. Java代码或表达式
	1. Java代码段  <%  完整的代码（;）  %>
	2. 表达式  <%=   %>
	3. java全局变量（函数）定义  <%!    %>
	4. jsp的注释  <%--   --%>
# JSP指令（page、include、taglib）
## 1. page指令
1. isErrorPage = true 表示该页面是处理错误的（内置exception对象）
2. errorPage=URI 如果当前页面发生了错误，应该到什么地址去继续处理
3. 【考试】Java的常见运行时异常有哪些？
	1. 空指针 nullpointerException
	2. 数组越界
	3. 算术逻辑异常 1/0
	4. 类型转换异常
	5. 输入输出异常
4. 如何解决不显示错误内容？显示的是HTTP友好提示。
	1. 关闭HTTP友好提示（×）
	2. 增加错误页面内容超过阈值
	3. 重置状态码500为200
5. 为项目配置全局的错误页面
```
  <error-page>
  	<error-code>404</error-code>
  	<location>/temp/404.jsp</location>
  </error-page>
```
## 2. include包含 
1. 属性file
2. 包含源代码（注意变量重复定义）[注：以/开头，是相对于应用程序根目录，不是服务器根目录]
3. 一般使用jsp动作标签<jsp:include page=''></jsp:include> （包含页面）
## 3. taglib标签库
1. prefix前缀
2. uri地址
# JSP内置对象
## 1. out
1. 所属类型是JspWriter
2. 以后我们一般使用response.getWriter()
3. response.getWriter()通常在servlet中使用，直接向客户端输出内容
## 2. request response【重要：考试(程序设计25分)】
### 1. request
1. getContextpath() 可用来获取根路径，构造相对服务器路径，解决请求转发造成的地址错误
2. getRemoteHost/Addr() 获取请求客户端的主机名或IP地址，用来设置黑白名单
------------
3. getHeader() //referer 防盗链
-----【重点】------
4. 获得参数【重要】
```
request.getParameter("username")
1. 返回的是字符串，注意类型转换，注意是否为空串 "".equals(v)
2. 此方法只适用于单个值（多选、可多选的下拉列表除外）
3. 如果参数的名字不存在（写错了），得到null（可能产生空指针异常）
request.getParameterValues​(java.lang.String name)
1. 返回的是字符串数组
2. 如果参数名不存在，返回null
3. 如果参数只有一个值，返回的还是数组，只是数组的长度为1

```
5. 解决请求数据的乱码
```
setCharacterEncoding​(java.lang.String encoding)
1. 此方法只适用于post提交乱码
2. 此方法必须在获取请求参数的值之前被调用
3. 如果get提交方式乱码：重构参数值xxx的编码 new String(xxx.getBytes("ISO8859-1"),"UTF-8");
```
6. 执行请求转发
```
request.getRequestDispatcher("").forward(request, response)
```
### 2. response
1. setStatus() 设置状态码
------------------
2. 设置响应内容类型 setContentType("text/html")
3. 控制缓存（三种）
```
response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache");
response.setDateHeader("Expires", 0);	
```
4. 自动刷新或跳转 response.setHeader("refresh","2;URL=''");
---------------------------------
5. 响应内容给客户端（out=response.getWriter()）
6. 设置响应内容的编码
7. 执行重定向
```
response.sendRedirect("")
```
### 请求转发和重定向的区别
1. 
## 3. request session application
## 4. page pagecontext config exception

