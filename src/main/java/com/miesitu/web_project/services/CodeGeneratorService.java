package com.miesitu.web_project.services;

import java.util.ArrayList;
import java.util.Collection;

import com.miesitu.web_project.Repository.CodeRepository;
import com.miesitu.web_project.Repository.RoleRepository;
import com.miesitu.web_project.entity.Code;
import com.miesitu.web_project.entity.Role;
import com.miesitu.web_project.form.CodeGeneratorForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeGeneratorService {
    
    @Autowired
    private RoleRepository roleRepo;
    @Autowired
    private CodeRepository codeRepo;

    private Collection<Role> roles = new ArrayList<Role>();

    public Code generate(CodeGeneratorForm form) {
        Code saved = null;
        System.out.print(form);
        if (form.getId1() == 1){
            roles.add(roleRepo.findByRoleId(1));
        }
        if (form.getId2() == 2){
            roles.add(roleRepo.findByRoleId(2));
        }
        if (form.getId3() == 3){
            roles.add(roleRepo.findByRoleId(3));
        }
        if(roles.isEmpty()){
            return null;
        }
        // codeRepo.save(new Code(1, roles));
        // roles.clear();
        // return true;


        int min = 1000;
        int max = 1000000;
        int counter = 0;

        while(counter < 100){
            if (counter >= 100) break;
            int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);

            if(codeRepo.findByCode(random_int) == null ){
                saved = new Code(random_int, true, roles);
                codeRepo.save(saved);
                roles.clear();
                break;
            }
            counter = counter +1;
            System.out.print("\n\n");
            System.out.print(counter);
            System.out.print("\n\n");
            System.out.print(counter);

        }
        return saved;
    }

    public Collection<Code> codeLists(){
        return codeRepo.findAllByStatus(true);
    }
}
