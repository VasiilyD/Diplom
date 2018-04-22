<%--
  Created by IntelliJ IDEA.
  User: Виктория
  Date: 26.03.2018
  Time: 0:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dataClient</title>
</head>
<body>
<H1>Client detail</H1>>
<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Title</th>
        <th width="120">Author</th>
        <th width="120">Price</th>
    </tr>
    <tr>
        <td>${client.id}</td>
        <td>${client.login}</td>
        <td>${client.password}</td>
        <td>${client.age}</td>
    </tr>
</table>



</body>
</html>
