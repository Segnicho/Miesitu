package com.miesitu.web_project.Repository;

import java.util.Optional;

import com.miesitu.web_project.entity.Anouncement;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnouncementRepository extends JpaRepository<Anouncement, Long>{

    Long countByAnouncementId(long anouncementId);

    // Page<Anouncement> findPaginated(int pageNo, int pageSize);


}
