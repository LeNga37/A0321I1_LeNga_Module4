<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/12/2021
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Sandwich</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<h2>Sandwich Condiment</h2>
<form action="/save">
    <div class="form-check form-check-inline">
        <input class="form-check-input" type="checkbox" id="cond1" name="condiment" value="Lettuce">
        <label class="form-check-label" for="cond1">Lettuce</label>
    </div>
    <div class="form-check form-check-inline">
        <input class="form-check-input" type="checkbox" id="cond2" name="condiment" value="Tomato">
        <label class="form-check-label" for="cond2">Tomato</label>
    </div>
    <div class="form-check form-check-inline">
        <input class="form-check-input" type="checkbox" id="cond3" name="condiment" value="Mustard">
        <label class="form-check-label" for="cond3">Mustard</label>
    </div>
    <div class="form-check form-check-inline">
        <input class="form-check-input" type="checkbox" id="cond4" name="condiment" value="Sprouts">
        <label class="form-check-label" for="cond4">Sprouts</label>
    </div>
    <br>
    <div>
    <button type="submit" class="btn btn-primary">Choice</button>
    </div>
    <br>
</form>
<span>
    Choice:
    <c:forEach items="${condiment}" var="condiment">
        ${condiment}
    </c:forEach>
</span>
<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
</body>
</html>
