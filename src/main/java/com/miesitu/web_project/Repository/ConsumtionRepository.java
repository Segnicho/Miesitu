package com.miesitu.web_project.Repository;

import com.miesitu.web_project.entity.Code;
import com.miesitu.web_project.entity.Consumtion;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumtionRepository extends CrudRepository<Consumtion, Long>{

}
