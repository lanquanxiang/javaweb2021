<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>当前时间</title>
</head>
<body>
<%
	response.setHeader("refresh", "1");
%>
<%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) %>
</body>
</html>