package com.miesitu.web_project.controller;

import com.miesitu.web_project.Repository.MessageRepository;
import com.miesitu.web_project.entity.ContactUs;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;



@Controller
public class MessageController {
    
    @Autowired
    private MessageRepository mesRepo;

    @GetMapping("/contactUs")
    public String message() {
        return "message";

    }

@PostMapping("/contactUs")
public String submitForm(@Valid @ModelAttribute("message") ContactUs message,
        BindingResult bindingResult,RedirectAttributes ra) {
    System.out.println(message);
     
    if (bindingResult.hasErrors()) {       
         
        return "redirect:/contactUs?error=invalid";
    } else {
         mesRepo.save(message);
         ra.addFlashAttribute("message", "Message sent successfull.We will respond soon.");
        return  "redirect:/contactUs?success";

    }
}


}
