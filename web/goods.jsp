<%@ page import="bean.Goods" %>
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
    <title>商品列表</title>
</head>
<body>
<h1 align="center">商品列表:</h1><br>
<form action="/good" method="get">
    <div style="height:50px; width:500px; margin:0 auto;text-align: center">
        筛选大于该价格的商品：
        <input type="text" name="price">&nbsp;<input type="submit" value="搜索">
    </div>
<%List<Goods> goods = (List<Goods>) session.getAttribute("goods");%>
<table align="center" border="2px" width="420px" bgcolor="#f5f5f5">
    <th>商品姓名：</th>
    <th>商品价格：</th>
    <%
        for (Goods good : goods) {
    %>
    <tr>
        <td><%=good.getName()%>
        </td>
        <td>￥<%=good.getPrice()%>.0
        </td>
        <%}%>
    </tr>
</table>
</form>
</body>
</html>
