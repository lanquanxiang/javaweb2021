<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>out实例</title>
</head>
<body>
<%
	out.print("hello1");
	response.getWriter().print("hello2");

%>
hello

</body>
</html>