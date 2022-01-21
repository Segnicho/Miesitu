package com.miesitu.web_project.Repository;

import java.util.List;

import com.miesitu.web_project.entity.ProductCart;
import com.miesitu.web_project.entity.Products;

// import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
// import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
//    List<Products> findByProductId(Long productId);

}
