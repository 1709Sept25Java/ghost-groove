app.controller('youtubeController', function($scope,$http,$filter) {
    $scope.youtubeData = [];
    $scope.nextPage = "";
    $scope.youtubeSearchText = "";
    $scope.getYoutubeData = function(searchText){
 	   console.log("SearchText= "+ searchText);
      $scope.data=  $http.get('https://www.googleapis.com/youtube/v3/search', {
            params: {
                key: "AIzaSyBy-yDdN5eZLfBiO7gT0tZ447APW0Vb0LI",
                type: 'video',
                maxResults: '12',
                pageToken: $scope.nextPage ? $scope.nextPage : '',
                part: 'id,snippet',
                fields: 'items/id,items/snippet/title,items/snippet/description,items/snippet/thumbnails/default,items/snippet/channelTitle,nextPageToken,prevPageToken',
                q: searchText
            }
        }).then(function (data) {
            console.log(data.data);
            console.log(data.data.items);
            if (data.data.items.length === 0) {
                $scope.youtubeData = 'No results were found!';
            }
            $scope.youtubeSearchText = searchText;
            $scope.youtubeData = data.data.items;
            $scope.nextPageToken = data.data.nextPageToken;
            $scope.prevPageToken = data.data.prevPageToken;
        }).catch(function() {
        	  // handle errors
        	console.log('caught');
        	});
    };

    $scope.checkDataLength = function(data){
        return (data.length >=1);
    };

    $scope.callNextPageFn = function(nextPage){
        $scope.nextPage = nextPage;
        $scope.getYoutubeData($scope.youtubeSearchText);
    };
});