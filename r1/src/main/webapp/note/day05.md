# 1. Filter
## 1. 概念
1. Filter本质上是Java类
2. 实现了Filter接口（对request和response的处理）
3. [Tomcat9.0]增加了HttpFilter类（extends）
## 2. 如何使用
1. 过滤器需要继承其他类，只能选择实现Filter接口
2. 选择实现Filter接口，需要对request和response进行类型转换
3. 实现Filter接口能处理的范围更广，更灵活，HttpFilter类只处理HTTP
## 3.创建和配置
### 1. 创建
1. 实现Filter接口
2. 继承HttpFilter类【Tomcat9.0及以后】
### 2. 配置
1. 注解 @WebFilter("/过滤范围")
2. 配置web.xml中进行配置
```
  <filter>
  	<filter-name>过滤器的名字-唯一</filter-name>
  	<filter-class>过滤器的全类名</filter-class>
  </filter>
  <filter-mapping>
  	<filter-name>过滤器的名字-唯一</filter-name>
  	<url-pattern>过滤范围</url-pattern>
  </filter-mapping>
 ```
 3. 过滤范围
	/* 所有文件【统一编码】
	*.jsp 某一类文件
	/login.jsp 指定路径的具体某个文件
	/文件夹/* 某个文件夹下的所有文件
4. 过滤链的装配（组装）规则【简答题】
	1. 配置文件 优先组装，安装配置顺序组装
	2. 注解  按照类名组装
## 4. 作用
1. 能够对request进行处理
	1. 读取客户端信息（IP地址、请求方式、请求参数--识别客户端【黑白名单】）
	2. 设置request、response的编码【重要：考试】统一字符编码
	3. 读取cookie：【自动登录】
2. 决定是否访问后续资源```chain.doFilter(request, response); 重定向```
	1. 拦截非法访问【未登录session是否存在登录标记、没有权限】考试
3. 能够对response进行处理
	1. 禁止缓存【jsp动态文件】
	2. 设置响应头【设置允许静态资源跨域请求】
	