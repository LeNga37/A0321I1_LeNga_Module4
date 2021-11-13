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
    <title>Email Validation</title>
    <link rel="stylesheet" href="/assert/bootstrap413/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assert/datatables/css/dataTables.bootstrap4.min.css">
</head>
<body>
<%--<h3>Email Validate</h3>--%>
<h5 style="color:red">${message}</h5>
<form action="/validate" method="post">
    <div class="container">
        <div class="form-group">
            <label for="email">Email</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="Enter email">
        </div>
        <button type="submit" class="btn btn-primary">Search</button>
    </div>
</form>
<h5>Hi ${email}</h5>
<script src="/assert/jquery/jquery-3.5.1.min.js"></script>
<script src="/assert/bootstrap413/js/popper.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.min.js"></script>
<script src="/assert/bootstrap413/js/bootstrap.bundle.js"></script>

</body>
</html>
