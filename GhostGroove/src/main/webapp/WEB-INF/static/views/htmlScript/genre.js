var app = angular.module('GhostApp',[]);

app.controller('CommnetController', function ($scope) {
     $scope.comments = [];
     $scope.commentPost = function() {
         if ($scope.comment != '') {
             $scope.comments.push($scope.comment);
             $scope.comment = "";
         }
     }
     $scope.postComment = function($home) {
         $scope.comments.splice($home, 1);
     }
 });