<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/4/9
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>购物车</title>
</head>
<body>
=============================购物车===========================================
<table bgcolor="#7fffd4" border="1">
    <tr>
        <td>商品id</td>
        <td>商品名称</td>
        <td>商品价格</td>
        <td>商品图片</td>
        <td>商品描述</td>
        <td>商品类型</td>
        <td>取消</td>
    </tr>
    <c:forEach items="${menuShows}" var="menuShow">
        <tr>
            <td>${menuShow.menu_id}</td>
            <td>${menuShow.menu_name}</td>
            <td>${menuShow.menu_price}</td>
            <td>${menuShow.menu_pic}</td>
            <td>${menuShow.menu_dis}</td>
            <td>${menuShow.menu_type_name}</td>
            <td><a href="${pageContext.request.contextPath }/order/reduce?menu_id=${menuShow.menu_id}">取消</a></td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath }/order/to_pay">支付</a>
<a href="${pageContext.request.contextPath }/menu/to_index">首页</a>
</body>
</html>
