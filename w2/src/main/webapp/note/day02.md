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
## 2. include
## 3. taglib