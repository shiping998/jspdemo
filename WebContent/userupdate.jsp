<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*" import="com.user.vo.UserVo"%>
<%UserVo user=(UserVo)request.getAttribute("user"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户修改</title>
</head>

<body onload="setValue()">
	<form name="updateform" action="ServletToUserUpdate" method="post">
	 <table border = "1" align = "center" style="border-collapse:collapse;">
        <tr>　　　　　　　　　　　　
            <td colspan="2">用户修改<input type="hidden" name="userId" value='<%=user.getUserId() %>'/></td>           
        </tr>
        <tr>
            <td>用户名</td>
            <td class="tdstyle2"><input type="text" name="userName" value='<%=user.getUserName() %>'/></td>    
        </tr>
        <tr>
            <td>密 码</td>
            <td><input type="text" name="userPassword" value='<%=user.getUserPassword() %>'/></td>            
        </tr>
          <tr>
            <td>性 别</td>
            <td>
                <input type="radio" id = "man" name="userSex" value="male" checked="checked" />male
                <input type="radio" id = "woman"name="userSex" value="female" />female
            </td>        
        </tr>
         <tr>
            <td colspan="2"><input type = "submit" value = "修改" /></td>          
        </tr>
    </table>
	<script>
		function setValue(){
		  		if('<%= user.getUserSex() %>'=="male"){
		      		document.getElementById("man").checked="checked";
		  		}else{
		      		document.getElementById("woman").checked="checked";
		  		}
		 
		}
	</script>	
	</form>
</body>
</html>