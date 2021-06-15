<%--
  Created by IntelliJ IDEA.
  User: 波比
  Date: 2021/6/14
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="updateUser.do" method="post">
        <input type="hidden" name="id" value="<%=request.getParameter("id")%>">
        <label for="name">姓名</label> <input type="text" name="name" id="name" value="<%=request.getParameter("name")%>">
        <label for="address">地址</label> <input type="text" name="address" id="address" value="<%=request.getParameter("address")%>">
        <input type="submit" value="更新">
    </form>
</body>
</html>
