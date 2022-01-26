package com.miesitu.web_project.services;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import com.miesitu.web_project.Repository.RoleRepository;
import com.miesitu.web_project.Repository.UserRepository;
import com.miesitu.web_project.entity.Role;
import com.miesitu.web_project.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service

public class UserService {
    @Autowired
    private UserRepository repo;

    @Autowired
    private RoleRepository rolerepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Iterable<User> listAll(){
        System.out.println("\n\n\n");
        System.out.println(repo.findAll());
        return repo.findAll() ;

    }
    public boolean saveUser(User user1, String role) {
        String password = user1.getPassword();
        Collection<Role> O_role = new ArrayList<>();
        if(role == "cust"){
            O_role.add(rolerepo.findByRoleId((long)1));
            // user1.setUserRole(O_role);
        }else if(role == "dist"){
            O_role.add(rolerepo.findByRoleId((long)2));
        }else if(role == "adm"){
            O_role.add(rolerepo.findByRoleId((long)3));
        }else{
            return false;
        }
        if(O_role.isEmpty()){
            return false;
        }else{
            user1.setUserRole(O_role);
        }
        
        user1.setPassword(passwordEncoder.encode(password));
        repo.save(user1);
        return true;

    }
    
    public User get (long userId) throws UsernameNotFoundException {
       Optional<User> result = repo.findById(userId);
       if (result.isPresent()) {
           return result.get();   
            }
        throw new UsernameNotFoundException("cold not found and user by this id" + userId);}

    public void countById(long userId) {
        Long count = repo.countByUserId(userId);
        if (count == null || count==0) {
            throw new UsernameNotFoundException("cold not found and user by this id" + userId);
        }
    }
    public void delete(long userId) {
        repo.deleteById(userId);
    }
    // Page<User> findPaginated(int PageNo, int pageSize);
    public Page<User> findPaginated(int pageNo, int pageSize,String sortField,String sortDirection){
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending():Sort.by(sortField).descending();
        PageRequest pageable = PageRequest.of(pageNo - 1, pageSize,sort);
        return this.repo.findAll(pageable);
    }
}
