 // Load the IFrame Player API code asynchronously.
  var tag = document.createElement('script');
  tag.src = "https://www.youtube.com/player_api";
  var firstScriptTag = document.getElementsByTagName('script')[0];
  firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

  // Replace the 'ytplayer' element with an <iframe> and
  // YouTube player after the API code downloads.
  
  //change videoId from end of URL to get desired video: https://www.youtube.com/embed/VIDEO_ID
  
  //simple start time conversion from minutes into seconds
  
  var startN=3*60+11;
  
  var player;
  function onYouTubePlayerAPIReady() {
    player = new YT.Player('ytplayer', {
      height: '360',
      width: '640',
      videoId: 'LVpMFdBbzKw?t',
      playlist: '',
      playerVars: {
    	  autoplay: '1',
    	  start: startN,
    	  modestbranding: '1'
    		  },
      events: {
        'onReady': onPlayerReady,
        'onStateChange': onPlayerStateChange,
        'onError': onError,
        'onApiChange': onApiChange,
      }
    });
  }
  
  function onPlayerReady(event) {
      event.target.playVideo();
      //player.mute();
    };
  
  function onError(error){
	  // Update errors on page
	  console.log("Error!");
	};
	
	function onApiChange(event){
	  // Update currently availbe APIs
	  console.log("API Change!");
	};
	
	//convert time from minutes and seconds> seconds
	function timeConvert(min,sec){
		return min*60+sec;
	}
	
	function loadvid(vidId, startS, endS, quality){
    var p1=player.loadVideoById({videoId:vidId,
      startSeconds:startS,
      endSeconds:endS,
      suggestedQuality:quality})
	};
  
	var finish = false;
	function onPlayerStateChange(event) {
	  if (event.data == YT.PlayerState.ENDED) {   
		  loadvid('30Ef7i3qq-U', timeConvert(3,5), timeConvert(5,10),  "480");
       }       
	};
  
	function stopVideo() {
    player.stopVideo();
	};
	