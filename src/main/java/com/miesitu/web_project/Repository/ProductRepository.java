package com.miesitu.web_project.Repository;

<<<<<<< HEAD
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
=======
import java.util.List;

import com.miesitu.web_project.entity.Product;

// import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
// import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// restot
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByProductId(Long productId);
>>>>>>> 5035a73069fa704251316dade501f0a9b5d964b6

}
