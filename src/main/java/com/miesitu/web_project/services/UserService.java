package com.miesitu.web_project.services;


import java.util.Optional;

import com.miesitu.web_project.Repository.UserRepository;
import com.miesitu.web_project.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service

public class UserService {
    @Autowired
    private UserRepository repo;

    public Iterable<User> listAll(){
        System.out.println("\n\n\n");
        System.out.println(repo.findAll());
        return repo.findAll() ;

    }
    public void saveUser(User user1) {
        repo.save(user1);

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
    public Page<User> findPaginated(int pageNo, int pageSize){
        PageRequest pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.repo.findAll(pageable);
    }
}
