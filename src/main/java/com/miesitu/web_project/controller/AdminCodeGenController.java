package com.miesitu.web_project.controller;

import java.net.http.HttpClient.Redirect;

import javax.validation.Valid;

import com.miesitu.web_project.entity.Code;
import com.miesitu.web_project.form.CodeGeneratorForm;
import com.miesitu.web_project.services.CodeGeneratorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminCodeGenController {

    @Autowired
    CodeGeneratorService codeGenerator;

    @GetMapping("/admin/generateCode")
    public String codeGen(Model model){
        return "codeGenerator";
    }

    @PostMapping("/admin/generateCode") //@ModelAttribute("User") User user
    public String processRegistration(@Valid  CodeGeneratorForm form, BindingResult bindingResult, RedirectAttributes ra) {
        if (bindingResult.hasErrors()) {   
            return "redirect:/admin/generateCode?error=form";
        }else {
            Code savedcode = codeGenerator.generate(form);
            if( savedcode!= null ){
                ra.addFlashAttribute("code", savedcode);
                System.out.println(savedcode.isStatus());
                return "redirect:/admin/generateCode?success";
            }
            return "redirect:/admin/generateCode?error=generator";
        }
    }
    
}
