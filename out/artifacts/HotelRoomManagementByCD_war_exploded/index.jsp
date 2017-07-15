<%--
  Created by IntelliJ IDEA.
  User: houlx
  Date: 2017/7/6
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
    <h1>
        管理员登录
    </h1>
    <form action="/LoginServlet" method="post">
        account:<input type="text" name="account">
        <br>
        password:<input type="password" name="password">
        <input type="submit" value="Login">
    </form>
  </body>
</html>
