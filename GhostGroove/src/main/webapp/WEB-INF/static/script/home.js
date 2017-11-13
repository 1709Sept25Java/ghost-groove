var app = angular.module('homeApp',[]);

app.controller('genreCtrl',function($scope,$http){
	var url = "http://localhost:8082/GhostGroove/genre/all";
	$http.get(url).then(function(response){
		$scope.genres = response.data
	})
})

app.controller('playlistCtrl',function($scope,$http){
	var url = "http://localhost:8082/GhostGroove/playlist/byuser";
	$http.get(url).then(function(response){
		$scope.playlists = response.data
	})
	$scope.show_form = false;
	$scope.playlist={id:0,name:null,description:null,genre:null,comments:null,owners:null,songs:null};
	$scope.newPlaylist = function(){
		$scope.playlist.genre = JSON.parse($scope.playlist.genre)
		var url="http://localhost:8082/GhostGroove/playlist/add";
		console.log(JSON.stringify($scope.playlist));
		$http.post(url,JSON.stringify($scope.playlist)).then(function(response){
			$scope.status = "Success!";
			console.log($scope.status)
		})
	}
})
