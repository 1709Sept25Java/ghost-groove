<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="mgrApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ghost: Mgr Home</title>

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
				<li><a href="/GhostGroove/user/logout"><span class="glyphicon glyphicon-logout"></span>Logout</a></li>
			</ul>
		</div>
	</nav>
	
	<div class="container">
		<center><h1>Manager Home</h1></center>
		<table class="table table-striped">
			<thead><tr><th>Genre</th></tr></thead>
			<tbody ng-controller="genreCtrl" id="genreTable">
				<tr ng-repeat="x in genres">
					<td>{{x.name}}</td>
				</tr>
			</tbody>
		</table>
	</div>
	
</body>
<script src="../static/script/mgrHome.js"></script>
</html>