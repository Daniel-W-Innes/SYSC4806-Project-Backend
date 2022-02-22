package ca.group20.sysc4806project.service;

import ca.group20.sysc4806project.model.Surveyor;

public interface SurveyorService {
    Surveyor saveSurveyor(Surveyor surveyor);
    Surveyor getSurveyor(String surveyorUsername);
}
