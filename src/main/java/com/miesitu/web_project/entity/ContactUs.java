package com.miesitu.web_project.entity;

import java.time.Instant;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ContactUs {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long messageId;

    @NotBlank
    private String fullname;

    @NotBlank
    @Email(message = "Please enter a valid e-mail address")
    private String email;

    // @NotBlank(message = "Please enter a message")
    private String UserMessage;

    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Instant sentDate = Instant.now();
    
    @OneToOne
    private User user;

}
