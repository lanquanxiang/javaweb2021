<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
</head>
<body>
<jsp:include page="/menu.jsp"/>
<h1 class="title">用户登录</h1>
		<form action="${pageContext.request.contextPath}/login" method="post">
			<table>
				<tr>
					<td>账号</td>
					<td>
						<input type="text" name="username" value="${cookie.username.value}"/>
					</td>
				</tr>
				<tr>
					<td>密码</td>
					<td>
						<input type="password" name="password"  value="${cookie.password.value}"/>
					</td>
				</tr>
				<tr>
					<td></td>
					<td style="position: relative;">
						<input type="checkbox" name="save" value="yes" ${empty cookie.save.value?"":"checked" }>密码保存7天
						<a href="loginemail.jsp" style="position: absolute;right: 0;">邮箱登录</a>
					</td>
				</tr>
				<tr>
					
					<td align="center" colspan="2">
						<input type="submit" id="" value="登录" />
					</td>
				</tr>
			</table>
		</form>
</body>
</html>