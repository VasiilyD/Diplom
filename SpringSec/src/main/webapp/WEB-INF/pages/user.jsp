<%--
  Created by IntelliJ IDEA.
  User: Виктория
  Date: 12.03.2018
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserBonus</title>


    <meta name ="viewport" content="width = device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" align="center">
    <h1>Admin page and USER. You can manage users here.</h1>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul id="groupList" class="nav navbar-nav">
                    <li>
                        <button type="button" id="delete" class="btn btn-default navbar-btn">Delete</button>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>

    <table class="table table-striped">
        <thead>
        <tr>
            <td></td>
            <td><b>Login</b></td>
            <td><b>E-mail</b></td>
            <td><b>Phone</b></td>
            <td><b>Role</b></td>
        </tr>
        </thead>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${user.id}" id="checkbox_${user.id}"/></td>
                <td>${user.login}</td>
                <td>${user.email}</td>
                <td>${user.phone}</td>
                <td>${user.role}</td>
            </tr>
        </c:forEach>
    </table>

    <p>Click to logout: <a href="/logout">LOGOUT</a></p>
</div>
<script>
    $('#delete').click(function () {
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post('/delete', data, function(data, status) {
            window.location.reload();
        });
    });
</script>
</body>
</html>
