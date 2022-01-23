package com.miesitu.web_project.entity;

import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Consumtion {
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE)
    private long ConsumtionId;

    @OneToOne
    @NotNull
    private User distributer;

    @OneToOne
    @NotNull
    private User customer;

    @NotNull
    private float amount;
    
    private java.util.Date date;

    @OneToOne
    private Product product;

}
