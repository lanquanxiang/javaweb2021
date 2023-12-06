# 1. 导航栏
## 1. 视图
1. 修改视图
2. 增加元素，显示导航栏
## 2. 控制器
1. 修改ShowFileMsgServlet，提供bar
2. bar具体生成应该交给模型model
## 3. 业务层
1. 增加业务层接口FileMsgService
2. 实现接口FileMsgServiceImp（数据校验、业务处理）
	1. 数据校验
	2. 业务处理
	3. 完善控制器
## 4. 完善每页显示的条数
![](day11_files/7.jpg)
![](day11_files/9.jpg)
![](day11_files/10.jpg)
![](day11_files/11.jpg)
![](day11_files/12.jpg)
![](day11_files/8.jpg)

# 2. 邮箱登录
## 1. 增加邮箱登录的页面
![](day11_files/1.jpg)
## 2. 增加ajax异步请求
![](day11_files/2.jpg)
## 3. 业务层
1. 完善查询用户信息的持久层
![](day11_files/3.jpg)
2. 增加发送邮件的业务接口
![](day11_files/4.jpg)
3. 实现发送邮件的工具类
![](day11_files/18.jpg)
![](day11_files/17.jpg)
4. 实现业务层接口
![](day11_files/6.jpg)
## 4. 实现控制器
1. 创建控制器并初始化业务层接口
![](day11_files/13.jpg)
2. 执行邮件发送
![](day11_files/14.jpg)
3. 创建邮箱登录的控制器
![](day11_files/15.jpg)
4. 实现登录
![](day11_files/16.jpg)

# 3. 文件上传和下载
## 1. 文件下载
1. 导入jar包
![](day11_files/5.jpg)
2. 修改下载界面show.jsp
![](day11_files/19.jpg)
3. 创建下载控制器
![](day11_files/20.jpg)
4. 实现下载
![](day11_files/21.jpg)

## 2. 文件上传（实例）
1. 上传文件
![](day11_files/22.jpg)
2. 实现控制器
![](day11_files/24.jpg)
![](day11_files/23.jpg)
3. 需要将路径存储到数据库中，用于之后的下载


