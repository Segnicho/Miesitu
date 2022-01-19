package com.miesitu.web_project.Repository;

import com.miesitu.web_project.entity.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
    
}
