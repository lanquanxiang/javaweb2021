<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	String username = request.getParameter("username");

%>
<jsp:include page="menu.jsp"/>
<h1 class="title">用户信息</h1>
		
			<table>
				<tr>
					<td>账号</td>
					<td>
						<%=username %>
					</td>
				</tr>
				<tr>
					<td>密码</td>
					<td>
						
					</td>
				</tr>
				<tr>
					<td>Email</td>
					<td>
						
					</td>
				</tr>
				<tr>
					<td>性别</td>
					<td>
						
					</td>
				</tr>
				<tr>
					<td>关注类型</td>
					<td>
						
					</td>
				</tr>
				<tr>
					<td>验证码</td>
					<td>
						
					</td>
				</tr>				
			</table>
		
</body>
</html>