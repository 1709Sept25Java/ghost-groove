
var app = angular.module('mgrApp',[]);

app.controller('genreCtrl',function($scope,$http){
	var url = "http://localhost:8080/GhostGroove/genre/all";
	$http.get(url).then(function(response){
		//console.log(response.data)
		$scope.genres = response.data
	})
});