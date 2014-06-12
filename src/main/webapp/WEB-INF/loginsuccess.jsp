<%--
  Created by IntelliJ IDEA.
  User: blakebishop
  Date: 6/11/14
  Time: 6:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/style/main.css" />
    <title>Login Success</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-md-3">
             <h3>Login Successful</h3>
            <a href="/" class="btn btn-default">Home</a>
            <a href="/race/events" class="btn btn-default">Events</a>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
</body>
</html>
