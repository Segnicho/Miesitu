package com.miesitu.web_project.services;

import java.util.Date;
import java.util.List;

import com.miesitu.web_project.Repository.ConsumtionRepository;
import com.miesitu.web_project.Repository.ProductRepository;
import com.miesitu.web_project.Repository.UserRepository;
import com.miesitu.web_project.entity.Consumtion;
import com.miesitu.web_project.entity.Product;
import com.miesitu.web_project.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumtionService {
    
    @Autowired
    private ConsumtionRepository consRepo; 

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private getLoggedUser getUser;

    @Autowired
    private ProductRepository productRepo;

    public void saveConsumtion(Consumtion consumtion) {
        consumtion.setDistributer( getUser.get_User());
        consRepo.save(consumtion);
    }

    public Iterable<Consumtion> getConsumtion(Consumtion consumtion){
        return consRepo.findAll();
    }

    public Iterable<User> getUsersByArea(String area){
        return userRepo.findByArea(area);
    }
    public List<Product> activeProducts(){
        return productRepo.findByEndDateAfter((new Date()));
    }

    public boolean checkExistance(long user, long prod){
        if(consRepo.checkExistance(user, prod).isEmpty()){
            return false;
        }
        return true;
    }

}
