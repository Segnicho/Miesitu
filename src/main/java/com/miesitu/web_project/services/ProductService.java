package com.miesitu.web_project.services;

import java.util.List;

// import com.miesitu.web_project.Repository.ProductRepository;
import com.miesitu.web_project.entity.Product;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    List<Product> getAllProducts();
    
    void addProduct(Product product);
    Product getProductByProductId(long ProductId);

}