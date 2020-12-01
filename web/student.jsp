<%@ page import="entity.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: baobao
  Date: 2020/11/30
  Time: 10:48 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生列表</title>
</head>
<body>
<h1 align="center">学生列表:</h1><br>
<form action="/data" method="get">
    <div style="height:50px; width:500px; margin:0 auto;text-align: center">
        筛选大于该成绩的同学：
        <input type="number" name="condition">&nbsp;<input type="submit" value="搜索">
    </div>
<%List<Student> students = (List<Student>) session.getAttribute("students");%>
<table align="center" border="1px">
    <th>学号：</th>
    <th>学生姓名：</th>
    <th>学生成绩：</th>
    <%
        for (Student student : students) {
    %>
    <tr>
        <td><%=student.getStudentNo()%>
        </td>
        <td><%=student.getName()%>
        </td>
        <td><%=student.getScope()%>
        </td>
        <%}%>
    </tr>
</table>
</form>
</body>
</html>
