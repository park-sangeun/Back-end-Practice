var modelRobotBtn = document.getElementById('modelRobotBtn');
var smallRobotBtn = document.getElementById('smallRobotBtn');
var videoPlayer = document.getElementById('videoPlayer');
    
// 모체로봇 버튼 클릭 시 모체로봇 영상을 보여줍니다.
modelRobotBtn.addEventListener('click', function() {
  videoPlayer.src = 'https://www.youtube.com/watch?v=PrqwxkBB0DA';
});
    
// 소형로봇 버튼 클릭 시 소형로봇 영상을 보여줍니다.
smallRobotBtn.addEventListener('click', function() {
  videoPlayer.src = 'https://www.youtube.com/embed/VIDEO_ID?rel=0';
});