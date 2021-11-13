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
<form action="/translate" method="post">
    <div class="container">
        <div class="form-group">
            <label for="eng">English</label>
            <input type="text" class="form-control" id="eng" name="eng">
        </div>
        <button type="submit" class="btn btn-primary">Search</button>
    </div>
</form>

<h4>English: ${eng}</h4>
<h4>Vietnamese: ${vn}</h4>

<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>

</body>
</html>
