<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/4/9
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>user_manager</title>
</head>
<body>
============================用户名查询==================================================<br>
<form method="post" action="${pageContext.request.contextPath }/user/user_like">
    用户名:<input type="text" name="user_like"><br>
    <input type="submit" value="搜索">
</form>
============================浏览用户==================================================<br>
<table bgcolor="#7fffd4" border="1">
    <tr>
        <td>用户id</td>
        <td>用户名</td>
        <td>用户密码</td>
        <td>用户电话</td>
        <td>用户地址</td>
        <td>用户类型</td>
        <td>用户删除</td>
        <td>用户修改</td>
        <td>用户添加</td>
    </tr>
    <c:forEach items="${userShows}" var="userShow">
        <tr>
            <td>${userShow.user_id}</td>
            <td>${userShow.user_name}</td>
            <td>${userShow.user_password}</td>
            <td>${userShow.user_phone}</td>
            <td>${userShow.user_address}</td>
            <td>${userShow.user_type_name}</td>
            <td><a href="${pageContext.request.contextPath }/user/to_modify?user_id=${userShow.user_id}">修改</a></td>
            <td><a href="${pageContext.request.contextPath }/user/delete?user_id=${userShow.user_id}">删除</a></td>
            <td><a href="${pageContext.request.contextPath }/user/to_add">添加</a></td>
        </tr>
    </c:forEach>
</table>
<form method="post" action="${pageContext.request.contextPath }/user/pager">
    当前:<input type="text" name="current_pager" value="${pager.current_pager}">/<input type="text" value="${pager.all_pager}" name="all_pager"> <input type="submit" value="跳转">
</form>
<a href="${pageContext.request.contextPath }/menu/to_index">首页</a>
</body>
</html>
