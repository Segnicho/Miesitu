package com.miesitu.web_project.entity;

import java.sql.Date;

import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Anouncement {
    @Id
    private long anouncementId;

    private String subject;
    private String message;

    @OneToOne
    private User to;
    
    private Date sentDate;

}
