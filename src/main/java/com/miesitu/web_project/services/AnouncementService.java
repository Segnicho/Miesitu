package com.miesitu.web_project.services;

import java.util.Optional;

import com.miesitu.web_project.Repository.AnouncementRepository;
import com.miesitu.web_project.Repository.UserRepository;
import com.miesitu.web_project.entity.Anouncement;
import com.miesitu.web_project.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
    
    
@Service
public class AnouncementService {

    @Autowired
    private AnouncementRepository anouncementRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private getLoggedUser logedUser;
    

    public Iterable<Anouncement> listAll(){
        System.out.println("\n\n\n");
        System.out.println(anouncementRepo.findAll());
        return anouncementRepo.findAll() ;
    }

    public void saveAnouncement(Anouncement anouncement) { //save Anouncement
        User user = logedUser.get_User();
        if(user != null){
            anouncement.setByUser(user);
        }
        anouncementRepo.save(anouncement);
    }

    public Anouncement getAnouncements(long anouncementId) throws UsernameNotFoundException {
        Optional<Anouncement> A_result = anouncementRepo.findById(anouncementId);
        if (A_result.isPresent()) {
            return A_result.get();   
        }
        throw new UsernameNotFoundException("cold not found and user by this id" + anouncementId);}

    public void countById(long anouncementId) {
        Long count = anouncementRepo.countByAnouncementId(anouncementId);
        if (count == null || count==0) {
            throw new UsernameNotFoundException("cold not found and user by this id" + anouncementId);
        }
    }
    public void delete(long anouncementId) {
        anouncementRepo.deleteById(anouncementId);
    }
}
