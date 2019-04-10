<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/4/9
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>支付</title>
</head>
<body>
<h3>你总共选购${goods_count}件商品，共${all_price}元</h3>
<h1><a href="${pageContext.request.contextPath }/order/pay">支付</a></h1>
<h1><a href="${pageContext.request.contextPath }/order/to_order">取消支付</a></h1>
</body>
</html>
