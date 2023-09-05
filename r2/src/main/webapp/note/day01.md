# 环境配置
## 1. eclipse2023动态web项目的目录结构
![](day01_files/1.jpg)
1. src：放置源码
2. src/main/java:放置Java源代码
3. src/main/webapp：放置视图层（html、js、css、jsp）代码
4. src/main/webapp/WEB-INF：放置项目的配置信息（此文件夹用户不能直接访问）
5. src/main/webapp/WEB-INF/lib：放jar包（JDBC）
6. src/main/webapp/WEB-INF/web.xml ：项目的配置文件（欢迎页面、过滤器、server映射、框架、全局信息）
## 2. JDK eclipse tomcat mysql+sqlyog 
1. tomcat 默认端口8080
2. mysql 默认端口3306（机房mysql8.0版本 端口3308 root 123456）
3. 在将项目部署到tomcat时发生以下异常，是因为什么造成的？如何解决？
![](day01_files/2.jpg)
问题：tomcat9.0服务器所需要的端口8080已经被使用了
解决：
	办法1：找到这个占用端口的进程，结束该进程之后重新运行。
	办法2：在tomcat的配置文件中更换其他端口。