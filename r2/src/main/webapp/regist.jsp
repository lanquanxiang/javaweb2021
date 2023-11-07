<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
	<script type="text/javascript">
		function check(){
			$.post("checkusername",{
				"username":$("#username").val()
			},function(data){
				$("#note").html(data);
			})
		}
		
		function reload(){
			$("#captcha").attr("src","captcha?time="+new Date().getTime());
		}
	</script>
<meta charset="UTF-8">
<title>注册</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<h1 class="title">用户注册</h1>
		<form action="regist" method="post">
			<table>
				<tr>
					<td>账号</td>
					<td>
						<input type="text" name="username" id="username" onchange="check()"/><span id="note"></span>
					</td>
				</tr>
				<tr>
					<td>密码</td>
					<td>
						<input type="password" name="password" />
					</td>
				</tr>
				<tr>
					<td>Email</td>
					<td>
						<input type="text" name="email" />
					</td>
				</tr>
				<tr>
					<td>性别</td>
					<td>
						<input type="radio" name="gender"  checked="checked" value="1"/>男
						<input type="radio" name="gender" value="0"/>女
					</td>
				</tr>
				<tr>
					<td>关注类型</td>
					<td>
						<input type="checkbox" name="type"  checked="checked" value="法律法规"/>法律法规
						<input type="checkbox" name="type" value="管理办法"/>管理办法
						<input type="checkbox" name="type" value="决定条例"/>决定条例
						<input type="checkbox" name="type" value="细则解释"/>细则解释
						<input type="checkbox" name="type" value="规范指南"/>规范指南
					</td>
				</tr>
				<tr>
					<td>验证码</td>
					<td>
						<input type="text" name="code"/>
						<img src="captcha" id="captcha" height="25px" onclick="reload()" title="点击刷新" style="cursor: pointer;">
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<input type="submit" id="" value="注册" />
					</td>
				</tr>
			</table>
		</form>
</body>
</html>