package com.miesitu.web_project;

import static org.assertj.core.api.Assertions.assertThat;


import com.miesitu.web_project.Repository.UserRepository;
import com.miesitu.web_project.entity.User;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@Rollback(false)
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryTest {

    // @Test
    // public void testAddNew() {
    //     User user = new User();

    //     user.setEmail("j@gemail.com");
    //     user.setUsername("jj");
    //     user.setFirstName("aduu");
    //     user.setFirstName("oum");

    //     User savedUser = repo.save(user);
    //     Assertions.assertThat(savedUser).isNotNull();
    //     Assertions.assertThat(savedUser.getUserId()).isGreaterThan(0);

    // }
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository repo;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setEmail("felm@gmail.com");
        user.setPassword("felm");
        user.setFirstName("Felmeta");
        user.setLastName("Muktar");

        User savedUser = repo.save(user);
        User existUser = entityManager.find(User.class, savedUser.getUserId());
        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
    }
    
    

        // User user = new User(123, "Felm", "Felmeta", "Muktar", "felm@gmail.com", 93212, "1234", "oro", ,null,;
    //     repo.save(user);
    //     assertNotNull(user);
    //     assertEquals(user.getUsername(), user.getUsername());
    //     assertEquals(user.getFirstName(), user.getFirstName());
    // }
    // @Test
    // public void testDeleteUser() {
    // User user = new User(2,"Jab", "jabir", "has", "jab@mail.com", 63537, "3425", "oroo",null, null,Code;
    // repo.save(user);
    // repo.delete(user);
    // }
    // @Test
    // public void findAllUsers() {
    // User user = new User(2,"Jab", "jabir", "has", "jab@mail.com", 63537, "3425", "Addis", 1, "Admin", 12);
    // repo.save(user);
    // assertNotNull(user);
    // }
    // @Test
    // public void deleteByUserIdTest() {
    // User user = new User(2,"Jab", "jabir", "has", "jab@mail.com", 63537, "3425", "Addis", 1, "Admin", "Code");
    // User use = repo.save(user);
    // repo.deleteById(use.getUserId());
    // }


    
}
