<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/12/2021
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Sandwich</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<form method="post" action="/calculator">
    <h2>Simple Calculator</h2>
    <div>
        <span>First operand: </span>
        <input type="number" name="number1" style="margin-left: 27px">
    </div>
    <br>
    <div>
        <span>Operator</span>
        <select name="operator" style="margin-left: 60px">
            <option>Addition</option>
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="*">*</option>
            <option value="/">/</option>
        </select>
    </div>
    <br>
    <div>
        <span>Second operand: </span>
        <input type="number" name="number2" style="margin-left: 10px">
    </div>
    <br>
    <div>
        <input type="submit" value="Calculate" style="margin-left: 122px">
    </div>

    <h4>Number 1: ${number1}</h4>
    <h4>Addition: ${operator}</h4>
    <h4>Number 2: ${number2}</h4>
    <h4>Result: ${result}</h4>
</form>
<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>
</body>
</html>
