<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 11/12/2021
  Time: 10:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<form action="/convert" method="post">
    <div class="container">
        <div class="form-group">
            <label for="rate">Rate</label>
            <input type="number" class="form-control" id="rate" name="rate">
        </div>
        <div class="form-group">
            <label for="usd">USD</label>
            <input type="number" class="form-control" id="usd" name="usd">
        </div>
        <button type="submit" class="btn btn-primary">Convert</button>
    </div>
</form>

<h4>Rate: ${rate}</h4>
<h4>Usd: ${usd}</h4>
<h4>Vnd: ${vnd}</h4>

<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>

</body>
</html>
