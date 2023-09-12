<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="css/my.css" />

<%-- 头部 --%>
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
			<form action="" method="post" style="display: inline-block;">
				<input type="text" style="line-height: 25px;width:150px;" />
				<input type="image" src="img/search.png" style="height: 20px;vertical-align: middle;" />
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
		<li><a href="login.jsp">登录</a></li>
		<li><a href="regist.jsp">注册</a></li>
	</ul>
</div>

<%-- 尾部 --%>
<%
	Date today = new Date();
%>

<div class="footer">
	<span>攀枝花学院&copy;<b>2021级软件工程2班</b> 2021-<%=new SimpleDateFormat("yyyy").format(today) %></span>
	<span>网站访问量：5</span>
	<span>当前登录人数：1</span>
</div>
