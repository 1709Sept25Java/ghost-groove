<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ghost: new Ghost</title>

<!-- Angular and Bootstrap-->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.5/angular.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header"><a class="navbar-brand" href="/GhostGroove">Ghost Groove</a></div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/GhostGroove/user/login"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
			</ul>
		</div>
	</nav>
	
	<div class="container">
		<form:form method="POST" action="create" commandName="user"  modelAttribute="user"  class="horizontal-form">
			<div class="form-group">
    			<form:label path="Username" class="control-label col-sm-2" for="username">Username:</form:label>
    			<div class="col-sm-10">
    	  			<form:input type="text" path="Username" class="form-control" name="username" placeholder="Enter username"/>
    			</div>
  			</div>
  			<br> <br>
  			<div class="form-group">
    			<form:label path="Password" class="control-label col-sm-2" for="password">Password:</form:label>
    			<div class="col-sm-10">
      				<form:input type="password" path="Password" class="form-control" name="password" placeholder="Enter password"/>
    			</div>
  			</div>
  			<br><br>
  			<div class="form-group">
    			<form:label path="Firstname" class="control-label col-sm-2" for="Firstname">First Name:</form:label>
    			<div class="col-sm-10">
      				<form:input type="text" path="Firstname" class="form-control" name="Firstname" placeholder="Enter password"/>
    			</div>
  			</div>
  			<br><br>
  			<div class="form-group">
    			<form:label path="Lastname" class="control-label col-sm-2" for="Lastname">Last Name:</form:label>
    			<div class="col-sm-10">
      				<form:input type="text" path="Lastname" class="form-control" name="Lastname" placeholder="Enter password"/>
    			</div>
  			</div>
  			<br><br>
  			<div class="form-group">
    			<form:label path="Email" class="control-label col-sm-2" for="email">Email:</form:label>
    			<div class="col-sm-10">
      				<form:input type="text" path="Email" class="form-control" name="email" placeholder="Enter password"/>
    			</div>
  			</div>
  			<br><br>
  			<div class="form-group"> 
    			<div class="col-sm-offset-11 col-sm-10">
    	  			<form:button name="submit" class="btn btn-primary">Submit</form:button>
    			</div>
  			</div>
		</form:form>
		
	</div>
	
</body>
</html>