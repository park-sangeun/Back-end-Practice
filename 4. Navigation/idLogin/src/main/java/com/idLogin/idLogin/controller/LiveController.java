package com.idLogin.idLogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LiveController {
    @GetMapping("/live")
    public String liveform(){
        return "disaster";
    }
}
