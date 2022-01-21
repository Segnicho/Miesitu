package com.miesitu.web_project.Repository;

import com.miesitu.web_project.entity.ContactUs;
import com.miesitu.web_project.entity.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<ContactUs, String>{
    User findBymessageId(String messageId);   
   
}