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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long productId;

    private enum PRODUCT {
        SUGAR, OIL
    };
    private PRODUCT productName;
    private String productDesc;
    private int price;
    private Date startDate;
    private Date endDate;
    
}
