<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" import="com.user.vo.UserVo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%ArrayList<UserVo> list = (ArrayList<UserVo>)(request.getAttribute("list")); %>
<html>
  <head>
    <style type = "text/css">
        td{    
            width:60px;
        }
    </style>
    <title>显示</title>
  </head>
  
  <body>
    <div id = "main">
    <form name="userlistform" action ="" method = "post">
        <table border ="1" align = "center" style="border-collapse:collapse;">
            <tr align="center">
                <td colspan="7">
                   	 用户信息列表
                </td>
            </tr>
            <tr align="center">
                <td>用户名</td>
                <td>密码</td>
                <td>性别</td>
                <td colspan="2">操作</td>
            </tr>
            
            <%for(int i = 0 ; i<list.size();i++) {           
                UserVo user = list.get(i);%>
                <tr align="center" >
                <td><%=user.getUserName()%></td>
                <td><%=user.getUserPassword() %></td>
                <td><%=user.getUserSex() %></td>
                <td><a href="ServletDeleteUser?userId=<%=user.getUserId() %>">删除</a></td>
                <td><a href="ServletToUserUpdate?userId=<%=user.getUserId() %>">修改</a></td>
            </tr>
            <% } %>
        </table>
    </form>
    </div>
  </body>
</html>