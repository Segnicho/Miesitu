package com.miesitu.web_project.Repository;

import com.miesitu.web_project.entity.Role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
    Role findByRoleId(long roleId);   
}
