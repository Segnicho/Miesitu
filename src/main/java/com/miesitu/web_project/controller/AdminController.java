package com.miesitu.web_project.controller;


import com.miesitu.web_project.services.AnouncementService;
import com.miesitu.web_project.services.UserService;
import com.miesitu.web_project.services.getLoggedUser;

import java.util.List;

import javax.validation.Valid;

import com.miesitu.web_project.entity.Anouncement;
import com.miesitu.web_project.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class AdminController {
    @Autowired
    private UserService userSaveService;

    @Autowired
    private AnouncementService anouncementSaveService;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/admin")
    public String  adminPage(Model model) {
        return "home";
    }

    //Admin Users Edit, View and Delete

    @GetMapping("/admin/users")
    public String  showUserList(Model model) {
        // Iterable<com.miesitu.web_project.entity.User> userLists  = userSaveService.listAll();
        // model.addAttribute("userLists", userLists);
        // return "user";
        return findPagenated(1,"firstName","asc", model);

    }

    @GetMapping("/admin/newUser")
    public String  showUserForm(Model model) {
        model.addAttribute("user1", new User());
        model.addAttribute("pageTitle", "Add New User");
        return "userForm";

    }

    @PostMapping("/admin/saveUser")
    public String  saveUser(@Valid User user1, @RequestParam(value = "userRl") String role, RedirectAttributes ra, BindingResult error) {
        if(error.hasErrors()){
            ra.addFlashAttribute("er", error.getFieldError());
        }
        try {
            user1.setPassword(encoder.encode(user1.getPassword()));
            userSaveService.saveUser(user1, role);
            ra.addFlashAttribute("message", "User has been saved succesfully.");
        } catch (Exception e) {
            ra.addFlashAttribute("message", "User has been saved succesfully.");
        }
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/editUser/{userId}")
    public String  showEditForm(@PathVariable("userId") long userId, Model model, RedirectAttributes ra) {
        try {
        User user = userSaveService.get(userId);
        model.addAttribute("user1", user);
        model.addAttribute("pageTitle","Edit User");
        return "userForm";

        } catch (UsernameNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/admin/users";
        }
    }


    @GetMapping("/admin/deleteUser/{userId}")
    public String  deleteUser(@PathVariable("userId") long userId,RedirectAttributes ra) {
        try {
        userSaveService.delete(userId);
        ra.addFlashAttribute("message","The user ID:"+userId+"has been deleted.");

    } catch (UsernameNotFoundException e) {
        ra.addFlashAttribute("message", e.getMessage());
    }
    return "redirect:/admin/users";

    }  

    @GetMapping("/admin/user/{pageNo}")
    public String  findPagenated(@PathVariable(value="pageNo") int pageNo,
    @RequestParam("sortField") String sortField, 
    @RequestParam("sortDirection") String sortDirection,
    Model model ) {
        int pageSize = 5;
        Page<User> page = userSaveService.findPaginated(pageNo,pageSize,sortField,sortDirection);
        List<User> userLists = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("userLists", userLists);

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        model.addAttribute("reverseSortDirection", sortDirection.equals("asc") ? ("desc"):("asc"));

        return "user";
    } 

    //Anouncement.


    @GetMapping("/admin/Anouncements")
    public String  anouncementLIst(Model model) {
        try {
            Iterable<Anouncement> anouncement_Lists  = anouncementSaveService.listAll();
            model.addAttribute("anouncementLists", anouncement_Lists);
        } catch (Exception e) {
            model.addAttribute("er", "Error please try again!");
        }
        
        return "anouncements";

    }
    
    @GetMapping("/admin/newAnouncement")
    public String  newAnouncement(Model model) {
        model.addAttribute("anounce", new Anouncement());
        model.addAttribute("pageTitle", "Add New Anouncement");
        return "AnouncementForm";
    }

    @PostMapping("/admin/saveAnouncement")//    Anouncement anouncement
    public String  saveAnouncement(@Valid Anouncement anouncement, RedirectAttributes ra, BindingResult error) {
        if(error.hasErrors()){
            ra.addFlashAttribute("er", error.getFieldError());
            return "redirect:/admin/Anouncements";
        }

        try {
            anouncementSaveService.saveAnouncement(anouncement);
            ra.addFlashAttribute("message", "Anouncement has been Posted Succesfully.");
        } catch (Exception e) {
            ra.addFlashAttribute("er", "Error! - Could not save, Please try again.");
        }
        
        return "redirect:/admin/Anouncements";
    }


    @GetMapping("/admin/editAnouncement/{anouncementId}")
    public String  editAnouncement(@PathVariable("anouncementId") long anouncementId, Model model, RedirectAttributes ra) {
        try {
            Anouncement anouncement = anouncementSaveService.getAnouncements(anouncementId);
            model.addAttribute("anounce", anouncement);
            model.addAttribute("pageTitle","Edit anouncement");
            return "AnouncementForm";
        } catch (UsernameNotFoundException e) {
            ra.addFlashAttribute("er", e.getMessage());
            return "redirect:/admin/Anouncements";
        }

    }

    @GetMapping("/admin/deleteAnouncement/{anouncementId}") //  Anouncement
    public String deleteAnouncement(@PathVariable("anouncementId") long anouncementId,RedirectAttributes ra) {
        try {
            anouncementSaveService.delete(anouncementId);
            ra.addFlashAttribute("message","The Anouncement ID:"+anouncementId+"has been deleted.");

        } catch (UsernameNotFoundException e) {
            ra.addFlashAttribute("er", e.getMessage());
        }
        return "redirect:/admin/Anouncements";

    } 
}

