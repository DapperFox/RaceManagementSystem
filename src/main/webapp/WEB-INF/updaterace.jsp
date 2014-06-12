<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/style/main.css"/>
<title>Update Race</title>
</head>
<body>
	<jsp:include page="/WEB-INF/partials/header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<h1>Update Event</h1>
			<hr />
		</div>
		<div class="row">	
			<form role="form" method="POST" action="/race/${model.id }/update">
		      <div class="form-group">
		        <label class="control-label">Event Name</label>
		       
				<input type="text" class="form-control" name="name" value=" ${model.raceName }">
		      </div>
		      <label class="control-label">Event Type</label>
		      <select class="form-control" name="type">
				  <option>Running</option>
				  <option>Cycling</option>
				  <option>Triathlon</option>
				  <option>Special</option>
			  </select>
			  <div class="form-group">
		        <label class="control-label">Location</label>
				<input type="text" class="form-control" name="location" value="${model.raceLocation }">
		      </div>
			  <div class="form-group">
		        <label class="control-label">Date</label>
				<input type="date" class="form-control" name="date" value="${model.formattedRaceDate }">
		      </div>
		      <div class="form-group">
		        <label class="control-label">Time</label>
				<input type="time" class="form-control" name="time" value="${model.raceTime }">
		      </div>
			  <div class="form-group">
		        <label class="control-label">Cost</label>
				<input type="number" step="any" class="form-control" name="cost" value="${model.raceCost }">
		      </div>
			  <div class="form-group">
		        <label class="control-label">Description</label>
				<textarea class="form-control" rows="3" name="description">${model.raceDescription }</textarea>
		      </div>
			  <div class="form-group">
		        <label class="control-label">Twitter Page</label>
				<input type="text" class="form-control" name="twitterPage" value="${model.raceTwitterPage }">
		      </div>
		      <div class="form-group">
		        <label class="control-label">Facebook page</label>
				<input type="text" class="form-control" name="facebookPage" value="${model.raceFaceBookPage }">
		      </div>
		      <button type="submit" class="btn btn-default pull-right">Update Event</button>
		    </form>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
	
</body>
</html>
