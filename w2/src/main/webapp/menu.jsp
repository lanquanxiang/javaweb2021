<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
		text-align: center;
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
	.footer>span{
		
		line-height: 50px;
	}
	.title{
		text-align: center;
		padding-top: 50px;
	}
</style>

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
		<li class="menu">文件分享
			<ul>
				<li><a href="">分享文件</a></li>
				<li><a href="">我的分享</a></li>
			</ul>
		</li>
		<li>文件检索
			<form action="" method="get" style="display: inline-block;">
				<input type="text" style="height: 25px;"/>
				<input type="image" src="img/search.png" style="height: 25px;vertical-align: middle;"/>
			</form>
		</li>
	</ul>
	<ul style="float: right;">
		<li class="menu">个人中心
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
<%
	Date today = new Date();
%>
<div class="footer">
	<span>攀枝花学院&copy;<b>2021级网络工程2班</b> 2021-<%=new SimpleDateFormat("yyyy").format(today) %></span>
	<span>网站访问量：5</span>
	<span>当前在线人数：1</span>	
</div>