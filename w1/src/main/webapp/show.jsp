<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文件列表</title>
<style type="text/css">
.filename{
	width: 300px;
	display: inline-block;
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
</style>
</head>
<body>
<jsp:include page="common.jsp" />
<c:if test="${empty list }">
	<h1 class="title">暂无文件信息!</h1>
</c:if>
<c:if test="${not empty list }">
	<h1 class="title">文件信息</h1>
	<table style="margin: auto;">
	<tr>
	<th>序号</th><th>分享者</th><th>文件名</th><th>文件类别</th>
	<th>下载</th><th>分享时间</th><th>推荐指数</th><th>描述</th><th>操作</th>
	</tr>
	<c:forEach items="${list }" var="file" varStatus="status">
	<tr>
	<td>${status.count }</td>
	<td>${file.username }</td>
	<td class="filename">${file.filename }</td>
	<td>${file.classification }</td>
	<td>下载</td>
	<td>${file.releasedate }</td>
	<td>${file.rating}</td>
	<td>${file.description }</td>
	<td>编辑 删除</td>
	</tr>
	</c:forEach>
	</table>	
</c:if>
<div style="margin: 5% 0% 10% 0%;"></div>
</body>
</html>