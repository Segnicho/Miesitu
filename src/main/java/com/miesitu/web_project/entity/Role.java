package com.miesitu.web_project.entity;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
