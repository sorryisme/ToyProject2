package com.account.sorry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String moveIndex(){
        return "/index";
    }

    @GetMapping("/auth/login")
    public String moveLogin(){
        return "/auth/login";
    }

    @GetMapping("/table")
    public String moveAccountPage(){
        return "/table";
    }
}
