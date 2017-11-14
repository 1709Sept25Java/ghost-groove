
var app = angular.module('allUsersApp',[]);

app.controller('usersCtrl',function($scope,$http){
	var url="http://localhost:8080/GhostGroove/user/allUsers";
	$http.get(url).then(function(response){
		console.log(response.data);
		$scope.users = response.data;
	})
})