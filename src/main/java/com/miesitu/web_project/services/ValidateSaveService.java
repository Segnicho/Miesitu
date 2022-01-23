package com.miesitu.web_project.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import com.miesitu.web_project.Repository.CodeRepository;
import com.miesitu.web_project.Repository.RoleRepository;
import com.miesitu.web_project.Repository.UserRepository;
import com.miesitu.web_project.entity.Code;
import com.miesitu.web_project.entity.Role;
import com.miesitu.web_project.entity.User;
import com.miesitu.web_project.form.SignUpForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ValidateSaveService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CodeRepository codeRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private RoleRepository roleRepo;

    Collection<Role> realrole = new ArrayList();



    // userRepo.save(form.toUser(passwordEncoder));

    public User toUser(SignUpForm form, PasswordEncoder passwordEncoder, Code code, Collection<Role> role) {
        return new User(0, form.getFristName() + form.getLastName() + String.valueOf(new Random().nextInt(100)), 
        form.getFristName(), form.getLastName() , form.getEmail(), form.getPhone(), passwordEncoder.encode(form.getPassword()),
        form.getArea(), Instant.now(), role, code);
    }
    public boolean passwordMacher(String pass1, String pass2){
        return pass1.equals(pass2);
    }

    @Transactional
    public boolean doSave(SignUpForm form){
        // System.out.println("\n\nhi\n\n");
        long codeNum = form.getCode();
        // System.out.println("\n\nhi\n");
        System.out.println(form.getCode());
        // System.out.println("\n\n\n\n");
        Code code = codeRepo.findByCode(codeNum);
        if ( code != null){
            // System.out.println("\n\nhi\n\n");

            Collection<Role> role = code.getCodeRole();
            if(role != null)
                for( Role rl : role){
                Role rlRole = roleRepo.findByRoleId(rl.getRoleId());
                if(rlRole != null)
                        realrole.add(rlRole);
                }
            
            User user = toUser(form, passwordEncoder, code, realrole );
            if(user != null){
                // System.out.println("\n\nhi\n\n");
                userRepo.save(user);
                code.setStatus(false);//used code
                return true;
            }
            return false;
        }
        return false;  //call ValidSaveService and to User above, then save to db using above cmd
    }
    
}
