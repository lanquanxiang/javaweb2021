# 环境安装
## 1 . 运行出错（考试）
![](day01_files/1.jpg)
原因：Tomcat9.0所需要的端口8080被其他程序占用
解决：1. 在tomcat配置文件中重新更换端口；2. 结束占用8080端口的进程，重新运行
## 2. Eclipse2023创建的动态web项目的目录结构（了解）
![](day01_files/2.jpg)
1. src：放置源码
2. webapp：放置前端代码
3. java（Java Resources）：放置Java代码
4. webapp/WEB-INF：项目的配置信息（此文件不允许用户直接访问）
5. webapp/WEB-INF/lib：放置项目的jar包
6. webapp/WEB-INF/web.xml：项目配置文件（首页<welcome-file-list>、全局错误页面、servlet配置、过滤器配置）
## 3. 端口
1. tomcat 8080
2. MySQL 3306默认 （mysql8--3308） root 123456
# Java Web基础知识（了解）
## 1. Java技术
1. JavaSE ： Java标准开发（面向对象程序设计）
2. JavaEE ： Java企业级开发
3. JavaME ： Java移动开发
## 2. Java名词
1. SDK：软件开发工具包
2. JDK：Java开发工具包
3. JRE：Java运行时环境
4. JVM：Java虚拟机
5. JDK>JRE>JVM
## 3. B/S和C/S
浏览器和服务器
客户端和服务器
优缺点（安全性、性能、成本）
## 4. HTTP版本1.0/1.1的特点以及他们的优缺点（考试：问答）
1. HTTP1.0 一次连接一次请求
2. HTTP1.1 一次连接多次请求
3. HTTP1.1 效率更高
## 5. HTTP消息结构（重点）
### 1. 请求消息
1. MIME（多用途邮件互联网扩展类型 text/image/video/audio/application/message/multipart多部分媒体）【重点】
2. accept允许接受的类型
3. host 请求的主机名或IP地址（端口号）
4. referer 请求来源（网站防盗链）
5. cookie 保存cookie（key=value;key=value;）cookie不能保存中文（编码解码）
### 2. 响应消息
1. cache-control:缓存时间（no-cache）【重点】 max-age=缓存时间 0立即过期
2. location：服务器通知客户端去往新的地址（重定向）
3. status code：服务器状态码
4. content-Type：服务器通知客户端响应的内容类型"text/html; charset=UTF-8"
5. refresh：服务器通知客户端定时刷新，或者自动跳转

# 前端开发基础
## 1. HTML
### 1. 表单（考试）
### 2. 
