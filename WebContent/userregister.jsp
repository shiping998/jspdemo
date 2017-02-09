<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>注册</title>
	</head>
	<body>
	<%
		String message = (String) (request.getAttribute("message"));
	%>
	<form action="ServletUserRegister" method="post">
		<table align="center" border="1" style="border-collapse: collapse;">
			<tr>
				<td colspan="2">用户注册</td>
			</tr>
			<tr>
				<td>用户名</td>
				<td>
				<input type="text" name="userName" />
				<%if (message != null) {%>
				<span style="color: red; font-size: 13px;" id="td2"><%=message%></span>
				<%}	%>
				</td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="userPassword" /></td>
			</tr>
			<tr>
				<td>性别</td>
				<td>
					<input type="radio" name="userSex" value="male"	checked="checked" />male 
					<input type="radio" name="userSex"	value="female" />female
				</td>
			</tr>
			<tr>
				<td class="tdstyle" colspan="2"><input type="submit" value="注册" />	</td>
			</tr>
		</table>
	</form>
	</body>
</html>