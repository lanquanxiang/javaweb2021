<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{
		padding: 0;
		margin: 0;
		font-family: "microsoft yahei";
	}
	.header,.footer{
		height: 50px;
		background-color: #cdcdcd;
	}
	.footer{
		position: absolute;
		bottom: 0px;
		width: 100%;
	}
	.header a{
		color: blue;
		text-decoration: none;
	}
	.header>ul>li{
		display: inline-block;
		margin: 0px 10px;
		line-height: 50px;
		
	}
	.menu{
		color: red;
		position: relative;
	}
	.menu>ul{
		display: none;
	}
	.menu:hover>ul{
		display: block;
		position: absolute;
	}
	.menu>ul>li{
		line-height: 30px;
		list-style-type: none;
	}
</style>
</head>
<body>
<div class="header">
	<a href="" style="float: left;"><img src="img/logo.png" alt="" style="height: 50px;"></a>
	<ul style="float: left;">
		<li><a href="">文件列表</a></li>
		<li class="menu">分类查看
			<ul>
				<li><a href="">法律法规</a></li>
				<li><a href="">管理办法</a></li>
				<li><a href="">决定条例</a></li>
				<li><a href="">细则解释</a></li>
				<li><a href="">规范指南</a></li>
				<li><a href="">其他文件</a></li>
			</ul>
		
		</li>
		<li>文件分享</li>
		<li>文件检索
			<form action="" method="get" style="display: inline-block;">
				<input type="text" style="height: 25px;"/>
				<input type="image" src="img/search.png" style="height: 25px;vertical-align: middle;"/>
			</form>
		</li>
	</ul>
	
</div>

<div class="footer"></div>
</body>
</html>