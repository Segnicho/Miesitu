package com.miesitu.web_project;

import java.util.List;
import java.util.Optional;

import com.miesitu.web_project.Repository.AnouncementRepository;
import com.miesitu.web_project.entity.Anouncement;

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
public class AnouncementRepositoryTest {

    @Autowired
    private AnouncementRepository anouncementRepository;

    //Unit test for save Anouncement
    @Test
    public void saveAnouncementTest() {

        Anouncement anouncement = Anouncement.builder()
        .message("new sugar")
        .subject("sweety Sugar")
        .build();
        
        anouncementRepository.save(anouncement);
        Assertions.assertThat(anouncement.getAnouncementId()).isGreaterThan(0);

    }

    // Unit Test For Getting Anouncement 
    @Test
    public void getAnouncementTest() {

        Anouncement anouncement = anouncementRepository.findById(12L).get();
        Assertions.assertThat(anouncement.getAnouncementId()).isEqualTo(12L);

    }

    // Unit Test For Getting List of Anouncements
    @Test
    public void getListOfAnouncementsTest() {

       List<Anouncement> anouncements = anouncementRepository.findAll();
       Assertions.assertThat(anouncements.size()).isGreaterThan(0);

    }

    //Unit Test for Updating Anouncements
    @Test
    public void updateAnouncementTest() {

        Anouncement anouncement = anouncementRepository.findById(12L).get();

        anouncement.setMessage("Sweeaty sugar that is produced from sweet sugarcane");

        Anouncement anouncementUpdated = anouncementRepository.save(anouncement);
        Assertions.assertThat(anouncementUpdated.getMessage()).isEqualTo("Sweeaty sugar that is produced from sweet sugarcane");

    }
    
    // Unit Test for Deleting Announcement
    @Test
    public void deleteAnouncementTest() {
        
        // Anouncement anouncement = anouncementRepository.findById(12L).get();
        anouncementRepository.deleteById(12L);
        Anouncement anouncement1 = null;

        Optional<Anouncement> optionalAnouncement = anouncementRepository.findById(12L);
        if(optionalAnouncement.isPresent()) {
            anouncement1 = optionalAnouncement.get();
        }
        Assertions.assertThat(anouncement1).isNull();
    }
    
}
