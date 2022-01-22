package com.miesitu.web_project.Repository;

import java.util.Optional;

import com.miesitu.web_project.entity.Anouncement;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnouncementRepository extends CrudRepository<Anouncement, Long>{

    Long countByAnouncementId(long anouncementId);

}
