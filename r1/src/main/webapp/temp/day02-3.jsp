<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>自动跳转</title>
</head>
<body>
<% response.setHeader("refresh", "5;URL='https://www.pzhu.cn'"); %>
<h1>5秒之后自动跳转到攀枝花学院</h1>
</body>
</html>