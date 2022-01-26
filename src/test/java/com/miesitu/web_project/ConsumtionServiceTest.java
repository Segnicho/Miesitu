package com.miesitu.web_project;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.when;
// import static org.assertj.core.api.Assertions.assertThat;

// import java.util.stream.Collectors;
// import java.util.stream.Stream;

import com.miesitu.web_project.Repository.ConsumtionRepository;
import com.miesitu.web_project.Repository.UserRepository;
// import com.miesitu.web_project.entity.Code;
import com.miesitu.web_project.entity.Consumtion;
// import com.miesitu.web_project.entity.User;
import com.miesitu.web_project.services.ConsumtionService;
import com.miesitu.web_project.services.getLoggedUser;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
// import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.context.junit4.SpringRunner;

@Rollback(false)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ConsumtionServiceTest {

    // @Autowired
    // private TestEntityManager entityManager;

    @MockBean
    private ConsumtionRepository consRepo;

    @MockBean
    private getLoggedUser geUser;

    @MockBean
    private UserRepository userRepo;

    @InjectMocks
    private ConsumtionService service;

    // Test For Saving Consumtion
    @Test
    public void saveConsumtionTest() {
        
        Consumtion consumtion = Consumtion.builder()
        .ConsumtionId(12L)
        .amount(12.5f)
        .build();

        consRepo.save(consumtion);
        Assertions.assertThat(consumtion.getConsumtionId()).isGreaterThan(0);

    }
    
}
