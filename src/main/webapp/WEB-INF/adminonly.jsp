<%--
  Created by IntelliJ IDEA.
  User: blakebishop
  Date: 6/11/14
  Time: 7:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <%--jquery--%>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <%--twitter bootstrap--%>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <%--custom css--%>
    <link rel="stylesheet" href="/resources/style/main.css"/>
    <%--custom js--%>
    <script src="/resources/script/main.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/partials/header.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <h3>You do not have access to view this page.</h3>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
</body>
</html>
