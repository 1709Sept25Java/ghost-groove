<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="allUsersApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ghost: View Users</title>

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
			<ul class="nav navbar-nav">
				<li><a href="/GhostGroove/user/mgrhome">Home</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/GhostGroove/user/logout"><span class="glyphicon glyphicon-logout"></span>Logout</a></li>
			</ul>
		</div>
	</nav>
	
	<div class="container">
		<center><h1>Users</h1></center>
		<table class="table table-striped" ng-controller="usersCtrl">
			<thead>
				<tr>
					<td>Username</td>
					<td>Name</td>
					<td>Email</td>
					<td>Manager</td>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="x in users">
					<td>{{x.username}}</td>
					<td>{{x.firstname}} {{x.Lastname}}</td>
					<td>{{x.email}}</td>
					<td>{{x.isManager}}</td>
				</tr>
			</tbody>
		</table>
	</div>
	
</body>
<script src="../static/script/viewUsers.js"></script>
</html>