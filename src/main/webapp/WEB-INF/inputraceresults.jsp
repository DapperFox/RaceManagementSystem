<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/style/main.css" />
<title>Insert Race Results</title>
</head>
<body>
	<%@ include file="../WEB-INF/partials/header.jsp"%>
	<div class="container">
		<div class="row">
		
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Racer Id</th>
						<th>Racer Name</th>
						<th>Ranking</th>
						<th>Time</th>
		
					</tr>
				</thead>
				
				<c:if test="${model != null }">
				<form role="form" method="POST" action="/admin/${model.id }/submitRaceResults">
				<c:forEach var="racer" items="${model.racers}">
					<tr>
						
						<td><c:out value="${racer.id}" /></td>
						<td><p name="racerId"> ${racer.id}</td>
						<td><c:out value="${racer.firstName} ${racer.lastName }" /></td>
						<td><input type="Text" class="form-control" name="rank"></td>
						<td><input type="text" class="form-control" name="raceTime"></td>
				
					</tr>
				</c:forEach>
				<button type="submit" class="btn btn-default pull-right">Submit</button>
				</form>
				</c:if>
			</table>
		</div>
	</div>
	<%@ include file="../WEB-INF/partials/footer.jsp"%>
</body>
</html>