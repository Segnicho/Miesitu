package com.miesitu.web_project.controller;

import com.miesitu.web_project.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class SignUpController{

    @GetMapping("/signup")
    public String signup() {
        return "signup";

    }

    @PostMapping("/signup")
    public String postMethodName(
        @ModelAttribute("User") User user) {
        System.out.println();        
        return "signup";
    }

    
    

}
