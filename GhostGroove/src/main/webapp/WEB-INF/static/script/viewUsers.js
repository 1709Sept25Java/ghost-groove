
var app = angular.module('allUsersApp',[]);

app.controller('usersCtrl',function($scope,$http){
	var url="http://ec2-52-14-255-113.us-east-2.compute.amazonaws.com:8080/GhostGroove/user/allUsers";
	$http.get(url).then(function(response){
		console.log(response.data);
		$scope.users = response.data;
	})
})