<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/style/main.css"/>
<title>Register</title>
</head>
<body>
	<%@ include file="../WEB-INF/partials/header.jsp" %>

	<div class="container">

		<div class="row">
			<h1>Register</h1>
			<hr />
		</div>
		<div class="row">	
			<form role="form" method="POST" action="/racer/register">
		      <div class="form-group">
		        <label class="control-label">First Name</label>
				<input type="text" class="form-control" name="firstName">
		      </div>
		      <div class="form-group">
		        <label class="control-label">Last Name</label>
				<input type="text" class="form-control" name="lastName">
		      </div>
		      <div class="form-group">
			    <label class="contorl-label">Email Address</label>
			    <input type="email" class="form-control" name="email" title="Please enter a valid email address.">
			  </div>
			  <div class="form-group">
			    <label class="contorl-label">Password</label>
			    <input type="password" class="form-control" name="password" title="Please enter a strong password.">
			  </div>
			  <div class="form-group">
			  	<label class="control-label">Gender</label>
		      	<select class="form-control" name="gender">
				  <option>Male</option>
				  <option>Female</option>
			  	</select>
			  </div>
			  <div class="form-group">
		        <label class="control-label">Birthday</label>
				<input type="date" class="form-control" name="birthDate">
		      </div>
		      <div class="form-group">
		        <label class="control-label">Phone Number</label>
				<input type="tel" class="form-control" name="phoneNumber" pattern="[0-9]{10}" title="Please enter a valid phone number.">
		      </div>
		      <div class="form-group">
		        <label class="control-label">Address 1</label>
				<input type="text" class="form-control" name="address_one">
		      </div>
		      <div class="form-group">
		        <label class="control-label">Address 2</label>
				<input type="text" class="form-control" name="address_two">
		      </div>
		      <div class="form-group">
		        <label class="control-label">City</label>
				<input type="text" class="form-control" name="city">
		      </div>
			  <div class="form-group">
		        <label class="control-label">State</label>
		      	<select class="form-control" name="state">
					<option value="" selected="selected">Select a State</option> 
					<option value="AL">Alabama</option> 
					<option value="AK">Alaska</option> 
					<option value="AZ">Arizona</option> 
					<option value="AR">Arkansas</option> 
					<option value="CA">California</option> 
					<option value="CO">Colorado</option> 
					<option value="CT">Connecticut</option> 
					<option value="DE">Delaware</option> 
					<option value="DC">District Of Columbia</option> 
					<option value="FL">Florida</option> 
					<option value="GA">Georgia</option> 
					<option value="HI">Hawaii</option> 
					<option value="ID">Idaho</option> 
					<option value="IL">Illinois</option> 
					<option value="IN">Indiana</option> 
					<option value="IA">Iowa</option> 
					<option value="KS">Kansas</option> 
					<option value="KY">Kentucky</option> 
					<option value="LA">Louisiana</option> 
					<option value="ME">Maine</option> 
					<option value="MD">Maryland</option> 
					<option value="MA">Massachusetts</option> 
					<option value="MI">Michigan</option> 
					<option value="MN">Minnesota</option> 
					<option value="MS">Mississippi</option> 
					<option value="MO">Missouri</option> 
					<option value="MT">Montana</option> 
					<option value="NE">Nebraska</option> 
					<option value="NV">Nevada</option> 
					<option value="NH">New Hampshire</option> 
					<option value="NJ">New Jersey</option> 
					<option value="NM">New Mexico</option> 
					<option value="NY">New York</option> 
					<option value="NC">North Carolina</option> 
					<option value="ND">North Dakota</option> 
					<option value="OH">Ohio</option> 
					<option value="OK">Oklahoma</option> 
					<option value="OR">Oregon</option> 
					<option value="PA">Pennsylvania</option> 
					<option value="RI">Rhode Island</option> 
					<option value="SC">South Carolina</option> 
					<option value="SD">South Dakota</option> 
					<option value="TN">Tennessee</option> 
					<option value="TX">Texas</option> 
					<option value="UT">Utah</option> 
					<option value="VT">Vermont</option> 
					<option value="VA">Virginia</option> 
					<option value="WA">Washington</option> 
					<option value="WV">West Virginia</option> 
					<option value="WI">Wisconsin</option> 
					<option value="WY">Wyoming</option>
					</select>
		      </div>
		      <div class="form-group">
		        <label class="control-label">Zip Code</label>
				<input type="text" class="form-control" pattern="\d{5}" name="zip" title="Please enter a valid zip code.">
		      </div>
  
		      <button type="submit" class="btn btn-default pull-right">Register</button>
		    </form>
		</div>
	</div>
	
	<%@ include file="../WEB-INF/partials/footer.jsp" %>
</body>
</html>