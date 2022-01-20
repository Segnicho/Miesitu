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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {
    @Id
    private long roleId;

    private String roleName;

    private String description;

    @ManyToMany(mappedBy = "codeRole")
    private Collection<Code> code;

    @ManyToMany(mappedBy = "userRole")
    private Collection<User> user;
}
