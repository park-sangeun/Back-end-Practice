
// DOMContentLoaded 이벤트가 발생하면 실행될 함수
document.addEventListener('DOMContentLoaded', function () {
    const homeLink = document.querySelector('.nav-link[href="main.html"]');
    const streamingLink = document.querySelector('.nav-link[href="streaming.html"]');
    const locationLink = document.querySelector('.nav-link[href="location.html"]');
    const disasterLink = document.querySelector('.nav-link[href="disaster.html"]');
    const controllerLink = document.querySelector('.nav-link[href="controller.html"]');
    const robotLink = document.querySelector('.nav-link[href="robot.html"]');
    const smallRobotLink = document.querySelector('.nav-link[href="smallrobot.html"]');
    const videoDataLink = document.querySelector('.nav-link[href="videodata.html"]');

    homeLink.addEventListener('click', function (event) {
event.preventDefault();
window.location.href = '/main';
    });

    streamingLink.addEventListener('click', function (event) {
event.preventDefault();
window.location.href = '/streaming';
    });

    locationLink.addEventListener('click', function (event) {
        event.preventDefault();
        window.location.href = '/location';
    });

    disasterLink.addEventListener('click', function (event) {
        event.preventDefault();
        window.location.href = '/disaster';
    });

    controllerLink.addEventListener('click', function (event) {
        event.preventDefault();
        window.location.href = '/controller';
    });

    robotLink.addEventListener('click', function (event) {
        event.preventDefault();
        window.location.href = '/data/mrobot';
    });

    smallRobotLink.addEventListener('click', function (event) {
        event.preventDefault();
        window.location.href = '/data/srobot';
    });

    videoDataLink.addEventListener('click', function (event) {
        event.preventDefault();
        window.location.href = '/video/list';
    });
});

// logout.js 파일에 작성한 코드
function logout() {
    $.ajax({
        url: '/logout',
        method: 'POST',
        success: function(response) {
            window.location.href = '/login.html';
        },
        error: function(xhr, status, error) {
            console.error(error);
        }
    });
}
