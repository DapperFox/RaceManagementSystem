<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		            	<li><a href="/racer/login">Login</a></li>
		              	<li><a href="/racer/register">Register</a></li>
		           </c:otherwise>
	            </c:choose>
            </ul>
          </div>
        </div>
      </div>