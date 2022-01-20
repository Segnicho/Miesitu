package com.miesitu.web_project.entity;

import java.sql.Date;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    private long productId;
    private String productName;
    private int productPrice;
    private String productDesc;
    private Date startDate;
    private Date endDate;

}
