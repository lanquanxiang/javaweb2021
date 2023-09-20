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
<jsp:include page="common.jsp" />
<h1 class="title">用户注册</h1>
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
			<td>Email</td>
			<td>
				<input type="text" name=""/>
			</td>
		</tr>
		<tr>
			<td>性别</td>
			<td>
				<input type="radio" name="gender" value="男" checked="checked"/>男
				<input type="radio" name="gender" value="女"/>女
			</td>
		</tr>
		<tr>
			<td>关注类型</td>
			<td>
				<input type="checkbox" name="type" value="法律法规" check=checked>法律法规
				<input type="checkbox" name="type" value="管理办法">管理办法
				<input type="checkbox" name="type" value="决定条列">决定条列
				<input type="checkbox" name="type" value="细则解释">细则解释
				<input type="checkbox" name="type" value="规范指南">规范指南
			</td>
		</tr>
		<tr>
			<td>验证码</td>
			<td>
				<input type="text" name="code">
				<input type="image" src="img/captcha.jpg"  height="25px"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<input type="submit" value="注册"/>
			</td>
		</tr>
	</table>
	
</form>
</body>
</html>