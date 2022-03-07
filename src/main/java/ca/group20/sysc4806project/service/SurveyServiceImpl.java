package ca.group20.sysc4806project.service;

import ca.group20.sysc4806project.model.Survey;
import ca.group20.sysc4806project.repository.SurveyRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepo surveyRepo;

    @Override
    public Survey saveSurvey(Survey survey) {
        Survey newSurvey = surveyRepo.save(survey);
        log.info(survey.getName() + " has been saved");
        return newSurvey;
    }
}
