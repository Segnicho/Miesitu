package com.miesitu.web_project.entity;


import java.time.Instant;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

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
    @NotEmpty(message = "message is empty! can not send anouncement with no content")
    private String message;

    @OneToOne
    private User byUser;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Instant sentDate = Instant.now();

}
