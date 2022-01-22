package com.miesitu.web_project.entity;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

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

public class User implements UserDetails {//implements UserDetails{
    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE)
    private long userId;
    
    @Column(unique = true)
    private String username;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private int phone;
    private String password;

    
    private String area;
    private Instant registeredDate;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_role",
        joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "userId")},
        inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "roleId")}
    )
    private Collection<Role> userRole;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "code", referencedColumnName = "code")
    private Code code;

    // @Override
    //     public Collection<? extends GrantedAuthority> getAuthorities() {
    //     return Arrays.asList(new SimpleGrantedAuthority(role.map));
    // }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection <SimpleGrantedAuthority> user_authorities = new ArrayList();
        Collection <Role> user_roles = this.getUserRole();
        for (Role role : user_roles){
            user_authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        // return Arrays.asList();
        // userRole.iterator().forEachRemaining(new SimpleGrantedAuthority("UserRole"));
        // userRole.iterator().
        return user_authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
    return true;
    }

    @Override
    public boolean isAccountNonLocked() {
    return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
    return true;
    }

    @Override
    public boolean isEnabled() {
    return true;
    }
}
