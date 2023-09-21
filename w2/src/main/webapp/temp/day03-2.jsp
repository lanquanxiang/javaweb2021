<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>自动跳转</title>
</head>
<body>
<h1><span>3</span>秒之后跳转到攀枝花学院</h1>
<% response.setHeader("refresh", "3;URL='https://www.pzhu.cn'"); %>
</body>
</html>