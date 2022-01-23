package com.miesitu.web_project.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.miesitu.web_project.entity.Anouncement;
import com.miesitu.web_project.entity.Product;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

    List<Product> findByProductId(long productId);

    // @Query("select a from Product a where a.creationDateTime <= :creationDateTime")
    // List<Article> findAllWithCreationDateTimeBefore(
    //   @Param("creationDateTime") Date creationDateTime);


    Page<Product> findAllByEndDateBefore(Date date, PageRequest pageable);
    // List<Product> findByEndDateBefore(Date date);

}
