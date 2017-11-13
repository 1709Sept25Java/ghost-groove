<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="homeApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ghost: Home</title>

<!-- Angular and Bootstrap-->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.6.5/angular.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/GhostGroove/static/views/CSS/styleJsp.css"/>
</head>
<body>
	
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header"><a class="navbar-brand" href="/GhostGroove">Ghost Groove</a></div>
			<ul class="nav navbar-nav">
				<li class="dropdown" ng-controller="genreCtrl">
					<a class="dropdown-toggle" data-toggle="dropdown" href="#">Genres<span class="caret"></span></a>
						<ul class="dropdown-menu" >
							<li ng-repeat="g in genres"><a href="../genre/{{g.id}}">{{g.name}}</a></li>
						</ul>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/GhostGroove/user/logout"><span class="glyphicon glyphicon-logout"></span>Logout</a></li>
			</ul>
		</div>
	</nav>
	
	<div class="container" ng-controller="playlistCtrl">
		<center><h1>Home</h1></center>
		<button class="btn btn-primary col-sm-offset-11" ng-click="show_form = !show_form">Create Playlist</button>
		<form class="form-inline" ng-show="show_form" method="post" ng-submit="newPlaylist()">
			<div class="form-group">
				<label name="name">Playlist Name</label>
				<input ng-model="playlist.name" name="name" type="text" class="form-control"/>
			</div>
			<div class="form-group" ng-controller="genreCtrl">
				<label name="genre">Genre</label>
				<select ng-model="playlist.genre" name="genre" class="selectpicker">
					<option ng-repeat="g in genres" value="{{g.id}}">{{g.name}}</option>
				</select>
			</div>
			<button class="btn btn-primary">Submit</button>
		</form>
		<table class="table striped-table">
			<thead>
				<h2>Playlists</h2>
			</thead>
			<tbody>
				<tr ng-repeat="p in playlists">
					<td><a href="../playlist/view">{{p.name}}</a></td>
				</tr>
			</tbody>
		</table>
	</div>
	
</body>
<script src="../static/script/home.js"></script>
</html>