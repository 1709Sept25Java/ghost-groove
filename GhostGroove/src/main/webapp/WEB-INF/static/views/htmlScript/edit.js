var app = angular.module('GhostApp', []);

app.controller('shareController', function($scope, $http) {
	$scope.show_form = false;
	$scope.username = null;
	$scope.playlistName = null;

	$scope.sharePlaylist = function(username, playlistName) {
		var data = {
			username : username,
			playlistName : playlistName
		};
		var url = "http://localhost:8082/GhostGroove/playlist/share";
		console.log(JSON.stringify($scope.data));
		$http.post(url, JSON.stringify(data)).then(function(response) {
			if (response.data)

				$scope.msg = "Post Data Submitted Successfully!";
			console.log($scope.msg)
		}, function(response) {
			$scope.msg = "Service does not Exists";
			$scope.statusval = response.status;
			$scope.statustext = response.statusText;
			$scope.headers = response.headers();

			console.log($scope.status)
		});
	};
});



