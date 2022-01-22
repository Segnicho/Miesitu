package com.miesitu.web_project.controller;

import javax.validation.Valid;

import com.miesitu.web_project.entity.Consumtion;
import com.miesitu.web_project.entity.User;
import com.miesitu.web_project.services.ConsumtionService;
import com.miesitu.web_project.services.getLoggedUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class DistributorController {

    @Autowired
    private ConsumtionService consupServ;

    @Autowired
    private getLoggedUser logeduserService;


    @GetMapping("distr/poductSold")
    public String consumption(Model model, Consumtion consumtion){
        // consupSer
        User loggedUser = logeduserService.get_User();
        if( loggedUser != null){
            String area = loggedUser.getArea();
            
            model.addAttribute("users", consupServ.getUsersByArea(area));
            return "consumtion";
        }
        return "redirect:/logout";

    }

    @PostMapping("distr/poductSold")
    public String approveConsumption(
        Model model, @Valid @ModelAttribute("Consumtion") Consumtion consumtion,
         BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "redirect:/logout";
        }
        return "consumtion";
    }
    
}
