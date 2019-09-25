<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Student</title>
    <%@include file="WEB-INF/jspf/header-template.jsp" %>
</head>
<body>
<h1>Adding a new student</h1>
<form method="post" action="${pageContext.request.contextPath}/person">
    <input type="text" name="name" placeholder="name"><br/>
    <input type="text" name="birth" placeholder="birth"><br/>
    <input type="submit"/>
</form>

</body>
</html>