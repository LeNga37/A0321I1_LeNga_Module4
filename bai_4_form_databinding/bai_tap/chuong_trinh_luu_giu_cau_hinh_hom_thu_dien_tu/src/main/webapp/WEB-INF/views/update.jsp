<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/20/2021
  Time: 8:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        div{
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<h3>Settings</h3>
<form:form method="post" action="update" modelAttribute="email">
    <div>
        <form:label path="languages"><b>Languages: </b></form:label>
        <form:select path="languages" items="${itemsLanguages}"/>
    </div>

    <div>
        <form:label path="pageSize"><b>Page Size: </b></form:label>
        <form:label path="pageSize">Show </form:label>
        <form:select path="pageSize" items="${itemsPageSize}"/>
        <form:label path="pageSize">emails per page </form:label>
    </div>

    <div>
        <form:label path="spamFilter"><b>Spams Filter: </b></form:label>
        <form:checkbox path="spamFilter"/>
        <form:label path="spamFilter">Enable spams filter </form:label>
    </div>

    <div>
        <form:label path="signature"><b>Signature: </b></form:label>
        <form:textarea path="signature"/>
    </div>
    <div>
        <input type="submit" value="Update"/>
    </div>
</form:form>
</body>
</html>
