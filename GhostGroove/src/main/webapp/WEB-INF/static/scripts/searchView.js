var app = angular.module('instantYoutubeSearch', ['ui.router']);

app.config(function($stateProvider,$urlRouterProvider){
    $urlRouterProvider.otherwise("searchView");
    $stateProvider.state("searchView",{
        url:"/searchView",
        templateUrl:"/GhostGroove/views/searchView.html"
    });
});

var videotitle; var videoid;
function getVideoTitle(vid){
	videotitle=vid;
	videoid=document.getElementById(vid).innerHTML;
	console.log("Videoid: " + videoid);
	console.log("Title: " + videotitle);
	
	document.getElementById("selectedId").innerHTML="Video Id: "+videoid;
	document.getElementById("selectedTitle").innerHTML="Video Title: "+videotitle;
};
