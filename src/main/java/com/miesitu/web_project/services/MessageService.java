package com.miesitu.web_project.services;


import com.miesitu.web_project.Repository.MessageRepository;
import com.miesitu.web_project.entity.ContactUs;
// import com.miesitu.web_project.Repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    MessageRepository repo;
   
    public Page<ContactUs> findMessagePaginated(int pageNo, int pageSize){
        PageRequest pageable = PageRequest.of(pageNo - 1, pageSize);
        return this.repo.findAll(pageable);
    }
}