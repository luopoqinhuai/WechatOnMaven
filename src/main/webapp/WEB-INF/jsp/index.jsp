<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>首页-登录</title>
<style type="text/css">
<!--
body {
	background: #3c7fb5 url(images/bg_login.jpg) repeat-x left top;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

body, table, td, div {
	font-size: 12px;
	line-height: 24px;
}

.textfile {
	background: url(images/bg_login_textfile.gif) no-repeat left top;
	padding: 0px 2px;
	height: 29px;
	width: 143px;
	border: 0;
}
-->
</style>


<script>
	function Login() {
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

		username = document.getElementById("username").value;
		if (!filter.test(username)) {
			alert("您的邮箱格式不对");
		}

		passwd = document.getElementById("passwd").value;

		rm = document.getElementById("rememberpasswd").checked;

		alert(rm);

		if (username.length < 3) {
			alert("用户名过短");
		}
	}

function usernameCheck(){
	username = document.getElementById("username").value;
	alert(username.length);
}
	
</script>

</head>

<body>
	<table width="95" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td><img src="images/top_login.jpg" width="596" height="331" /></td>
		</tr>
		<tr>
			<td><table width="100%" border="0" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="99"><img src="images/login_06.jpg" width="99"
							height="139" /></td>
						<td background="images/bg_form.jpg"><table width="250"
								border="0" align="center" cellpadding="0" cellspacing="0">
								
								<form id="form1" name="form1" method="get" action="/WechatOnMaven/checklogin">
									<tr>
										<td height="35" align="right">用户名：</td>

										<td><label> <input id="username" name="username"  onkeydown="usernameCheck()"
												type="text" class="textfile" />
										</label></td>
									</tr>
									<tr>
										<td height="35" align="right">密&nbsp;&nbsp;码：</td>
										<td><label> <input id="passwd" name="passwd"
												type="password" class="textfile" />
										</label></td>
									</tr>
									<tr>
										<td height="35">&nbsp;</td>
										<td><label> <input type="submit" name="Submit"
												value="登录" onclick="Login()" /> <input type="reset"
												name="Submit2" value="重置" />
										</label></td>
									</tr>
									<tr>
										<td height="30">&nbsp;</td>
										<td><label> <input id="rememberpasswd"
												type="checkbox" name="checkbox" value="checkbox" />
										</label> 记住密码</td>
									</tr>
								</form>
							</table></td>
						<td width="98" align="right"><img src="images/login_08.jpg"
							width="98" height="139" /></td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td><img src="images/bottom_login.jpg" width="596" height="39" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="center">版权所有：Reno个人所有</td>
		</tr>
	</table>
</body>
</html>
