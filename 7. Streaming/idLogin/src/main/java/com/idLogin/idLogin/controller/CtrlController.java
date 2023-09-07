package com.idLogin.idLogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/control")
public class CtrlController {
    @GetMapping("/controller")
    public String ctrl(){
        return "controller";
    }

    // Raspberry Pi GPIO 핀 설정 및 GPIO 라이브러리 초기화
    private static final int IN1 = 17;
    private static final int IN2 = 18;
    private static final int IN3 = 22;
    private static final int IN4 = 23;

    private boolean isMoving = false; // 로봇의 움직임 상태를 추적하는 변수
    public CtrlController() {
        // GPIO 초기화 로직
    }

    @PostMapping("/{direction}")
    public String control(@PathVariable String direction) {
        if ("forward".equals(direction)) {
            // 전진 로직 구현
            isMoving = true;
            // GPIO 핀 제어 코드
        } else if ("backward".equals(direction)) {
            // 후진 로직 구현
            isMoving = true;
            // GPIO 핀 제어 코드
        } else if ("left".equals(direction)) {
            // 좌회전 로직 구현
            isMoving = true;
            // GPIO 핀 제어 코드
        } else if ("right".equals(direction)) {
            // 우회전 로직 구현
            isMoving = true;
            // GPIO 핀 제어 코드
        } else if ("stop".equals(direction)) {
            // 정지 로직 구현
            isMoving = false;
            // GPIO 핀 제어 코드
        } else {
            // 유효하지 않은 명령 처리 (필요에 따라 추가)
        }

        return "Success";
    }
}
