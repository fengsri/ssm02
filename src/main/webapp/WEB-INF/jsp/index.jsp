<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/4/8
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<h1>这是首页</h1>
<c:if test="${not empty user}">
    欢迎你...${user.user_name}<br>
    <c:if test="${user.user_type_id ==2 }">
        <a href="${pageContext.request.contextPath }/user/manager_user">游客管理</a><br>
        <a href="#">商品管理</a><br>
        <a href="${pageContext.request.contextPath }/order/manager_order">订单管理${order_count}</a><br>
    </c:if>
    <c:if test="${not empty goods}">
        <a href="${pageContext.request.contextPath }/order/to_order">购物车${goods.goods_count}</a><br>
    </c:if>
</c:if>
<c:if test="${empty user}">
    你好请<a href="${pageContext.request.contextPath }/WEB-INF/jsp/login.jsp">登陆</a>
</c:if>
============================商品名查询==================================================<br>
<form method="post" action="${pageContext.request.contextPath }/menu/menu_like">
    商品名:<input type="text" name="menu_like"><br>
    <input type="submit" value="提交">
</form>
============================浏览商品==================================================<br>
<table bgcolor="#7fffd4" border="1">
    <tr>
        <td>商品id</td>
        <td>商品名称</td>
        <td>商品价格</td>
        <td>商品图片</td>
        <td>商品描述</td>
        <td>商品类型</td>
        <td>加入购物</td>
    </tr>
    <c:forEach items="${menuShows}" var="menuShow">
        <tr>
            <td>${menuShow.menu_id}</td>
            <td>${menuShow.menu_name}</td>
            <td>${menuShow.menu_price}</td>
            <td>${menuShow.menu_pic}</td>
            <td>${menuShow.menu_dis}</td>
            <td>${menuShow.menu_type_name}</td>
            <td><a href="${pageContext.request.contextPath }/order/add?menu_id=${menuShow.menu_id}">添加</a></td>
        </tr>
    </c:forEach>
</table>
<form method="post" action="${pageContext.request.contextPath }/menu/pager">
    当前:<input type="text" name="current_pager" value="${pager.current_pager}">/<input type="text" value="${pager.all_pager}" name="all_pager"> <input type="submit" value="跳转">
</form>
</body>
</html>
