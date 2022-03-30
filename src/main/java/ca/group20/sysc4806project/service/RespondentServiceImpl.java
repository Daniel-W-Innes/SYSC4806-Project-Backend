package ca.group20.sysc4806project.service;

import ca.group20.sysc4806project.model.Respondent;
import ca.group20.sysc4806project.repository.RespondentRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RespondentServiceImpl implements RespondentService{
    private final RespondentRepo respondentRepo;

    /**
     * Adds a new respondent to the database
     *
     * @param respondent surveyor to be added
     * @return new surveyor
     */
    @Override
    public Respondent saveRespondent(Respondent respondent) {
        Respondent newRespondent = respondentRepo.save(respondent);
        log.info(respondent.getId() + " has been saved");
        return newRespondent;
    }

    @Override
    public Respondent findRespondentById(long respondentId) {
        log.info("Fetching Survey " + respondentId);
        return respondentRepo.findById(respondentId);
    }
}
