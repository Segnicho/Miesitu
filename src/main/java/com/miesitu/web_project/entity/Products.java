package com.miesitu.web_project.entity;

import java.sql.Date;
import java.time.Instant;

import javax.persistence.*;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    
    private String productName;
    
    private String productDesc;

    private Instant Date = Instant.now();
    
}