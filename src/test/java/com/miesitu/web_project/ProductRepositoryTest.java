package com.miesitu.web_project;

import com.miesitu.web_project.Repository.ProductRepository;
import com.miesitu.web_project.entity.Product;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


import org.assertj.core.api.Assertions;
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

    // Test For Adding Product
    @Test
    public void testAddProduct() {

        Product product = new Product();
        product.setProductDesc(" New  coming Sugar");
        product.setPrice(500);
        product.getStartDate();
        product.getEndDate();

        Product savedProduct = repo.save(product);
        Product exitProduct = entityManager.find(Product.class, savedProduct.getProductId());
        assertThat(product.getProductId()).isEqualTo(exitProduct.getProductId());
    }

    // Test for Getting Product
    // @Test
    // public void getProductTest() {

    //     Product product = repo.findById(7L).get();
    //     Assertions.assertThat(product.getProductId()).isEqualTo(7L);

    // }

    // Test for Getting List Of Products
    @Test
    public void getListOfProductsTest() {

       List<Product> products = repo.findAll();
       Assertions.assertThat(products.size()).isGreaterThan(0);

    }

    //Test for Updating Products
    @Test
    public void updateProductTest() {

        Product product = repo.findById(33L).get();
        product.setPrice(300);

        Product productUpdated = repo.save(product);
        Assertions.assertThat(productUpdated.getPrice()).isEqualTo(300);

    }

    // Test For Deleting Products
    // @Test
    // public void deleteProductTest() {
        
    //     // Product product = repo.findById(7L).get();
    //     repo.deleteById(12L);
    //     Product product1 = null;

    //     Optional<Product> optionalProduct = repo.findById(7L);
    //     if(optionalProduct.isPresent()) {
    //         product1 = optionalProduct.get();
    //     }
    //     Assertions.assertThat(product1).isNull();
    // }
    
}


