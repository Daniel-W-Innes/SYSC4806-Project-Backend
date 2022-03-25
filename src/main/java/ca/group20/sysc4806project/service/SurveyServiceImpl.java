package ca.group20.sysc4806project.service;

import ca.group20.sysc4806project.model.Survey;
import ca.group20.sysc4806project.model.question.Question;
import ca.group20.sysc4806project.repository.QuestionRepo;
import ca.group20.sysc4806project.repository.SurveyRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Use to connect to Survey Database
 */
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepo surveyRepo;
    private final QuestionRepo questionRepo;

    public Survey findBySurveyName(String surveyName) {
        log.info("Fetching Survey " + surveyName);
        return surveyRepo.findByName(surveyName);
    }

    @Override
    public Survey findSurveyById(long surveyId) {
        log.info("Fetching Survey " + surveyId);
        return surveyRepo.findById(surveyId);
    }

    /**
     * Adds a new survey to the database
     *
     * @param survey survey to be added
     * @return newly created survey
     */
    @Override
    public Survey saveSurvey(Survey survey) {
        Survey newSurvey = surveyRepo.save(survey);
        if (survey.getQuestions() != null){
            questionRepo.saveAll(survey.getQuestions());
            for (Question q : survey.getQuestions()) {
                q.setSurvey(newSurvey);
            }
        }
        log.info(survey.getName() + " has been saved");
        return newSurvey;
    }
}
