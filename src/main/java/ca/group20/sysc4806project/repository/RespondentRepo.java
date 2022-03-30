package ca.group20.sysc4806project.repository;

import ca.group20.sysc4806project.model.Respondent;
import ca.group20.sysc4806project.model.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RespondentRepo extends JpaRepository<Respondent, Long> {
    List<Respondent> findBySurveyId(Long surveyId);
    Respondent findById(long respondentID);
    List<Respondent> findBySurvey(Survey survey);

}
