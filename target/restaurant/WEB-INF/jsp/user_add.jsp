<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/4/9
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/user/add" method="post">
    <table bgcolor="#7fffd4" border="1">
        <tr>
            <td>用户名</td>
            <td><input type="text"  name="user_name"></td>
        </tr>
        <tr>
            <td>用户密码</td>
            <td><input type="text"  name="user_password"></td>
        </tr>
        <tr>
            <td>用户电话</td>
            <td><input type="text"  name="user_phone"></td>
        </tr>
        <tr>
            <td>用户地址</td>
            <td><input type="text"  name="user_address"></td>
        </tr>
        <tr>
            <td>用户类型</td>
            <td><input type="text"  name="user_type_name"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="添加"></td>
        </tr>
    </table>
</form>
<a href="${pageContext.request.contextPath }/user/manager_user">返回</a>
</body>
</html>
