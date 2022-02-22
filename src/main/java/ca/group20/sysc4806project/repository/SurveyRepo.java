package ca.group20.sysc4806project.repository;

import ca.group20.sysc4806project.model.Surveyor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepo extends JpaRepository<Survey, Long> {
    Surveyor findByName(String surveyName);
}
