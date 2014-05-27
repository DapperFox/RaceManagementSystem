<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="../resources/style/main.css"/>
<title>List of Race Events</title>
</head>
<body>
	<%@ include file="../WEB-INF/partials/header.jsp" %>
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
    <c:forEach var="i" begin="0" end="${model.size()}">
        <tr>
            <td><a href="/race/${model.id}/raceDetails" ><c:out value="${model[i].raceName}"/></a></td>
            <td><c:out value="${model[i].raceType}"/></td>
            <td><c:out value="${model[i].raceDescription}"/></td>
            <td><c:out value="${model[i].getFormattedCost()}"/></td>
            <td><c:out value="${model[i].raceDate}"/></td>
            <td><c:out value="${model[i].raceTime}"/></td>
        </tr>
    </c:forEach>
    </table>
	<%@ include file="../WEB-INF/partials/footer.jsp" %>
</body>
</html>