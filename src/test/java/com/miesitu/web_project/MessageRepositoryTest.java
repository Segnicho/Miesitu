package com.miesitu.web_project;

import java.util.List;
// import java.util.Optional;

import com.miesitu.web_project.Repository.MessageRepository;
import com.miesitu.web_project.entity.ContactUs;

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
public class MessageRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;

    // Test For Saving Message
    @Test
    public void saveMessageTest() {
        ContactUs contactUs = ContactUs.builder()
        .fullname("Obsa")
        .email("obs@gmail.com")
        .UserMessage("This website is good!")
        .build();

        messageRepository.save(contactUs);
        Assertions.assertThat(contactUs.getMessageId()).isGreaterThan(0);

    }
    
    // @Test
    // public void getMessgeTest() {
    //     ContactUs contactUs = messageRepository.findByEmail("obs@gmail.com"); 
    //     Assertions.assertThat(contactUs.getFullname()).isEqualTo("Obsa");

    // }
    @Test
    public void getListOfMessagesTest() {

       List<ContactUs> contactUss = messageRepository.findAll();
       Assertions.assertThat(contactUss.size()).isGreaterThan(0);

    }
    //Test for Updating Message
    // @Test
    // public void updateMessageTest() {

    //     ContactUs contactUs = messageRepository.findByEmail("felm@gmail.com");

    //     contactUs.setUserMessage("new message");

    //     ContactUs contactUsUpdated = messageRepository.save(contactUs);
    //     Assertions.assertThat(contactUsUpdated.getUserMessage()).isEqualTo("new message");

    // }
    // @Test
    // public void deleteMessageTest() {

    //     ContactUs contactUs = messageRepository.findByEmail("obs@gmail.com");
    //     messageRepository.deleteById("One");
    //     ContactUs contactUs1 = null;

    //     Optional<ContactUs> optionalContactUs = messageRepository.findById("One");
    //     if(optionalContactUs.isPresent()) {
    //         contactUs1 = optionalContactUs.get();
    //     }
    //     Assertions.assertThat(contactUs1).isNull();
    // }
    
}
