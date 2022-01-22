package com.miesitu.web_project.entity;

import java.util.List;
import java.util.Optional;

import com.miesitu.web_project.Repository.ProductRepository;
import com.miesitu.web_project.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

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
    public Product getProductByProductId(long productId){


        Optional<Product> optional = productRepository.findById(productId);
        Product product = null;
        if(optional.isPresent()){

            product = optional.get();
        }
        else{
            throw new RuntimeException("The kind of product you tried to access is not available ");
        }
            return product;
    }

    public void delete(long productId) {
        productRepository.deleteById(productId);
    }

    
 
}
