
angular.module('userApp',[]).controller('userFormCtrl',['$http','$scope',function($http,$scope){
	console.log("module")
	$scope.user;
	$scope.submit = function(){
		if($scope.user.Username != "" && $scope.user.Password != ""){
			$scope.user.isManager = false;
			var url="http://localhost:8082/GhostGroove/user/create"
			$http.post(url,JSON.stringify($scope.user));
			console.log($scope.user);
		}
		else{
			console.log($scope.user);
		}
	}
}])