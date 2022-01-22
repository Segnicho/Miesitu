package com.miesitu.web_project.entity;

import java.sql.Date;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
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
    
    private Date date;

}
