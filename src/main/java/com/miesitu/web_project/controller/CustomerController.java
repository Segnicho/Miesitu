package com.miesitu.web_project.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class CustomerController {


    @Autowired
    private UserViewPageController commonController;

    @Autowired
    private ProductController proController;

    @GetMapping("/cust")
    public String custHome(Model model){
        return "home";
    }

    @GetMapping("cust/products")
    public String userProductList(Model model){
        return proController.productList(model);
    }

    @GetMapping("/cust/contact")
    public String custcontact(Model model){
        return "message";
    }

    @GetMapping("/cust/about")
    public String custAbout(Model model){
        return "about";
    }

    @GetMapping("/cust/anouncements")
    public String custAnounce(Model model){
        return commonController.userViewAnouncement(model);
    }
    @GetMapping("/cust/anouncements/{pageNo}")
    public String custAnounce(@PathVariable(value="pageNo") int pageNo, Model model){
        return commonController.userViewAnouncement(pageNo, model);
    }

    
}
