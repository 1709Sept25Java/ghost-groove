
var app = angular.module('GhostApp', []);


app.run(function () {
  var tag = document.createElement('script');
  tag.src = "http://www.youtube.com/iframe_api";
  var scriptTag = document.getElementsByTagName('script')[0];
  scriptTag.parentNode.insertBefore(tag, scriptTag);
});


app.config( function ($httpProvider) {
  delete $httpProvider.defaults.headers.common['X-Requested-With'];
});


app.service('VideosService', ['$window', '$rootScope', '$log', function ($window, $rootScope, $log) {

  var service = this;

  var youtube = {
    ready: false,
    player: null,
    playerId: null,
    videoId: null,
    videoTitle: null,
    playerHeight: '500',
    playerWidth: '800',
    state: ' '
  };
  var results = [];
  
     
  var nextPlaylist = [
    {id: 'kRJuY6ZDLPo', title: 'La Roux - In for the Kill (Twelves Remix)'},
    {id: '45YSGFctLws', title: 'Shout Out Louds - Illusions'},
    {id: 'ktoaj1IpTbw', title: 'CHVRCHES - Gun'},
    {id: '8Zh0tY2NfLs', title: 'N.E.R.D. ft. Nelly Furtado - Hot N\' Fun (Boys Noize Remix) HQ'},
    {id: 'zwJPcRtbzDk', title: 'Daft Punk - Human After All (SebastiAn Remix)'},
    {id: 'sEwM6ERq0gc', title: 'HAIM - Forever (Official Music Video)'},
    {id: 'fTK4XTvZWmk', title: 'Housse De Racket â˜â˜€â˜ Apocalypso'}
  ];
  var previous = [
    {id: 'XKa7Ywiv734', title: '[OFFICIAL HD] Daft Punk - Give Life Back To Music (feat. Nile Rodgers)'}
  ];
  
  //Here is http get request, not sure if I am doing it right
  function studentController($scope,$http) {
	  
	  var url = "http://localhost:8082/GhostGroove/playlist/allPlaylists";
      $http.get(url).then( function(response) {
         $scope.nextPlaylist = response.data;
         $log.info("You data is ready");
      })};
      //hoping to return the json data and id and title to nextPlaylist
      
      
   
  $window.onYouTubeIframeAPIReady = function () {
    $log.info('Youtube is ready');
    youtube.ready = true;
    service.bindPlayer('placeholder');
    service.loadPlayer();
    $rootScope.$apply();
  };

  function onYoutubeReady (event) {
    $log.info('YouTube Player is ready');
    youtube.player.cueVideoById(previous[0].id);
    youtube.videoId = previous[0].id;
    youtube.videoTitle = previous[0].title;
  }

  function onYoutubeStateChange (event) {
    if (event.data == YT.PlayerState.PLAYING) {
      youtube.state = 'Playing';
    } else if (event.data == YT.PlayerState.PAUSED) {
      youtube.state = 'Paused';
    } else if (event.data == YT.PlayerState.ENDED) {
      youtube.state = 'Ended';
      service.launchPlayer(nextPlaylist[0].id, nextPlaylist[0].title);
      service.archiveVideo(nextPlaylist[0].id, nextPlaylist[0].title);
      service.deleteVideo(nextPlaylist, nextPlaylist[0].id);
    }
    $rootScope.$apply();
  }

  this.bindPlayer = function (elementId) {
    $log.info('Binding to ' + elementId);
    youtube.playerId = elementId;
  };

  this.createPlayer = function () {
    $log.info('Creating a new Youtube player for DOM id ' + youtube.playerId + ' and video ' + youtube.videoId);
    return new YT.Player(youtube.playerId, {
      height: youtube.playerHeight,
      width: youtube.playerWidth,
      playerVars: {
        rel: 0,
        showinfo: 0
      },
      events: {
        'onReady': onYoutubeReady,
        'onStateChange': onYoutubeStateChange
      }
    });
  };

  this.loadPlayer = function () {
    if (youtube.ready && youtube.playerId) {
      if (youtube.player) {
        youtube.player.destroy();
      }
      youtube.player = service.createPlayer();
    }
  };

  this.launchPlayer = function (id, title) {
    youtube.player.loadVideoById(id);
    youtube.videoId = id;
    youtube.videoTitle = title;
    return youtube;
  }

  this.listResults = function (data) {
    results.length = 0;
    for (var i = data.items.length - 1; i >= 0; i--) {
      results.push({
        id: data.items[i].id.videoId,
        title: data.items[i].snippet.title,
        description: data.items[i].snippet.description,
        thumbnail: data.items[i].snippet.thumbnails.default.url,
        author: data.items[i].snippet.channelTitle
      });
    }
    return results;
  }

  this.queueVideo = function (id, title) {
    nextPlaylist.push({
      id: id,
      title: title
    });
    return nextPlaylist;
  };

  this.archiveVideo = function (id, title) {
    previous.unshift({
      id: id,
      title: title
    });
    return previous;
  };

  this.deleteVideo = function (list, id) {
    for (var i = list.length - 1; i >= 0; i--) {
      if (list[i].id === id) {
        list.splice(i, 1);
        break;
      }
    }
  };

  this.getYoutube = function () {
    return youtube;
  };

  this.getResults = function () {
    return results;
  };

  this.getUpcoming = function () {
    return nextPlaylist;
  };

  this.getHistory = function () {
    return previous;
  };

}]);



app.controller('VideosController', function ($scope, $http, $log, VideosService) {

    init();

    function init() {
      $scope.youtube = VideosService.getYoutube();
      $scope.results = VideosService.getResults();
      $scope.nextPlaylist = VideosService.getNextPlaylist();
      $scope.previous = VideosService.getPrevious();
      $scope.playlist = true;
    }

    $scope.launch = function (id, title) {
      VideosService.launchPlayer(id, title);
      VideosService.archiveVideo(id, title);
      VideosService.deleteVideo($scope.nextPlaylist, id);
      $log.info('Launched id:' + id + ' and title:' + title);
    };

    $scope.queue = function (id, title) {
      VideosService.queueVideo(id, title);
      VideosService.deleteVideo($scope.previous, id);
      $log.info('Queued id:' + id + ' and title:' + title);
    };

    $scope.delete = function (list, id) {
      VideosService.deleteVideo(list, id);
    };

    $scope.search = function () {
      $http.get('https://www.googleapis.com/youtube/v3/search', {
        params: {
          key: 'AIzaSyB4OKA0Ry20TPsYIeCnNxN7zgbcrppEdf4',
          type: 'video',
          maxResults: '8',
          part: 'id,snippet',
          fields: 'items/id,items/snippet/title,items/snippet/description,items/snippet/thumbnails/default,items/snippet/channelTitle',
          q: this.query
        }
      })
      .success( function (data) {
        VideosService.listResults(data);
        $log.info(data);
      })
      .error( function () {
        $log.info('Search error');
      });
    }

    $scope.tabulate = function (state) {
      $scope.playlist = state;
    }
});

/*Source:
 * Tutorial: "Make a YouTube app with AngularJS and Onsen UI"
 * Author:Fran Dios
 * Website: https://medium.com/the-web-tub/make-a-youtube-app-with-angularjs-and-onsen-ui-c836e7e046e0
 */



