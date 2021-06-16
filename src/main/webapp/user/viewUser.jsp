<%@ page import="java.util.List" %>
<%@ page import="cn.edu.guet.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: 波比
  Date: 2021/6/9
  Time: 8:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table,tr,th,td{
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>地址</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<User> userList=(List<User>)request.getAttribute("userList");
            for(int i=0;i<userList.size();i++){
        %>
        <tr>
            <td><%=userList.get(i).getId()%></td>
            <td><%=userList.get(i).getName()%></td>
            <td><%=userList.get(i).getAddress()%></td>
            <td>
                <a href="deleteUser.do?id=<%=userList.get(i).getId()%>">删除</a>
                <a href="updateUser.jsp?id=<%=userList.get(i).getId()%>
&name=<%=userList.get(i).getName()%>&address=<%=userList.get(i).getAddress()%>">修改</a>
                <a href="addUser.jsp?id=<%=userList.get(i).getId()%>
&name=<%=userList.get(i).getName()%>&address=<%=userList.get(i).getAddress()%>">添加</a>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</body>
</html>
