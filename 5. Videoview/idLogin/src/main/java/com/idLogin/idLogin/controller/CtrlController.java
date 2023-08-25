package com.idLogin.idLogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CtrlController {
    @GetMapping("/controller")
    public String ctrl(){
        return "controller";
    }
}
