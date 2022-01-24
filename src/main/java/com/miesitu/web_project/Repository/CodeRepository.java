package com.miesitu.web_project.Repository;

import java.util.Collection;

import com.miesitu.web_project.entity.Code;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepository extends JpaRepository<Code, Long>{
    Code findByCode(long code);

    Collection<Code> findAllByStatus(boolean b);   
}
