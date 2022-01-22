package com.miesitu.web_project.controller;

import javax.validation.Valid;

import com.miesitu.web_project.form.CodeGeneratorForm;
import com.miesitu.web_project.services.CodeGeneratorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminCodeGenController {

    @Autowired
    CodeGeneratorService codeGenerator;

    @GetMapping("/admin/generateCode")
    public String codeGen(){
        return "codeGenerator";
    }

    @PostMapping("/admin/generateCode") //@ModelAttribute("User") User user
    public String processRegistration(@Valid  CodeGeneratorForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {   
            return "redirect:/admin/generateCode?error=form";
        }else {
            System.out.println(form);
            if(codeGenerator.generate(form)){
                return "redirect:/admin/generateCode?success";
            }
            return "redirect:/admin/generateCode?error=generator";
        }
    }
    
}
