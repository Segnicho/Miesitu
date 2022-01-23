package com.miesitu.web_project.Repository;

import java.util.List;

import com.miesitu.web_project.entity.Code;
import com.miesitu.web_project.entity.Consumtion;
import com.miesitu.web_project.entity.Product;
import com.miesitu.web_project.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumtionRepository extends JpaRepository<Consumtion, Long>{

    @Query(
        nativeQuery = true,
        value = "select * from consumtion where customer =: cust and product =: prod"
    )
    List<Consumtion> checkExistance(@Param("cust") User cust, @Param("prod") Product prod);
}
