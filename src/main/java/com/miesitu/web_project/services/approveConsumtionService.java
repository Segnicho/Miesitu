package com.miesitu.web_project.services;

import java.util.Optional;

import com.miesitu.web_project.Repository.ConsumtionRepository;
import com.miesitu.web_project.Repository.ProductRepository;
import com.miesitu.web_project.entity.Consumtion;
import com.miesitu.web_project.entity.Product;
import com.miesitu.web_project.entity.User;
import com.miesitu.web_project.form.ConsumtionForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class approveConsumtionService {
    
    @Autowired
    private ConsumtionRepository consRepo;

    @Autowired
    private ProductRepository prodRepo;

    public Consumtion toConsumtion(float amount, User customer, User dist, Product pro) {
        return new Consumtion(-1, dist, customer, amount , new java.util.Date(), pro);
    }
    
    public boolean save(ConsumtionForm form, User customer, User dist){
        Product product = prodRepo.findById((long) form.getProductId()).get();
        if(product != null){
            Consumtion cons =  toConsumtion(form.getAmount(), customer, dist, product);
            consRepo.save(cons);
            if(cons != null){
                return true;
            }
            
        }
        return false;
    }
}
