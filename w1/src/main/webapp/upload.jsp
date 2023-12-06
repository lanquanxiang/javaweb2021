<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文件上传实例</title>
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
选择你要上传的文件：<input type="file" name="file" >
<input type="submit" value="上传">
</form>
</body>
</html>