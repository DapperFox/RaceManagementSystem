<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>R.E.M.S.</title>
</head>
<body>

	<div class="navbar navbar-default" role="navigation">
        <div class="container">
          <div class="navbar-header">
            <a class="navbar-brand" href="/">Race Event Management</a>
            <ul class="nav navbar-nav">
	            <li><a href="/">Home</a></li>
	            <li><a href="/race/events">Events</a></li>
	        </ul>
          </div>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
	            <c:choose>
	            	<c:when test="${user.loggedIn}">
		            	<li class="loggedInUser">Welcome, ${user.firstName }!</li>
		            	<li><a href="/logout">Logout</a></li>
		            </c:when>
		            <c:otherwise>
		            	<li><a href="#">Login</a></li>
		              	<li><a href="/racer/register">Register</a></li>
		           </c:otherwise>
	            </c:choose>
            </ul>
          </div>
        </div>
      </div>
	
</body>
</html>