package com.miesitu.web_project;

import com.miesitu.web_project.Repository.ProductRepository;
import com.miesitu.web_project.entity.Product;
import static org.assertj.core.api.Assertions.assertThat;
// import static org.mockito.ArgumentMatchers.anyLong;
// import static org.mockito.Mockito.when;

// import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
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
    // @Test
    // public void whenGivenId_shouldDeleteProduct_ifFound(){
    //     Product product = new Product();
    //     product.setProductId(12);
    //     product.setProductDesc("Sold");

    //     when(repo.findById(product.getProductId())).thenReturn(Optional.of(product));

    //     entityManager.deleteProduct(product.getProductId());
    //     verify(productRepository).deleteById(product.getProductId());
    // }

    // @Test
    // public void should_throw_exception_when_product_doesnt_exist() {
    //     Product product = new Product();
    //     product.setProductId(8L);
    //     product.setProductDesc("Sold Out");

    //     given(productRepository.findById(anyLong())).willReturn(Optional.ofNullable(null));
    //     deleteProduct.deleteProduct(product.getProductId());
    // }
}


