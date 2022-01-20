package com.miesitu.web_project.entity;

import java.util.List;

import javax.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Code {
    @Id
    private long code;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
        name = "code_role",
        joinColumns = @JoinColumn(name = "code", referencedColumnName = "code"),
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "roleId")
    )
    private List<Role> codeRole;

}
