<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/style/main.css" />
<title>Race Results</title>
</head>
<body>

	<jsp:include page="/WEB-INF/partials/header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Racer ID</th>
						<th>First Name</th>
						<th>Time</th>
						<th>Place</th>
					</tr>
				</thead>

				<c:forEach var="racer" items="${model}">
					<tr>
                        <td><c:out value="${racer.racer.id}" /></td>
                        <td><c:out value="${racer.racer.firstName}" /></td>
						<td><c:out value="${racer.raceTime}" /></td>
                        <td><c:out value="${racer.racePosition}" /></td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
</body>
</html>