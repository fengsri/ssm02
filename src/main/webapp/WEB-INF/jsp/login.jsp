<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/4/8
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath }/login/user_login">
    <table border="1" bgcolor="#7fffd4">
        <tr><td colspan="2" align="center">登陆</td></tr>
        <tr>
            <td>用户名：</td>
            <td><input type="text" name="user_name"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="user_password"></td>
        </tr>
        <tr>
            <td>类型:</td>
            <td>游客<input type="radio" name="user_type_id" value="1"> 管理员<input type="radio" name="user_type_id" value="2"></td>
        </tr>
        <tr><td colspan="2" align="center"><input type="submit" value="登陆"></td></tr>
    </table>
</form>
</body>
</html>
