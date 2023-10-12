# 1. MVC
![](day05_files/1.jpg)
# 2. Filter
## 1. 概念
1. 本质上是Java（*.java）
2. 区别：
	1. 实现Filter接口（Tomcat8.0及以前）
	2. 继承HttpFilter类（Tomcat9.0新特性）
## 2. 体系结构（面试）
1. 只处理Http类型的请求和响应，选择继承HttpFilter类，不需要进行类型转换，提高开发效率、减少代码量
2. 希望Filter更灵活、处理范围更广，需要直接实现Filter接口
3. 过滤器已经继承了某个类，只能选择1（Java不允许多继承，防止菱形继承问题出现）
## 3. 作用
1. 能够在请求到达目标资源之前对request进行处理
2. 能够在响应到达客户端之前对response进行处理
3. 能够决定是否继续访问后续资源
## 4. 应用
1. 得到请求头、请求行的信息：黑名单、白名单、防盗链
2. 得到参数的值：敏感词过滤
3. 设置请求响应编码：统一网站的编码【考试】
4. 读取cookie：自动登录
5. 写入头信息：禁止某一类文件缓存、【扩展】制定某些文件可以跨域
6. 写入cookie：给客户端附带信息
7. 决定是否放行
	1. 放行 chain.doFilter(request, response);super.doFilter(req, res, chain);
	2. 阻止（去其他地方） ：重定向（√）、请求转发
## 5. 创建和配置
1. 创建
2. 配置
	1. 注解@WebFilter(urlPatterns = {"path1","path2",""})
	2. Web.xml
		```
		 <filter>
			<filter-name>F3</filter-name>
			<filter-class>cn.pzhu.temp.F3Filter</filter-class>
		  </filter>
		  <filter-mapping>
			<filter-name>F3</filter-name>
			<url-pattern>/*</url-pattern>
		  </filter-mapping>
		```
3. 过滤范围
	1. /* 过滤所有文件：统一网站编码
	2. 某一类文件，eg.所有的jsp文件：*.jsp
	3. 某一个文件夹下的所有文件，eg.所有的笔记 /note/*
	4. 某个指定的文件，eg. 个人信息页面  /userinfo.jsp
	5. 注意：同一个过滤器允许设置多个过滤范围
4. 过滤链的装配规则？【考试：简答题】
	1. 优先组装配置文件中的过滤器，然后组装注解的过滤器
	2. 配置文件中存在多个过滤器，按照配置文件中的顺序，从上到下依次组装
	3. 注解中存在多个过滤器，按照类名先后顺序组装
## 6. 实践
1. 统一全站编码【考试】
2. 权限拦截【考试】
3. 设置响应头(禁止缓存、允许跨域)

# 2. Listener监听器
## 1. 概念
1. 本质上是Java（*.java）
2. 实现了特定的接口
## 2. 作用
1. 监听域对象的创建和销毁
2. 监听域对象中属性的修改（增加add、删除remove、修改replace）
3. 监听Session域中某个特定类的实例是否绑定/解绑
## 3. 特定接口
1. XXXListener 监听XXX域对象的创建（created）和销毁（destroy）【掌握】
2. XXXAttributeListener  监听XXX域中属性的修改【掌握】
3. HttpSessionBindingListener 在值JavaBean中去实现接口
## 4. 实践
1. 监听网站访问量
2. 监听当前登录在线的人数
