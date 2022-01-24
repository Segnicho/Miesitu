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
        value = "select * from consumtion where customer_user_id =:cust and product_product_id =:prod"
    )
    List<Consumtion> checkExistance(@Param("cust") long cust, @Param("prod") long prod);

    @Query(
        nativeQuery = true,
        value = "delete from consumtion where customer_user_id =:userId and product_product_id =:prodId"
    )
    void deleteConsumtion( @Param("prodId") long prodId, @Param("userId") long userId);
}
