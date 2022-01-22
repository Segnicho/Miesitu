package com.miesitu.web_project.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.*;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE)
    private long roleId;

    private String name;

    private String description;

    @ManyToMany(mappedBy = "codeRole", cascade = CascadeType.ALL)
    private Collection<Code> code;

    @ManyToMany(mappedBy = "userRole", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<User> user;
}
