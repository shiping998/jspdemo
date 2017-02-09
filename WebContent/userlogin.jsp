<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>登陆</title>
</head>
<body>
	<%
		String message = (String) (request.getAttribute("message"));
	%>
	<form id="form1" action="UserloginServlet" method="post">
		<table align="center" border="1" style="border-collapse: collapse;">
			<tr align="center">
				<td colspan="2">用户登录</td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="userName" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="userPassword" />
				 <%if (message != null) { %>
				 <span style="color: red; font-size: 13px;"id="td2"><%=message%></span> 
				 <%	} %>
				 </td>
			</tr>
			<tr align="center">
				<td colspan="2"><a href="userregister.jsp">注册</a> 
				<input type="submit" name="login" value="登录" /></td>
			</tr>
		</table>
	</form>
</body>
</html>