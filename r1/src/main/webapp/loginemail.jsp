<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>邮箱登录</title>
<script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
<style type="text/css">
	form input[type='text'],form input[type='password']{
		width:300px;
	}
	form input[type='submit']{
		width:100px;
		height:30px;
	}
</style>
<script type="text/javascript">
	function sendEmail(){
		$.post('sendemail',
		{"username":$("#username").val(),"email":$("#email").val()},
			function(data){
				$("#note").html(data);
		})
	}
</script>
</head>
<body>
<jsp:include page="/menu.jsp"></jsp:include>

<h1 class="title">邮箱登录</h1>
<form action="${pageContext.request.contextPath}/loginemail" method="post">
	<table style="margin: auto;">
		<tr>
			<td>账号</td>
			<td><input type="text" name="username" id="username"/></td>
		</tr>
		<tr>
			<td>邮箱</td>
			<td><input type="text" name="email" id="email" style="width: 230px;" />
				<input type="button" value="发送验证码" onclick="sendEmail()">
				<span id="note" style="position: absolute;"></span>
			</td>
		</tr>
		<tr>
			<td>验证码</td>
			<td><input type="text" name="code" /></td>
		</tr>		
		<tr>			
			<td colspan="2" style="text-align: center;">
				<input type="submit" value="登录" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>