package com.miesitu.web_project.entity;
import java.sql.Date;

import javax.persistence.*;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class ProductCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartId;
    
    @ManyToOne
    private Products product;
    
    private int price;
    private Date startDate;
    private Date endDate;
    
}