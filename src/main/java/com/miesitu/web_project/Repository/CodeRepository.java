package com.miesitu.web_project.Repository;

import com.miesitu.web_project.entity.Code;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepository extends CrudRepository<Code, Long>{
    Code findByCode(long code);   
}
