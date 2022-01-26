package com.miesitu.web_project.entity;
import java.util.*;


import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Data
@NoArgsConstructor
@Entity
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    
}
