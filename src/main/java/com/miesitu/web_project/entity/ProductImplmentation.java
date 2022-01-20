package com.miesitu.web_project.entity;

import java.util.List;

import com.miesitu.web_project.Repository.ProductRepository;
import com.miesitu.web_project.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImplmentation implements ProductService{


    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts(){

        return productRepository.findAll();

    }
    @Override
    public void addProduct(Product product){

        this.productRepository.save(product);
    }
    @Override
    public Product getProductByIdProduct(long ProductId) {
        // TODO Auto-generated method stub
        return null;
    // 
}
  

    
}
