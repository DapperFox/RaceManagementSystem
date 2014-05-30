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
				<form class="navbar-form" role="search" method="" action="">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search" name="search">
						<div class="input-group-btn">
							<button class="btn btn-default search-button" type="submit"><i class="glyphicon glyphicon-search"></i></button>
						</div>
					</div>
				</form>
			</div>
		</div>

   		<%@ include file="../WEB-INF/partials/footer.jsp" %>
</body>
</html>