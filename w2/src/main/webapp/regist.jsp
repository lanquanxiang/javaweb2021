<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
<style type="text/css">
	input[type="text"],input[type="password"]{
		width: 300px;
	}
</style>
</head>
<body>
<jsp:include page="/menu.jsp"></jsp:include>
<h1 class="title">用户注册</h1>
<form action="temp/show.jsp" method="post">
	<table style="margin: auto;">
		<tr>
			<td>账号</td>
			<td>
				<input type="text" name="username"/>
			</td>
		</tr>
		<tr>
			<td>密码</td>
			<td>
				<input type="password" name="password"/>
			</td>
		</tr>
		<tr>
			<td>Email</td>
			<td>
				<input type="text" name="email"/>
			</td>
		</tr>
		<tr>
			<td>性别</td>
			<td>
				<input type="radio" name="gender" value="1" checked="checked"/>男
				<input type="radio" name="gender" value="0"/>女
			</td>
		</tr>
		<tr>
			<td>关注类型</td>
			<td>
				<input type="checkbox" name="type" value="法律法规" checked="checked"/>法律法规
				<input type="checkbox" name="type" value="管理办法"/>管理办法
				<input type="checkbox" name="type" value="决定条例"/>决定条例
				<input type="checkbox" name="type" value="细则解释"/>细则解释
				<input type="checkbox" name="type" value="规范指南"/>规范指南
			</td>
		</tr>
		<tr>
			<td>验证码</td>
			<td>
				<input type="text" name="code"/>
				<img src="img/captcha.jpg" height="25px" >
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<input type="submit"  value="注册" style="width: 100px;height: 30px;"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>