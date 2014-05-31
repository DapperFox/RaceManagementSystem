<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/style/main.css"/>
<title>Race Event Details</title>
</head>
<body>
	<%@ include file="../WEB-INF/partials/header.jsp" %>

	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<img alt="Race poster image" src="${model.imageFilePath}">	
			</div>
			<div class="col-md-8">
				<h1>${model.raceName}</h1>
				<h2>${model.id }</h2>
				<h2>${model.raceLocation}</h2>
				<h2>${model.raceDate}</h2>
				<h2>${model.formattedCost }</h2>
				<span class="pull-right">
					${model.raceTwitterPage}
					&nbsp;&nbsp;
					${model.raceFaceBookPage}
				</span>
			</div>
		</div>
		<div class="row">
			<h2>${model.raceDescription}</h2>
		</div>
		<form role="form" method="POST" action="/race/${model.id}/register">
		<button type="submit" class="btn btn-default pull-right">Register for race</button>
		</form>
	</div>
	
	<%@ include file="../WEB-INF/partials/footer.jsp" %>
	
</body>
</html>
