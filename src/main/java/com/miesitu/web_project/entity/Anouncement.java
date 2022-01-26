package com.miesitu.web_project.entity;

import java.sql.Date;
import java.time.Instant;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Anouncement {
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE)
    private long anouncementId;

    private String subject;
    private String message;

    @OneToOne
    private User byUser;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Instant sentDate = Instant.now();

}
