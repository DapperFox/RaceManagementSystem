<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
    <%--jquery--%>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <%--twitter bootstrap--%>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <%--custom css--%>
    <link rel="stylesheet" href="/resources/style/main.css"/>
    <%--custom js--%>
    <script src="/resources/script/main.js"></script>
</head>
<body>	
		<%@ include file="../WEB-INF/partials/header.jsp" %>
	
		<div class="container">
    		<div class="row">						
				<form class="navbar-form" role="search" method="post" action="/race/search">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search" name="search">
						<div class="input-group-btn">
							<button class="btn btn-default search-button" type="submit"><i class="glyphicon glyphicon-search"></i></button>
						</div>
					</div>
				</form>
			</div>
			
			<div class="row">
				<div class="jumbotron">
					<p>Featured Event Here</p>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-3">
					<img alt="Running" src="../resources/images/running.jpg" class="image-responsive raceTypeImage">	
				</div>
				<div class="col-md-3">
					<img alt="Cycling" src="../resources/images/cycling.jpg" class="image-responsive raceTypeImage">	
				</div>
				<div class="col-md-3">
					<img alt="Triathlon" src="../resources/images/triathlon.jpg" class="image-responsive raceTypeImage">	
				</div>
				<div class="col-md-3">
					<img alt="Special" src="../resources/images/special.jpg" class="image-responsive raceTypeImage">	
				</div>
			</div>
		</div>

   		<%@ include file="../WEB-INF/partials/footer.jsp" %>
</body>
</html>