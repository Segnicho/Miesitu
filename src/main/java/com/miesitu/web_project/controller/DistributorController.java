package com.miesitu.web_project.controller;

import java.util.List;

import javax.validation.Valid;

import com.miesitu.web_project.entity.Consumtion;
import com.miesitu.web_project.entity.Product;
import com.miesitu.web_project.entity.User;
import com.miesitu.web_project.form.ConsumtionForm;
import com.miesitu.web_project.services.ConsumtionService;
import com.miesitu.web_project.services.UserService;
import com.miesitu.web_project.services.approveConsumtionService;
import com.miesitu.web_project.services.getLoggedUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DistributorController {

    @Autowired
    private ConsumtionService consupServ;

    @Autowired
    private UserService userServ;

    @Autowired
    private getLoggedUser logeduserService;

    @Autowired
    private approveConsumtionService approveConsumtionserv;

    @Autowired
    private getLoggedUser LogedUser;

    @ModelAttribute
    public void addAttributes(Model model) {
        User user = LogedUser.get_User();
        if(user != null){
            if(user.getAuthorities().contains("ADMIN")){
                model.addAttribute("user","admin");
            }
            else if(user.getAuthorities().contains("DISTRIBUTER")){
                model.addAttribute("user","dist");
            }else if(user.getAuthorities().contains("ROLE_CUSTOMER")){
                model.addAttribute("user","cust");
            }else{
                model.addAttribute("user",false);
            }
        model.addAttribute("user",false);
        }

        model.addAttribute("user",false);
    }

    @GetMapping("distr/user")
    public String usersInDistributerArea(Model model, Consumtion consumtion, RedirectAttributes ra){
        // consupSer
        User dist;
        try {
            User loggedUser = logeduserService.get_User();
            if(loggedUser != null){
                dist = loggedUser;
            }else{
                return "redirect:/logout";}
        } catch (UsernameNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/consumtion";
        }

        User loggedUser = logeduserService.get_User();
        if( loggedUser != null){
            String area = loggedUser.getArea();
            List<User> users = (List<User>) consupServ.getUsersByArea(area);
            users.remove(dist);
            model.addAttribute("users", users);
            return "usersListinArea";
        }
        return "redirect:/logout";
    }

    @GetMapping("distr/user/{userId}")
    public String consumption(@PathVariable("userId") long userId, Model model, RedirectAttributes ra){
        User user = userServ.get(userId);
        if(user == null){
            ra.addFlashAttribute("message", "user not found");
            return "redirect:/distr/user";
        }
        //User Model Attribute
        model.addAttribute("user", user);

        // try {
        //     User loggedUser = logeduserService.get_User();
        //     if( loggedUser != null){
        //         model.addAttribute("dist", loggedUser);
        //     }else{
        //         return "redirect:/logout";}
        // } catch (UsernameNotFoundException e) {
        //     ra.addFlashAttribute("message", e.getMessage());
        //     return "redirect:/";
        // }

        List<Product> activeProducs = consupServ.activeProducts();
        List<Product> active = consupServ.activeProducts();
        if(activeProducs != null){
            for(Product product : active){
                if(consupServ.checkExistance(user, product)){
                    activeProducs.remove(product);
                }
            }
            model.addAttribute("products", activeProducs);
        }
        return "consumtionDetal";
    }

    @PostMapping("distr/poductSold/{userId}")
    public String approveConsumption(@PathVariable("userId") long userId, @Valid ConsumtionForm form, BindingResult bindingResult, RedirectAttributes ra){
        User user;
        User dist;

        if (bindingResult.hasErrors()){
            ra.addFlashAttribute("message", bindingResult.getFieldError());
            return "redirect:/distr/poductSold/"+userId;
        }

        //User
        user = userServ.get(userId);
        if(user == null){
            ra.addFlashAttribute("message", "user not found");
            return "redirect:/consumtion";
        }

        //Dist
        try {
            User loggedUser = logeduserService.get_User();
            if(loggedUser != null){
                dist = loggedUser;
            }else{
                return "redirect:/logout";}
        } catch (UsernameNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/consumtion";
        }

        if(!approveConsumtionserv.save(form, user, dist)){
            ra.addFlashAttribute("message", "error happened while saving");
            return "redirect:/consumtion";
        }

        ra.addFlashAttribute("success", "user comsumtion updated successfully");
        return "redirect:/distr/poductSold/"+userId;

    }

    
}
