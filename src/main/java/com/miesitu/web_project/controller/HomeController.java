package com.miesitu.web_project.controller;

import java.util.Collection;

import com.miesitu.web_project.entity.User;
import com.miesitu.web_project.services.getLoggedUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private getLoggedUser logedUserclass;

    @GetMapping("/")
    public String home(){
        User logedUser = logedUserclass.get_User();
        if(logedUser != null){
            Collection<? extends GrantedAuthority> userRole = logedUser.getAuthorities();
            System.out.println("\n\n\n\n");
            System.out.println(userRole);
            System.out.println("\n\n\n\n");
            if(SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString().contains("ROLE_ADMIN")){
                System.out.println("\n\n\n\n");
                return "redirect:/admin";
            }else if(SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString().contains("ROLE_DISTRIBUTER")){
                System.out.println("\n\n\n\n");
                return "redirect:/distr";
            }else if(SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString().contains("ROLE_CUSTOMER")){
                System.out.println("\n\n\n\n");
                return "redirect:/cust";
            }
        }
        return "home";
    }
    
}
