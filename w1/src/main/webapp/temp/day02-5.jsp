<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>自动跳转</title>
</head>
<body>
<%
	response.setHeader("refresh", "3;URL='https://www.pzhu.cn'");
%>
</body>
</html>