package com.miesitu.web_project.services;

import com.miesitu.web_project.Repository.UserRepository;
import com.miesitu.web_project.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class getLoggedUser {

    @Autowired
    private UserRepository userRepo;
    
    @Bean
    public String get_Username(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
		    return ((UserDetails)principal).getUsername();

        }
		return null;
    }

    @Bean
    public User get_User(){
        String username = get_Username();
        if(username != null){
            return userRepo.findByUsername(username);
        }
        return null;
    }
}
