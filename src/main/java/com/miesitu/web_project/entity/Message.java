package com.miesitu.web_project.entity;

import java.sql.Date;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Message {
    @Id
    private long messageId;

    private String fullname;
    private String email;
    private String message;
    private Date sentDate;
    
    @OneToOne
    private User user;

}
