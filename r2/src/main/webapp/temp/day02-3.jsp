<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>输出示例</title>
</head>
<body>
你好1!
<%
	out.print("你好2!");
	response.getWriter().print("你好3!");
%>
</body>
</html>