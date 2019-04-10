<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/4/8
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>search</title>
</head>
<body>
========================商品======================================
<table border="1" bgcolor="#7fffd4">
    <tr>
        <td>商品id</td>
        <td>商品名称</td>
        <td>商品价格</td>
        <td>商品图片</td>
        <td>商品描述</td>
        <td>商品类型</td>
    </tr>
    <c:forEach items="${menuShows}" var="menuShow">
        <tr>
            <td>${menuShow.menu_id}</td>
            <td>${menuShow.menu_name}</td>
            <td>${menuShow.menu_price}</td>
            <td>${menuShow.menu_pic}</td>
            <td>${menuShow.menu_dis}</td>
            <td>${menuShow.menu_type_name}</td>
        </tr>
    </c:forEach>
    <tr><td colspan="6" align="center"><a href="${pageContext.request.contextPath }/menu/to_index">返回</a></td></tr>
</table>
</body>
</html>
