<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/4/9
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>用户信息</title>
</head>
<body>
============================用户信息==================================================<br>
<table bgcolor="#7fffd4" border="1">
    <tr>
        <td>用户id</td>
        <td>用户名</td>
        <td>用户密码</td>
        <td>用户电话</td>
        <td>用户地址</td>
        <td>用户类型</td>
    </tr>
    <c:forEach items="${userShows}" var="userShow">
        <tr>
            <td>${userShow.user_id}</td>
            <td>${userShow.user_name}</td>
            <td>${userShow.user_password}</td>
            <td>${userShow.user_phone}</td>
            <td>${userShow.user_address}</td>
            <td>${userShow.user_type_name}</td>
        </tr>
    </c:forEach>
    <tr><td colspan="6" align="center"><a href="${pageContext.request.contextPath }/user/manager_user">返回</a></td></tr>
</table>

</body>
</html>
