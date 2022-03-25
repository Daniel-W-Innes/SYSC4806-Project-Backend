package ca.group20.sysc4806project.repository;

import ca.group20.sysc4806project.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepo extends JpaRepository<Survey, Long> {
    Survey findByName(String surveyName);

    Survey findById(long surveyId);
}
