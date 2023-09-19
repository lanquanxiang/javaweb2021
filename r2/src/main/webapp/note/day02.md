# 1. JSP基础
1. 概念：可以编写HTML的Java文件
2. JSP → Servlet（*.java 处理请求和响应） → Java → class
3. JSP的执行顺序【简答题】
	1. 先转换为Servlet（java文件）
	2. 编译为class字节码
	3. 最后再执行
4. JSP页面构成
	1. 指令
	2. HTML、CSS、JS
	3. Java代码
# 2. Java相关内容
1. Java代码段<%  Java句子;  %>
2. Java表达式 <%=表达式  %>
3. Java全局变量 <%!   %>
4. JSP注释  <%--   --%>
# 3. JSP指令
## 1. page指令
1. <%@ .... %>
2. page指令可以有多条
3. 【简答】常见的运行时异常有哪些？
	1. 输入输出异常
	2. 算术逻辑异常 1/0
	3. 数据类型转换异常（类转基础、类转类）
	4. 数组越界
	5. 空指针异常
4. 如何解决错误页面显示为友好提示消息？
	1. 关闭IE选项中的友好提示（×）
	2. 增加错误页面内容
	3. 重置状态码为200
5. 配置全局的错误页面
## 2. include指令（导入其他文件）
1. <%@include file=""/>
2. 导入的是文件的【源代码 int x=1;】
3. 注意：源码导入可能产生变量冲突或者代码冲突，一般情况下建议使用jsp:include
4. 注意：路径以“/”开头，不是相对于服务器，而是相当于当前Web应用
### <jsp:include page="页面"/>
## 3. taglib标签库
1. prefix前缀  <c:if></c:if>
2. uri:库的地址

# 4. JSP内置对象【重点】
1. out
2. request response【重点】
3. request session application
4. page pageContext config exception
## 1. out输出--JspWriter
1. 一般情况下，优先使用PrintWriter（response.getWriter()）进行输出
2. out.print()
## 2. request和response
### 1. request
1. getMethod() 获得请求方式：限制客户端的请求形式
2. getContextPath() 得到上下文路径：将相对路径转换为绝对路径
3. getRemoteAddr/Host()得到客户端的IP地址/主机名：设置黑白名单
4. getHeader("referer") 得到referer的值：用来防盗链 
5. 【重要】request.getParamter("参数名字")
	1. 得到的是字符串，可能需要进行类型转换
	2. 得到的字符串有可能是""， "".equals(value)
	3. 如果参数名不存在（写错了，忘记取名字），得到null，有可能发生空指针异常
	4. 此方式不适用于多个值（多选框、可多选的下拉列表）
	5. 如果可能存在多个值，应该使用getParameterValues(java.lang.String).
		1. 返回的永远都是数组
		2. 如果参数不存在，得到null
		3. 如果参数只有一个，数组长度唯一
		4. 如果要输出数组内容，需要进行遍历
	6. 设置请求参数编码 request.setCharacterEncoding("utf-8");
		1. 此方法只适用于post提交乱码
		2. get乱码，只能重新构造字符串
		3. 此方法必须在读取参数之前被调用
	7. 可以使用request获得session：request.getSession()【重要】
	8. 可以使用request获得application：request.getServletContext()
	9. request可以执行请求转发 
		```request.getRequestDispatcher("新的地址").forward(request, response);```
	10. 可以使用request来读取cookie
### 2. response
1. setStatus() 改变服务器状态码（正常） 扩展：错误状态response.sendError(500)
2. setHeader("content-type") 设置相应内容类型（附带编码）：解决响应乱码
3. 缓存控制
```
response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache");
response.setDateHeader("Expires", 0);	
```
4. setHeader("refresh","1");自动刷新 setHeader("refresh","1;URL=''");自动跳转
5. 向客户端响应消息 response.getWriter().print()
6. 重置响应内容编码setContentType()
7. response可以执行请求重定向
	```response.sendRedirect("新的地址");```
8. 可以使用response来写入cookie
### 请求转发和重定向
1. 请求次数：一次请求一次响应							多次请求多次响应
2. 参数有效：request参数一直有效						参数无效
3. URL地址栏：地址栏不变（有可能产生相对地址错误）		地址会变（最后一次请求的地址）
4. 地址范围：只能服务器内部转发（可以转到不能直接访问的地址）	任意地址
总结：隐藏路径或者不可直达路径（转发），除此之外都可以使用重定向