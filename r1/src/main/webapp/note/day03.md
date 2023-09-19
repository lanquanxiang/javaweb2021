# Servlet【重点】
## 1. 什么是Servlet
1. 本质上是一个Java
2. 继承了HttpServlet（对HTTP的请求和响应的处理）
![](day03_files/1.jpg)
## 2. Servlet的特点
1. Java的特点
2. 功能强大（既能使用Java API，还可以使用Servlet API）
3. 性能高效（只创建一次，对象能够被反复使用；多线程（锁），每个请求都是一个线程）
## 3. Servlet的生命周期（简答题）
1. 过程：构造对象Constructor-->初始化init-->服务service（反复执行此阶段）--> 销毁（destroy）
2. 注意：Service方法不需要被复写，会被自动转发给doPost或doGET
3. 