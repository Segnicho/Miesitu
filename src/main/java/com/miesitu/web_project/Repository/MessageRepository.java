package com.miesitu.web_project.Repository;

import com.miesitu.web_project.entity.ContactUs;
import com.miesitu.web_project.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<ContactUs, String>{
    ContactUs findBymessageId(String messageId);

    // Page<Product> findProductPaginated(int pageNo, int pageSize);   
   
}