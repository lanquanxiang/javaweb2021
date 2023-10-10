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

## 4. 作用
1. 能够对request进行处理
	1. 
2. 决定是否访问后续资源```chain.doFilter(request, response); 重定向```
3. 能够对response进行处理