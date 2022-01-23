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
public class CustomerController {


    @Autowired
    private ConsumtionService consupServ;

    @Autowired
    private UserViewPageController commonController;

    @Autowired
    private ProductController proController;


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

    @GetMapping("/cust")
    public String custHome(Model model){
        return commonController.userViewAnouncement(model);
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

    
}
