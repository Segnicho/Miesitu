package com.miesitu.web_project;

import com.miesitu.web_project.Repository.ProductRepository;
import com.miesitu.web_project.entity.Product;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@Rollback(false)
@ExtendWith (SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ProductRepository repo;

    @Test
    public void testAddProduct() {
        Product product = new Product();
        product.setProductDesc("Newly Arrived Sugar");
        product.setPrice(300);
        product.getStartDate();
        product.getEndDate();

        Product savedProduct = repo.save(product);
        Product exitProduct = entityManager.find(Product.class, savedProduct.getProductId());
        assertThat(product.getProductId()).isEqualTo(exitProduct.getProductId());
    }
   
}


