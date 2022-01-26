package com.miesitu.web_project.controller;

import java.util.Collection;
import java.util.List;

import com.miesitu.web_project.Repository.ConsumtionRepository;
import com.miesitu.web_project.Repository.ProductRepository;
import com.miesitu.web_project.entity.Consumtion;
import com.miesitu.web_project.entity.User;
import com.miesitu.web_project.services.getLoggedUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private getLoggedUser logedUserclass;

    @Autowired
    private ProductRepository proRepo;

    @Autowired
    private ConsumtionRepository consRepo;


    @GetMapping("/")
    public String home(Model model){
        User logedUser = logedUserclass.get_User();
        long product_number = consRepo.count();
        List<Consumtion> consum = consRepo.findAll();
        int price =0;
        for (Consumtion con : consum) {
            price = price + con.getProduct().getPrice();
        }
        model.addAttribute("product_number", product_number);
        model.addAttribute("price", price);
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
    @GetMapping("/about")
    public String about(Model model){
        
        return "about";
    }
    
}
