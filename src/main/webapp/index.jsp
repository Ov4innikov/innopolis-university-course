<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
    <%@include file="WEB-INF/jspf/header-template.jsp" %>
</head>
<body>
<h1>Students</h1>
<ul>
    <li><a href="${pageContext.request.contextPath}/person/list">List students</a></li>
    <li><a href="${pageContext.request.contextPath}/person">New student</a></li>
</ul>
</body>
</html>
