<%@ page import="bean.User" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: baobao
  Date: 2020/11/30
  Time: 10:48 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<h1 align="center">用户列表:</h1><br>
<form action="/user" method="get">
    <div style="height:50px; width:500px; margin:0 auto;text-align: center">
        筛选大于该年龄的用户：
        <input type="text" name="age">&nbsp;<input type="submit" value="搜索">
    </div>
</form>
<%List<User> users = (List<User>) session.getAttribute("users");%>
<table align="center" border="2px" width="420px" bgcolor="#f5f5f5">
    <th>用户姓名：</th>
    <th>用户性别：</th>
    <th>用户年龄：</th>
    <%
        for (User user : users) {
    %>
    <tr>
        <td><%=user.getName()%>
        </td>
        <td><%=user.getSex()%>
        </td>
        <td><%=user.getAge()%>岁
        </td>
        <%}%>
    </tr>
</table>
</body>
</html>
