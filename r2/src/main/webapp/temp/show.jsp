<%@page import="java.util.Arrays"%>
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
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	String gender = request.getParameter("gender");
	String[] types = request.getParameterValues("type");
	String code = request.getParameter("code");
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
						<%=password %>
					</td>
				</tr>
				<tr>
					<td>Email</td>
					<td>
						<%=email %>
					</td>
				</tr>
				<tr>
					<td>性别</td>
					<td>
						<%=gender %>
					</td>
				</tr>
				<tr>
					<td>关注类型</td>
					<td>
						<%=Arrays.toString(types) %>
					</td>
				</tr>
				<tr>
					<td>验证码</td>
					<td>
						<%=code %>
					</td>
				</tr>				
			</table>
		
</body>
</html>