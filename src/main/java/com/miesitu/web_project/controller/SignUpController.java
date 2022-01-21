package com.miesitu.web_project.controller;

import com.miesitu.web_project.entity.User;

import javax.validation.Valid;


// import com.miesitu.web_project.services.VarifyCodeService;
// import com.miesitu.web_project.services.ValidateSaveService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/signup")
public class SignUpController{


    // private UserRepository userRepo;
    // private PasswordEncoder passwordEncoder;
    // private VarifyCodeService varifyCode;
    // private ValidateSaveService valsave;

    @GetMapping
    public String signup() {
        return "signup";

    }

    @PostMapping
    public String processRegistration(@Valid @ModelAttribute("User") User user) {
        // if(varifyCode.getCode(user.getUserId()) != null){
            
        //     return "redirect:/login";
        // }else{
        //     return "redirect:/signup?error=invalidcode"
        // }
            return "redirect:/login";

    }
    
    

}
