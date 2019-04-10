<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/4/9
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>订单管理</title>
</head>
<body>

============================订单管理==================================================<br>
<table bgcolor="#7fffd4" border="1">
    <tr>
        <td>订单id</td>
        <td>订单日期</td>
        <td>用户id</td>
    </tr>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.order_id}</td>
            <td>${order.order_date}</td>
            <td>${order.user_id}</td>
    </c:forEach>
</table>
<form method="post" action="${pageContext.request.contextPath }/order/pager">
    当前:<input type="text" name="current_pager" value="${pager.current_pager}">/<input type="text" value="${pager.all_pager}" name="all_pager"> <input type="submit" value="跳转">
</form>
<a href="${pageContext.request.contextPath }/menu/to_index">首页</a>
</body>
</html>
