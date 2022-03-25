package ca.group20.sysc4806project.service;

import ca.group20.sysc4806project.model.Survey;

/**
 * Use to connect to Survey Database
 */
public interface SurveyService {
    Survey findBySurveyName(String surveyName);

    Survey findSurveyById(long surveyId);

    /**
     * Adds a new survey to the database
     *
     * @param survey survey to be added
     * @return newly created survey
     */
    Survey saveSurvey(Survey survey);
}