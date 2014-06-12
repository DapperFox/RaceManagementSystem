<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/style/main.css"/>
<title>Admin Register</title>
</head>
<body>
	<jsp:include page="/WEB-INF/partials/header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<h1>Register</h1>
			<hr />
		</div>
		<div class="row">	
			<form role="form" method="POST" action="/admin/register">
		      <div class="form-group">
		        <label class="control-label">Email</label>
				<input type="text" class="form-control" name="email">
		      </div>
		      <div class="form-group">
		        <label class="control-label">Password</label>
				<input type="password" class="form-control" name="password">
		      </div>
		      
  
		      <button type="submit" class="btn btn-default pull-right">Register</button>
		    </form>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
</body>
</html>