package com.miesitu.web_project.entity;

import java.sql.Date;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Consumtion {
    @Id
    private long ConsumtionId;

    @OneToOne
    private User distributer;

    @OneToOne
    private User customer;

    @OneToOne
    private Product product;
    
    private Date date;

}
