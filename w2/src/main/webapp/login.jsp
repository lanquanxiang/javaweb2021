<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="custom"  uri="/customFunction"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<style type="text/css">
	input[type="text"],input[type="password"]{
		width: 300px;
	}
</style>
</head>
<body>
<jsp:include page="/menu.jsp"></jsp:include>
<h1 class="title">用户登录</h1>
<form action="${pageContext.request.contextPath}/login" method="post">
	<table style="margin: auto;">
		<tr>
			<td>账号</td>
			<td>
				<input type="text" name="username" value="${custom:decoder(cookie.username.value,'utf-8')}"/>
			</td>
		</tr>
		<tr>
			<td>密码</td>
			<td>
				<input type="password" name="password" value="${cookie.password.value }"/>
			</td>
		</tr>
		
		<tr>
			<td></td>
			<td style="position: relative;">
				<input type="checkbox" name="save" value="1" ${empty cookie.save.value ? "":"checked" }/>保存账号和密码
				<a href="loginemail.jsp" style="text-decoration: none;right: 0px;position: absolute;">邮件登录</a>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" style="text-align: center;">
				<input type="submit"  value="登录" style="width: 100px;height: 30px;"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>