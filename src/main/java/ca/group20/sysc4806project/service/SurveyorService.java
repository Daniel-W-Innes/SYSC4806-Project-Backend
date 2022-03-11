package ca.group20.sysc4806project.service;

import ca.group20.sysc4806project.model.Surveyor;

/**
 * Use to connect to Surveyor Database
 */
public interface SurveyorService {
    /**
     * Adds a new surveyor to the database
     *
     * @param surveyor surveyor to be added
     * @return new surveyor
     */
    Surveyor saveSurveyor(Surveyor surveyor);

    /**
     * get surveyor from the database based off the username given
     *
     * @param surveyorUsername a surveyor's user name
     * @return surveyor table from the database
     */
    Surveyor getSurveyor(String surveyorUsername);
}
