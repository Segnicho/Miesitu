// package com.miesitu.web_project.services;
// import com.miesitu.web_project.Repository.CodeRepository;
// import com.miesitu.web_project.entity.Code;
// import com.miesitu.web_project.entity.Role;

// import org.springframework.context.annotation.Bean;
// import org.springframework.stereotype.Service;

// @Service
// public class VarifyCodeService {
//     CodeRepository coderepo;
    
//     @Bean
//     public Code getCode(long code){
//         if (coderepo.findByCode(code) != null){
//             return coderepo.findByCode(code);
//         }
//         return null;
//     }

//     @Bean
//     public List<Role> getRole(long code){
//         if(getCode(code) != null){
//             return getCode(code).getRole();
//         }
//     }
// }
