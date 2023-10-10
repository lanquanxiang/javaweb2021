<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<style type="text/css">
			/*清除所有元素的默认内外边距*/
			*{
				padding: 0;
				margin: 0;
			}
			.header,.footer{
				height: 50px;
				background-color: #cdcdcd;
			}
			.header a{
				color: #0000FF;
				text-decoration: none;
			}
			.header>ul>li{
				display: inline-block;
				line-height: 50px;
				padding: 0px 10px;
			}			
			.header>ul form{
				display: inline-block;
			}
			.menu{
				position: relative;
				color: red;
				text-decoration: none;
			}
			.menu>ul{
				display: none; /*二级菜单不显示*/
			}
			.menu:hover ul{
				display: block;
				position: absolute;
			}
			.menu:hover ul>li{
				display: block;
				line-height: 25px;
				text-decoration: none;
				color: blue;
				width: 100px;
				
			}
			
			.footer{
				position: absolute;
				bottom: 0px;
				width: 100%;
				text-align: center;
			}
			.footer span{
				line-height: 50px;
			}
			
			.title{
				padding-top:50px;
				text-align:center;
			}
			
		</style>
	
		<div class="header">
			<a href="${pageContext.request.contextPath}/index.jsp" style="float: left;">
			<img src="${pageContext.request.contextPath}/img/logo.png" alt="" height="50px"></a>
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
						<input type="image" src="${pageContext.request.contextPath}/img/search.png" height="20px" style="vertical-align: middle;"/>
					</form>
				</li>
			</ul>
			
			<ul style="float: right;">
				<c:if test="${not empty user}">
					<li  class="menu" style="width: 100px;text-align: center;">${user.username }
						<ul>
							<li><a href="${pageContext.request.contextPath}/userinfo.jsp">个人信息</a></li>
							<li><a href="">修改密码</a></li>
							<li><a href="">注销账户</a></li>
						</ul>
					</li>
					<li><a href="${pageContext.request.contextPath}/logout">退出</a></li>
				</c:if>
				
				<c:if test="${empty user}">
					<li><a href="${pageContext.request.contextPath}/login.jsp">登录</a></li>
					<li><a href="${pageContext.request.contextPath}/regist.jsp">注册</a></li>
				</c:if>
			</ul>
		</div>
		<%
			Date today = new Date();
		%>
		<div class="footer">
			<span>攀枝花学院&copy;<b>2021级软件工程1班</b> 2021-<%=new SimpleDateFormat("yyyy").format(today) %></span>
			<span>网站访问量：${empty visitor?0:visitor }</span>
			<span>当前在线人数：${empty online?0:online }</span>
		</div>
