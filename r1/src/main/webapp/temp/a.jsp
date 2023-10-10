<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  errorPage="b.jsp"   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>存在错误的页面</title>
</head>
<body>
<%
	Integer i = null;
	i.byteValue();//空指针异常
%>
</body>
</html>