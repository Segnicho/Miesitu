package com.miesitu.web_project.controller;

import com.miesitu.web_project.entity.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class SignUpController{

    @GetMapping("/signup")
    public String signup() {
        return "/signup";

    }

    @PostMapping("/signup")
    public String postMethodName(@RequestBody User entity) {
        //TODO: process POST request
        
        return "/signup";

    }
    

}
