package ca.group20.sysc4806project.service;

import ca.group20.sysc4806project.model.Surveyor;
import ca.group20.sysc4806project.repository.SurveyorRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Use to connect to Surveyor Database
 */
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SurveyorServiceImpl implements SurveyorService {

    private final SurveyorRepo surveyorRepo;

    /**
     * Adds a new surveyor to the database
     *
     * @param surveyor surveyor to be added
     * @return new surveyor
     */
    @Override
    public Surveyor saveSurveyor(Surveyor surveyor) {
        Surveyor newSurveyor = surveyorRepo.save(surveyor);
        log.info(surveyor.getUsername() + " has been saved");
        return newSurveyor;
    }

    /**
     * get surveyor from the database based off the username given
     *
     * @param surveyorUsername a surveyor's user name
     * @return surveyor table from the database
     */
    @Override
    public Surveyor getSurveyor(String surveyorUsername) {
        log.info("Fetching Surveyor " + surveyorUsername);
        return surveyorRepo.findByUsername(surveyorUsername);
    }
}
