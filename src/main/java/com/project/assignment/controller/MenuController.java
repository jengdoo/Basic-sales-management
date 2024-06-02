package com.project.assignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class MenuController {
    @GetMapping("/home")
    public String getMenu(){
        return "user/menu";
    }
}
