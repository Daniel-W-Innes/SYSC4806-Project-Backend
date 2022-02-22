package ca.group20.sysc4806project.repository;

import ca.group20.sysc4806project.model.Surveyor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyorRepo extends JpaRepository<Surveyor, Long> {
    Surveyor findByUsername(String username);
}
