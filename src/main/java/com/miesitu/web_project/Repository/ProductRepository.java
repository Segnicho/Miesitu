package com.miesitu.web_project.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.miesitu.web_project.entity.Anouncement;
import com.miesitu.web_project.entity.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

    List<Product> findByProductId(long productId);

    // @Query("select a from Product a where a.creationDateTime <= :creationDateTime")
    // List<Article> findAllWithCreationDateTimeBefore(
    //   @Param("creationDateTime") Date creationDateTime);

    List<Product> findByEndDateBefore(Date date);

}
