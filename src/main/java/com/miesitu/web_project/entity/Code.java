package com.miesitu.web_project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Code {
    @Id
    private long code;
    
    public static enum ROLES{
        ADMIN, CUSTOMER, DISTRIBUTER
    }

    private ROLES role;

}
