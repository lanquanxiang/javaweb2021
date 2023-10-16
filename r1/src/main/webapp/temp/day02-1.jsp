<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
你好0
<%
	out.print("你好1");
	response.getWriter().print("你好2");
	
%>
</body>
</html>