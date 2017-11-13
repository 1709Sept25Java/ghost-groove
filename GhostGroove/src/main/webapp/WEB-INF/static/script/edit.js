var app = angular.module('GhostApp', []);

var results = [];

angular.module('GhotApp',[]).controller('VideosController',['$http','$scope',function($http,$scope){
	  
	  var url = "http://localhost:8082/GhostGroove/playlist/addSongPlaylists";
    $http.post(url).then( function(response) {
       $scope.results = response.data;
       $log.info($scope.results);
       
    })}]);