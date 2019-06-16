<%@ page import="part1.lesson23.task01.entity.Person" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Студенты</title>
    <%@include file="WEB-INF/jspf/header-template.jsp" %>
</head>
<body>
<table class="table">
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Birth date</th>
            <th>Email</th>
            <th>Phone</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="person" items="${persons}">
            <tr>
                <td><c:out value="${person.id}"/></td>
                <td><c:out value="${person.name}"/></td>
                <td><c:out value="${person.birthDate}"/></td>
                <td><c:out value="${person.email}"/></td>
                <td><c:out value="${person.phone}"/></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<br>
<a href="${pageContext.request.contextPath}/">Main page</a>
</body>
</html>
