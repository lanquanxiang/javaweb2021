<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册结果</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String username = request.getParameter("username");


%>



<jsp:include page="/menu.jsp"></jsp:include>
<h1 class="title">注册信息如下</h1>
	<table style="margin: auto;">
		<tr>
			<td>账号</td>
			<td><input type="text" name="username" value="<%=username %>"/></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email"/></td>
		</tr>
		<tr>
			<td>性别</td>
			<td>
				<input type="radio" name="gender" checked="checked"/>男
				<input type="radio" name="gender"/>女
			</td>
		</tr>
		<tr>
			<td>关注类型</td>
			<td>
				<input type="checkbox" name="type" checked="checked"/>法律法规
				<input type="checkbox" name="type"/>管理办法
				<input type="checkbox" name="type"/>决定条例
				<input type="checkbox" name="type"/>细则解释
				<input type="checkbox" name="type"/>规范指南				
			</td>
		</tr>
		<tr>
			<td>验证码</td>
			<td><input type="text" name="code"/>
				<img src="img/captcha.jpg" style="height: 25px;">
			</td>
		</tr>
		<tr>			
			<td colspan="2">
				<input type="submit" value="注册" />
			</td>
		</tr>
	</table>

</body>
</html>