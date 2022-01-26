package com.miesitu.web_project.Repository;

import com.miesitu.web_project.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByRoleId(long roleId);   
}
