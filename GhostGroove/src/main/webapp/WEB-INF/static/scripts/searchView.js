var app = angular.module('instantYoutubeSearch', ['ui.router']);

app.config(function($stateProvider,$urlRouterProvider){
    $urlRouterProvider.otherwise("searchView");
    $stateProvider.state("searchView",{
        url:"/searchView",
        templateUrl:"/GhostGroove/views/searchView.html"
    });
});