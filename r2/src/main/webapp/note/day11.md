# 1. 导航栏
1. 视图层（负责显示）
	```
		<div style="text-align: center;margin-top: 50px;">${bar}</div>	
	```
	![](day11_files/1.jpg)
	增加CSS样式
	![](day11_files/5.jpg)
2. 业务层
	负责初始化bar，并且构造导航栏链接
	![](day11_files/2.jpg)
	![](day11_files/3.jpg)
3. 控制器
	负责提供bar，存储到session域对象
	![](day11_files/4.jpg)
	
# 2. 邮件发送
1. 创建loginemail.jsp
![](day11_files/8.jpg)
2. 修改视图层
![](day11_files/9.jpg)
3. 增加ajax异步请求
![](day11_files/10.jpg)
4. 增加发送邮件接口
![](day11_files/7.jpg)
5. 导入jar包
![](day11_files/6.jpg)
6. 创建邮件发送工具类
生成授权码
![](day11_files/18.jpg)
![](day11_files/11.jpg)
7. 实现发送邮件业务层
![](day11_files/12.jpg)
8. 实现用户信息查询持久层
![](day11_files/17.jpg)
9. 创建邮件发送控制器
![](day11_files/13.jpg)
10. 实现发送邮件逻辑
![](day11_files/14.jpg)
11. 创建邮件登录控制器
![](day11_files/15.jpg)
12. 实现邮件登录
![](day11_files/16.jpg)

# 3. 文件下载和上传
## 1. 文件下载
1. 导包file
2. 修改下载页面
![](day11_files/19.jpg)
3. 执行下载
![](day11_files/20.jpg)

## 2. 文件上传
1. 设计页面
![](day11_files/21.jpg)
2. 实现控制器
	1. 增加注解
	![](day11_files/22.jpg)
	2. 实现上传
	![](day11_files/23.jpg)

# 4. JSTL格式化库
![](day11_files/24.jpg)

