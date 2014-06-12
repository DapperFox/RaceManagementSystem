<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/style/main.css" />
<title>Admin Dashboard</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/header.jsp">
    <jsp:param value="user" name="user"/>
</jsp:include>
	<div class="container">
		
		<div class="row">
		
			<div class="pull-right">
				<a href='/race/create'><button class="btn btn-default"><span class="glyphicon glyphicon-plus"></span>&nbsp;Create Event</button></a>
			</div>
		
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Event Name</th>
						<th>Event Date</th>
						<th>Event Type</th>
						<th>Edit</th>
						<th>Delete</th>
						<th>Race Results</th>
					</tr>
				</thead>
				
				<c:if test="${model != null }">
				<c:forEach var="race" items="${model}">
					<tr>
						<td><a href="/race/${race.id}"> <c:out
									value="${race.raceName}" />
						</a></td>
						<td><c:out value="${race.raceDate}" /></td>
						<td><c:out value="${race.raceType}" /></td>
						<td><a href='/admin/${race.id }/update'><button class="btn btn-default">Edit</button></a></td>
						<td><a href='/admin/${race.id }/delete'><button class="btn btn-default">Delete</button></a></td>
						<td><a href='/admin/${race.id }/results'><button class="btn btn-default">Results</button></a></td>
					</tr>
				</c:forEach>
				</c:if>
			</table>
		</div>
	</div>
<%@ include file="../WEB-INF/partials/footer.jsp" %>
</body>
</html>