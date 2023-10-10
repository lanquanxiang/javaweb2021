<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息</title>
<style type="text/css">
	form input[type='text'],form input[type='password']{
		width:300px;
	}
	form input[type='submit'],input[type='button']{
		width:100px;
		height:30px;
	}
	a{
		text-decoration: none;
	}
</style>
</head>
<body>
<jsp:include page="/menu.jsp"></jsp:include>

<h1 class="title">个人信息</h1>
<form action="update" method="post">
	<table style="margin: auto;">
		<tr>
			<td>账号</td>
			<td><input type="text" name="username" value="${user.username }"/></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="text" name="password" value="${user.password }"/></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email"/></td>
		</tr>
		<tr>
			<td>性别</td>
			<td>
				<input type="radio" name="gender" value="1"/>男
				<input type="radio" name="gender" value="0"/>女
			</td>
		</tr>
		<tr>
			<td>关注类型</td>
			<td>
				<input type="checkbox" name="type" value="法律法规"/>法律法规
				<input type="checkbox" name="type" value="管理办法"/>管理办法
				<input type="checkbox" name="type" value="决定条例"/>决定条例
				<input type="checkbox" name="type" value="细则解释"/>细则解释
				<input type="checkbox" name="type" value="规范指南"/>规范指南				
			</td>
		</tr>		
		<tr>			
			<td colspan="2" style="text-align: center;">
				<input type="submit" value="修改" />
				<a href="${pageContext.request.contextPath}/index.jsp">取消</a>
			</td>
		</tr>
	</table>
</form>
</body>
</html>