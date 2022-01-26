package com.miesitu.web_project.Repository;

import com.miesitu.web_project.entity.ContactUs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<ContactUs, String>{
    ContactUs findBymessageId(Long messageId);
    ContactUs findByEmail(String email);
    


    // Page<Product> findProductPaginated(int pageNo, int pageSize);   
   
}