package com.miesitu.web_project.controller;

import com.miesitu.web_project.Repository.UserRepository;
import com.miesitu.web_project.entity.User;
import com.miesitu.web_project.form.SignUpForm;

import java.text.Normalizer.Form;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


// import com.miesitu.web_project.services.VarifyCodeService;
import com.miesitu.web_project.services.ValidateSaveService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/signup")
public class SignUpController{

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    // private VarifyCodeService varifyCode;
    @Autowired
    private ValidateSaveService valsave;

    @GetMapping
    public String signup(HttpServletRequest request, Model model, SignUpForm form, RedirectAttributes reatr) {
        try {
            Map<String, ?> inputFlash = RequestContextUtils.getInputFlashMap(request);
            if(inputFlash.get("form") != null){
                model.addAttribute("form", inputFlash.get("form"));//er
            }else{
                model.addAttribute("form", form);
            }
        } catch (NullPointerException e) {
            model.addAttribute("form", form);
        }

        
        return "signup";
    
    }

    @PostMapping //@ModelAttribute("User") User user
    public String processRegistration(@Valid SignUpForm form, BindingResult bindingResult, Model model, RedirectAttributes errmsg ) {
        errmsg.addFlashAttribute("form", form);
        if (bindingResult.hasErrors()) {   
            errmsg.addFlashAttribute("er", bindingResult.getFieldError().getDefaultMessage());
            return "redirect:signup?error";
            
        }else {
            // System.out.println(form);
            if(!valsave.passwordMacher(form.getPassword(), form.getConfirm_Password())){
                errmsg.addFlashAttribute("er", "Password Does Not Match");
                return "redirect:/signup?error";
            }
            if(valsave.userEmailExists(form.getEmail())){
                errmsg.addFlashAttribute("er", "Email Already exists");
                return "redirect:/signup?error";
            }
            if(valsave.userPhoneExists(form.getPhone())){
                errmsg.addFlashAttribute("er", "Phone number Already Exists");
                return "redirect:/signup?error";
            }
            if(valsave.doSave(form)){
                errmsg.addFlashAttribute("message", "Signup Successfull. Please Log In");
                return "redirect:login?signupsuccess";
            }   
    

}
