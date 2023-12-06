<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>邮箱登录</title>
<style type="text/css">
	input[type="text"],input[type="password"]{
		width: 300px;
	}
</style>
<script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
<script type="text/javascript">
	function send(){
		$.post('sendemail',
				{'username':$('#username').val(),'email':$('#email').val()},
				function(data){
					$('#msg').html(data);
		})
	}
</script>
</head>
<body>
<jsp:include page="/common.jsp" />
<h1 class="title">邮箱登录</h1>  
<form action="${pageContext.request.contextPath}/loginemail" method="post">
	<table style="margin: auto;">
		<tr>
			<td>账号</td>
			<td>
				<input type="text" name="username" id="username"/>
			</td>
		</tr>
		<tr>
			<td>邮箱</td>
			<td>
				<input type="text" name="email" id="email" style="width: 225px;"/>
				<input type="button" value="发送验证码" onclick="send()"> 
				<span id="msg" style="position: absolute;"></span>
			</td>
		</tr>
		<tr>
			<td>验证码</td>
			<td>
				<input type="text" name="code"/>
			</td>
		</tr>
		
		
		<tr>
			<td colspan="2" style="text-align: center;">
				<input type="submit" value="登录" style="width: 100px;height: 30px;"/>
			</td>
		</tr>
	</table>
	
</form>
</body>
</html>