package com.miesitu.web_project.data;

import com.miesitu.web_project.Repository.RoleRepository;
import com.miesitu.web_project.Repository.UserRepository;
import com.miesitu.web_project.entity.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Data {
    @Autowired
    private RoleRepository roleRepo;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        roleRepo.save(new Role(1,"ROLE_ADMIN", "ROLE_ADMIN", null, null));
        roleRepo.save(new Role(2, "ROLE_DISTRIBUTER", "ROLE_DISTRIBUTER", null, null));
        roleRepo.save(new Role(3, "ROLE_CUSTOMER", "ROLE_CUSTOMER", null, null));

    }
}
