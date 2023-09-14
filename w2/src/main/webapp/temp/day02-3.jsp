<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>out输出实例</title>
</head>
<body>
123
<% out.print("456"); %>
<% response.getWriter().print("789"); %>
</body>
</html>