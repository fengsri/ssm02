<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/4/9
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息修改</title>
</head>
<body>
    <form action="${pageContext.request.contextPath }/user/modify" method="post">
        <table bgcolor="#7fffd4" border="1">
            <tr hidden="hidden">
                <td>用户id</td>
                <td><input type="text" value="${userShow.user_id}" name="user_id"></td>
            </tr>
            <tr>
                <td>用户名</td>
                <td><input type="text" value="${userShow.user_name}" name="user_name"></td>
            </tr>
            <tr>
                <td>用户密码</td>
                <td><input type="text" value="${userShow.user_password}" name="user_password"></td>
            </tr>
            <tr>
                <td>用户电话</td>
                <td><input type="text" value="${userShow.user_phone}" name="user_phone"></td>
            </tr>
            <tr>
                <td>用户地址</td>
                <td><input type="text" value="${userShow.user_address}" name="user_address"></td>
            </tr>
            <tr>
                <td>用户类型</td>
                <td><input type="text" value="${userShow.user_type_name}" name="user_type_name"></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="修改"></td>
            </tr>
        </table>
    </form>
    <a href="${pageContext.request.contextPath }/user/manager_user">返回</a>
</body>
</html>
