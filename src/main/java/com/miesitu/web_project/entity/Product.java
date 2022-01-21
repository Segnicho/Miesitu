package com.miesitu.web_project.entity;
import java.sql.Date;

import javax.persistence.*;


import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    private int sugarPrice;
    private int oilPrice;
    private Date startDate;
    private Date endDate;
    private String productDesc;
    
}