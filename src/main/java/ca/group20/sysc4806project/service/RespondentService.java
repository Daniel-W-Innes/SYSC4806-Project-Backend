package ca.group20.sysc4806project.service;

import ca.group20.sysc4806project.model.Respondent;

public interface RespondentService {
    Respondent saveRespondent(Respondent respondent);

    Respondent findRespondentById(long id);
}
