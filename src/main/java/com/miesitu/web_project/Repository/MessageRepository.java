package com.miesitu.web_project.Repository;

import com.miesitu.web_project.entity.ContactUs;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<ContactUs, String>{
    ContactUs findBymessageId(String messageId);   
   
}