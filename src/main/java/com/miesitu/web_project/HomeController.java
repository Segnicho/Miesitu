package com.miesitu.web_project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }
    
}
