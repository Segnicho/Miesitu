package com.miesitu.web_project.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Code {
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE)
    private long code;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
        name = "code_role",
        joinColumns = @JoinColumn(name = "code", referencedColumnName = "code"),
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "roleId")
    )
    private Collection<Role> codeRole;

}
