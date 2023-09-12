<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="day02-2.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会产生错误的页面</title>
</head>
<body>
<%
	int [] x = new int[5];
	x[5]=1;
%>
</body>
</html>