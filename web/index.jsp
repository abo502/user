<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.User" %><%--
  Created by IntelliJ IDEA.
  User: baobao
  Date: 2020/11/30
  Time: 9:14 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<form action="/user" method="get">
    <div style="height:500px; width:500px; margin:400px 650px;text-align: center">
         <input type="submit" value="点击进入用户列表！！！" style="background-color: darkseagreen; width: 400px; height: 200px;font-size: 20px">
    </div>
</form>
</body>
</html>
