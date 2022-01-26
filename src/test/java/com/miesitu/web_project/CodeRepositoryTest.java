package com.miesitu.web_project;

import com.miesitu.web_project.Repository.CodeRepository;
import com.miesitu.web_project.entity.Code;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@Rollback(false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CodeRepositoryTest {

    @Autowired
    private CodeRepository codeRepository;

    // Test For Generating Code
    @Test
    public void testGeneratedCode() {
        Code code = Code.builder()
        .code(1234L)
        .build();

        codeRepository.save(code);
        Assertions.assertThat(code.getCode()).isGreaterThan(0);
    }
    
}
