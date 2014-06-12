<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/style/main.css"/>
<title>Race Event Details</title>
</head>
<body>
	<jsp:include page="/WEB-INF/partials/header.jsp">
		<jsp:param value="user" name="user"/>
	</jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<img alt="Race poster image" class="img-responsive" src="${model.imageFilePath}>
			</div>
			<div class="col-md-8">
				<h1>${model.raceName}</h1>
				<h3>Location</h3>
					<h5>${model.raceLocation}</h5>
				<h3>Date</h3>
					<h5>${model.raceDate}</h5>
				<h3>Cost</h3>
					<h5>${model.formattedCost}</h5>
				<span class="pull-right">
					<c:url var ="facebook" value="${model.raceFaceBookPage}"></c:url>
					<c:url var ="twitter" value="${model.raceTwitterPage}"></c:url>
					<a href="${facebook }"><img alt="Facebook" src="/resources/images/fb_logo.png"></a>
					&nbsp;&nbsp;
					<a href="${twitter }"><img alt="Twitter" src="/resources/images/twitter_logo.png"></a>
				</span>
			</div>
		</div>
		<div class="row">
			<p>${model.raceDescription}</p>
		</div>
		<form role="form" method="POST" action="/race/register/${model.id}">
		<button type="submit" class="btn btn-default pull-right">Register</button>
		</form>
	</div>
	
	<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
	
</body>
</html>
