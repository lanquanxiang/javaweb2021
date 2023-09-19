<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册结果</title>
<style type="text/css">
	input[type='text'],input[type='password']{
		width:300px;
	}
	input[type='submit']{
		width:100px;
		height:30px;
	}
</style>
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



<jsp:include page="/menu.jsp"></jsp:include>
<h1 class="title">注册信息如下</h1>
	<table style="margin: auto;">
		<tr>
			<td>账号</td>
			<td><input type="text" name="username" value="<%=username %>"/></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" name="password"  value="<%=password %>"/></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email" value="<%=email %>"/></td>
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
		<tr>			
			<td colspan="2" style="text-align: center;">
				<input type="submit" value="确定" />
			</td>
		</tr>
	</table>

</body>
</html>