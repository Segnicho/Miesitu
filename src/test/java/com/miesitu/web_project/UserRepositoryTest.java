package com.miesitu.web_project;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import com.miesitu.web_project.Repository.UserRepository;
import com.miesitu.web_project.entity.User;

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

@DataJpaTest
@Rollback(false)
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private UserRepository repo;

    // Test For Adding User
    @Test
    public void testAddingUser() {

        User user = new User();
        user.setEmail("obs@gmail.com");
        user.setPassword("felme");
        user.setFirstName("Hassan");
        user.setLastName("Mah");
        user.setArea("Bole");

        User savedUser = repo.save(user);
        User existUser = entityManager.find(User.class, savedUser.getUserId());
        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
    }

    // Test For Getting User
    @Test
    public void getUserTest() {

        User user = repo.findById(32L).get();
        Assertions.assertThat(user.getUserId()).isEqualTo(32L);

    }

    // Test for Getting List Of Users
    @Test
    public void getListOfUsersTest() {

       List<User> users = repo.findAll();
       Assertions.assertThat(users.size()).isGreaterThan(0);

    }

    //Test for Updating Users
    @Test
    public void updateUserTest() {

        User user = repo.findById(32L).get();

        user.setFirstName("Mah");

        User userUpdated = repo.save(user);
        Assertions.assertThat(userUpdated.getFirstName()).isEqualTo("Mah");

    }

    // Test For Deleting User
    @Test
    public void deleteUserTest() {
        
        User user = repo.findById(10L).get();
        repo.deleteById(10L);
        User user1 = null;

        Optional<User> optionalUser = repo.findById(10L);
        if(optionalUser.isPresent()) {
            user1 = optionalUser.get();
        }
        Assertions.assertThat(user1).isNull();
    }
        
}
