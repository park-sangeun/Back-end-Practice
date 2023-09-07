let isMoving = false; // 현재 로봇이 움직이는지 여부를 나타내는 변수

function sendCommand(direction) {
    $.post('/control/' + direction, function(data) {
        // 제어 성공한 경우 여기에서 추가 작업을 수행할 수 있습니다.
        console.log('Control successful: ' + data);
    }).fail(function() {
        // 제어 실패한 경우 여기에서 추가 작업을 수행할 수 있습니다.
        console.error('Control failed');
    });
}

function startMoving(direction) {
    if (!isMoving) {
        sendCommand(direction);
        isMoving = true;
    }
}

function stopMoving() {
    if (isMoving) {
        sendCommand('stop'); // 'stop'은 로봇을 정지시키는 명령으로 백엔드에서 처리해야 합니다.
        isMoving = false;
    }
}

// 키보드 입력을 처리하는 함수
function handleKeydown(event) {
    if (event.key === 'ArrowUp') {
        startMoving('forward');
    } else if (event.key === 'ArrowDown') {
        startMoving('backward');
    } else if (event.key === 'ArrowLeft') {
        startMoving('left');
    } else if (event.key === 'ArrowRight') {
        startMoving('right');
    }
}

function handleKeyup(event) {
    if (event.key === 'ArrowUp' || event.key === 'ArrowDown' || event.key === 'ArrowLeft' || event.key === 'ArrowRight') {
        stopMoving();
    }
}
