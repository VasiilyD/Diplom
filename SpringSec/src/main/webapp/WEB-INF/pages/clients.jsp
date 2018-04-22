<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
Created by IntelliJ IDEA.
User: Виктория
Date: 25.03.2018
Time: 23:32
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Clients</title>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>

<br/>
<br/>

<h1> Client list</h1>

<c:if test="${!empty listClients}">
    <table class="tg">
        <tr>
            <th width="80">Id</th>
            <th width="120">login</th>
            <th width="120">password</th>
            <th width="40">age</th>
            <th width="120">email</th>
            <th width="140">phone</th>
            <th width="40">edit</th>
            <th width="40">remove</th>
        </tr>
        <c:forEach items="${listClients}" var="client">
            <tr>
                <td>${client.id}</td>
                <td><a href="/clientData/${client.id}" target="_blank">${client.login}
                <td>${client.password}</td>
                <td>${client.age}</td>
                <td>${client.email}</td>
                <td>${client.phone}</td>
                <td><a href="<c:url value="/edit/${client.id}"/>">Edit</a></td>
                <td><a href="<c:url value="/remove/${client.id}"/>">delete</a></td>
            </tr>
        </c:forEach>
    </table>

</c:if>

<h1>add a Client</h1>
<c:url var="addActoin" value="/clients/add"/>

<from:form action="${addActoin}" commandName="client">
    <table>
        <c:if test="${!empty client.login}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="login">
                    <spring:message text="Login"/>
                </form:label>
            </td>
            <td>
                <form:input path="login"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="password">
                    <spring:message text="password"/>
                </form:label>
            </td>
            <td>
                <form:input path="password"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="age">
                    <spring:message text="age"/>
                </form:label>
            </td>
            <td>
                <form:input path="age"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="email">
                    <spring:message text="email"/>
                </form:label>
            </td>
            <td>
                <form:input path="email"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="phone">
                    <spring:message text="phone"/>
                </form:label>
            </td>
            <td>
                <form:input path="phone"/>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <c:if test="${!empty client.login}">
                    <input type="submit"
                           value="<spring:message text="Edit client"/>"/>
                </c:if>
                <c:if test="${empty client.login}">
                    <input type="submit"
                           value="<spring:message text="Add client"/>"/>
                </c:if>
            </td>
        </tr>
    </table>


</from:form>


</body>
</html>
