<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			
			<div id="myCarousel" class="carousel slide">
		      <div class="carousel-inner">
		        <div class="item active">
		          <img src="../resources/images/triBanner.jpg" alt="">
		          <div class="container">
		            <div class="carousel-caption">
		              <h1>SLCycle</h1>
		              <p class="lead">Cruise around Salt Lake City in a 50 miler.</p>
		              <a class="btn btn-large btn-primary" href="/race/201">Register today</a>
		            </div>
		          </div>
		        </div>
		      </div>
		      <!-- 
		      <a class="left carousel-control" href="#myCarousel" data-slide="prev">&#60;</a>
		      <a class="right carousel-control" href="#myCarousel" data-slide="next">&#62;</a>
		      -->
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