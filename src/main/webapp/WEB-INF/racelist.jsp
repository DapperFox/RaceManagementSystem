<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="/resources/style/main.css" />
	<title>List of Race Events</title>
</head>
<body>
	<jsp:include page="/WEB-INF/partials/header.jsp">
		<jsp:param value="user" name="user"/>
	</jsp:include>

	<div class="container">
		<div class="row">
			<form class="navbar-form" role="search" method="post"
				action="/race/search">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search"
						name="search">
					<div class="input-group-btn">
						<button class="btn btn-default search-button" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
			</form>
		</div>
		<div class="row">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Event Name</th>
						<th>Race Type</th>
						<th>Description</th>
						<th>Cost</th>
						<th>Date</th>
						<th>Time</th>
					</tr>
				</thead>
			
				<c:choose>
					<c:when test="${not empty model }">
						<c:forEach var="race" items="${model}">
							<tr>
								<td>
		                            <a href="/race/${race.id}">
		                                <c:out value="${race.raceName}" />
		                            </a>
		                        </td>
								<td><c:out value="${race.raceType}" /></td>
								<td><c:out value="${race.raceDescription}" /></td>
								<td><c:out value="${race.formattedCost}" /></td>
								<td><c:out value="${race.raceDate}" /></td>
								<td><c:out value="${race.raceTime}" /></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
					<tr>
						<td>
							<p class="text-warning h4">Your search did not match any results</p>
						</td>
					</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
	</div>

	<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
</body>
</html>
