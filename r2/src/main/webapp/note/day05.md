# 1. Filter过滤器
## 1. 概念
1. Filter本质上是Java类（*.java）
2. 实现了Filter接口（方法1）
3. 注意：Tomcat9.0中可以直接继承HttpFilter类（方法2）
4. 面试：Filter体系结构
5. 总结：如果确定只处理Http的请求和响应，并且能够支持Tomcat9.0，选方法2（不需要进行类型转换）
		方法1，更灵活，能够处理的请求和响应更广泛，不限于HTTP，在处理HTTP的时候需要进行类型转换
		如果过滤器需要继承其他类，只能选1
## 2. 作用
1. 能够在请求到达目标资源之前对request进行处理
	1. 请求头：获取IP、referer---【黑名单、白名单、防盗链】
	2. 请求参数：权限检查
	3. 请求编码：统一网站编码【考试】
	4. 读取cookie：自动登录
2. 决定目标资源是否允许被访问【考试：未登录（查找session中的登录标记）-->不能访问个人信息】
	1. 放行```super.doFilter(request, response, chain);chain.doFilter(request, response);```
	2. 返回到其他资源（请求转发、重定向√）
3. 在响应到达客户端之前对响应进行处理
	1. 控制页面缓存--禁止所有*.jsp文件缓存
	2. 写入cookie--写入其他信息
	3. 【开发】允许跨域请求
## 3. 创建和配置
1. 配置方法
	1. 注解方式@WebFilter("/过滤的路径范围")
	2. 通过web.xml配置
	```
	  <filter>
	  	<filter-name>Filter2</filter-name>
	  	<filter-class>cn.pzhu.temp.Filter2Filter</filter-class>
	  </filter>
	  <filter-mapping>
	  		<filter-name>Filter2</filter-name>
	  		<url-pattern>/*</url-pattern>
	  </filter-mapping>
	```
2. 过滤范围
	1. /* 所有文件
	2. 某一类文件 *.jsp  eg.所有的jsp文件
	3. 某个特定文件  /temp/show.jsp  以/开头，表示相对web根路径
	4. 某个文件夹下的所有文件  /文件夹名字/*
3. 过滤链的装配规则【简答题】
	1. 优先组装配置文件，然后组装注解的过滤器
	2. 多个配置文件配置过滤器，从上到下依次组装
	3. 多个注解的过滤器，按照类名进行组装
## 4. 实践
1. 统一全站编码
2. 禁止所有jsp文件被缓存
	