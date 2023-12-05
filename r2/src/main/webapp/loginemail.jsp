<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>
<script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
	<script type="text/javascript">
		function send(){
			$.post("sendEmail",{
				"username":$("#username").val(),
				"email":$("#email").val()
			},function(data){
				$("#note").html(data);
			})
		}
	</script>
</head>
<body>
<jsp:include page="/menu.jsp"/>
<h1 class="title">邮箱登录</h1>
		<form action="${pageContext.request.contextPath}/loginemail" method="post">
			<table>
				<tr>
					<td>账号</td>
					<td>
						<input type="text" name="username" id="username"/>
					</td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td>
						<input type="text" name="email" id="email" style="width: 180px;"/>
						<input type="button" onclick="send()" value="发送验证码"/>
						<span id="note" style="position: absolute;"></span>
					</td>
				</tr>
				<tr>
					<td>验证码</td>
					<td>
						<input type="text" name="code"/>
					</td>
				</tr>
				<tr>
					
					<td align="center" colspan="2">
						<input type="submit" id="" value="登录" />
					</td>
				</tr>
			</table>
		</form>
</body>
</html>