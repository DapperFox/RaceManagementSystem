<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<jsp:include page="/WEB-INF/partials/header.jsp"></jsp:include>
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
						<td><input class="hideBox" name="racerId" value="${racer.id}" readonly></td>
						<td><c:out value="${racer.firstName} ${racer.lastName }" /></td>
						<td><input type="text" class="form-control" name="rank"></td>
						<td><input type="text" class="form-control" name="raceTime"></td>
					</tr>
				</c:forEach>
						<input type="submit" value="Submit" class="btn btn-default pull-right"/>
						</form>
				
				</c:if>
			</table>
		</div>
	</div>
	<%@ include file="../WEB-INF/partials/footer.jsp"%>
</body>
</html>