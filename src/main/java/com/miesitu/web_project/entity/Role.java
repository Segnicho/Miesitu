package com.miesitu.web_project.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;

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
