<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>首页</title>
		<style type="text/css">
			/*清除所有元素的默认内外边距*/
			*{
				padding: 0;
				margin: 0;
			}
			.header{
				height: 50px;
				background-color: #cdcdcd;
			}
			ul>li{
				display: inline-block;
				line-height: 50px;
				text-decoration: none;
				color: blue;
				padding-left: 30px;
			}
			ul ul>li{
				display: none; /*二级菜单不显示*/
			}
			ul form{
				display: inline-block;
			}
			.menu ul{
				position: relative;
			}
			.menu:hover ul{
				display: block;
				position: absolute;
			}
			.menu:hover ul>li{
				display: block;
				
			}
		</style>
	</head>
	<body>
		<div class="header">
			<a href="#" style="float: left;"><img src="img/logo.webp" alt="" height="50px"></a>
			<ul style="float: left;">
				<li><a href="#">文件列表</a></li>
				<li  class="menu">分类查看
					<ul>
						<li><a href="">法律法规</a></li>
						<li><a href="">管理办法</a></li>
						<li><a href="">决定条例</a></li>
						<li><a href="">细则解释</a></li>
						<li><a href="">规范指南</a></li>
						<li><a href="">其他文件</a></li>
					</ul>
				</li>
				<li  class="menu">文件分享
					<ul>
						<li><a href="">分享文件</a></li>
						<li><a href="">我的分享</a></li>
					</ul>
				</li>
				<li>
					文件检索
					<form action="#" method="post">
						<input type="text" name="" />
						<input type="image" src="img/search.webp" height="20px" style="vertical-align: middle;"/>
					</form>
				</li>
			</ul>
			
			<ul style="float: right;">
				<li  class="menu">个人中心
					<ul>
						<li><a href="">个人信息</a></li>
						<li><a href="">修改密码</a></li>
						<li><a href="">注销账户</a></li>
					</ul>
				</li>
				<li><a href="">退出</a></li>
				<li><a href="">登录</a></li>
				<li><a href="">注册</a></li>
			</ul>
			
			
		</div>
		<div class="footer">

		</div>
	</body>
</html>
