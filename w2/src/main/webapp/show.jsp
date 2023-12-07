<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文件列表</title>
<style type="text/css">
.filename{
	display: inline-block;
	width: 300px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
td{
	text-align: center;
}
tr:nth-child(2n){
	background-color: #cdcdcd;
}
div>a{
	margin: 0px 5px 0px 5px;
	text-decoration: none;
}
</style>
</head>
<body>
<jsp:include page="/menu.jsp"></jsp:include>
<c:if test="${empty list}">
	<h1 class="title">暂无文件信息！</h1>
</c:if>

<c:if test="${not empty list}">
	<h1 class="title">文件信息</h1>
	<table style="margin: auto">
	<tr>
	<th>序号</th>
	<th>用户名</th>
	<th>文件名</th>
	<th>文件类型</th>
	<th>下载地址</th>
	<th>分享日期</th>
	<th>评分</th>
	<th>备注</th>
	<th>操作</th>	
	</tr>
	<c:forEach items="${list }" var="temp" varStatus="status">
	<tr>
	<td>${status.count}</td>
	<td>${temp.username}</td>
	<td class="filename">${temp.filename}</td>
	<td>${temp.classification}</td>
	<td>
		<form action="download" method="post">
			<input type="hidden" name = "filename" value="${temp.filename}"/>
			<input type="hidden" name = "filepath" value="${temp.filepath}"/>
			<input type="submit" value="下载"> 
		</form>
	</td>
	<td>${temp.releasedate}</td>
	<td>${temp.rating}</td>
	<td>${temp.description}</td>
	<td>删除 修改</td>
	</tr>
	</c:forEach>
	</table>
	<div style="text-align: center;margin-top: 30px;">${bar}
		<form action="show">
			每页显示<input type="number" name="num" value="${empty num?10:num}">条
			<input type="submit" value="确定">
		</form>
	</div>	
</c:if>
<div style="margin-top: 5%;margin-bottom: 10%;"></div>
</body>
</html>