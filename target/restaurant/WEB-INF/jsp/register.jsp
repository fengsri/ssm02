<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/3/29
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>register</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/register/user_register">
    <table border="1" bgcolor="#7fffd4">
        <tr><td colspan="2">注册</td></tr>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="user_name"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="user_password"></td>
        </tr>
        <tr>
            <td>电话：</td>
            <td><input type="text" name="user_phone"></td>
        </tr>
        <tr>
            <td>地址：</td>
            <td><input type="text" name="user_address"></td>
        </tr>
        <tr>
            <td>类型：</td>
            <td><input type="text" name="user_type_id"></td>
        </tr>
        <tr><td colspan="2"><input type="submit" value="注册"></td></tr>
    </table>
</form>
</body>
</html>
