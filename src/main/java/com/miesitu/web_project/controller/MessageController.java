package com.miesitu.web_project.controller;

import com.miesitu.web_project.Repository.MessageRepository;
import com.miesitu.web_project.entity.ContactUs;
import com.miesitu.web_project.entity.Product;
import com.miesitu.web_project.services.MessageService;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;



@Controller
public class MessageController {
    
    @Autowired
    private MessageRepository mesRepo;

    @Autowired
    private MessageService mesServ;
    

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

    @GetMapping("admin/messageList")
    public String productList(Model model){
        return findMessagePagenated(1, model);
    }

    @GetMapping("admin/messageList/{pageNo}")
    public String  findMessagePagenated(@PathVariable(value="pageNo") int pageNo, Model model ) {
        int pageSize = 10;
        Page<ContactUs> page = mesServ.findMessagePaginated(pageNo,pageSize);
        List<ContactUs> messagelist = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("messagelist", messagelist);
        return "messageList";  //correct the html
    }

}
