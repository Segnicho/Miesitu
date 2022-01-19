package com.miesitu.web_project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    
    private long userId;
    private String fristName;
    private String lastName;
    private String email;
    private int phone;
    private String password;
    private String area;

    @OneToOne
    private Code code;


}
