<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<jsp:include page="/common.jsp" />
<h1 class="title">用户登录</h1>
<form action="" method="post">
	<table style="margin: auto;">
		<tr>
			<td>账号</td>
			<td>
				<input type="text" name=""/>
			</td>
		</tr>
		<tr>
			<td>密码</td>
			<td>
				<input type="password" name=""/>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" style="text-align: center;">
				<input type="submit" value="登录" style="width: 100px;height: 30px;"/>
			</td>
		</tr>
	</table>
	
</form>
</body>
</html>