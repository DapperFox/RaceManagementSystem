<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="" />
<title>Race Event Details</title>
</head>
<body>
	<%@ include file="../WEB-INF/partials/header.jsp" %>

	<h1>${model.raceName}</h1>
	
	<%@ include file="../WEB-INF/partials/footer.jsp" %>
</body>
</html>