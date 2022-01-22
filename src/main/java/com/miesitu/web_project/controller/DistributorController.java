package com.miesitu.web_project.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class DistributorController {

    @GetMapping("/about")
    public String about(){
        return "about";

    }
    
}
