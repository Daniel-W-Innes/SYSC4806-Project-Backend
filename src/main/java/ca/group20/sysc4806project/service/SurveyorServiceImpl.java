package ca.group20.sysc4806project.service;

import ca.group20.sysc4806project.model.Surveyor;
import ca.group20.sysc4806project.repository.SurveyorRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SurveyorServiceImpl implements SurveyorService {

    private final SurveyorRepo surveyorRepo;

    @Override
    public Surveyor saveSurveyor(Surveyor surveyor) {
        Surveyor newSurveyor = surveyorRepo.save(surveyor);
        log.info(surveyor.getUsername() + " has been saved");
        return newSurveyor;
    }

    @Override
    public Surveyor getSurveyor(String surveyorUsername) {
        log.info("Fetching Surveyor " + surveyorUsername);
        return surveyorRepo.findByUsername(surveyorUsername);
    }
}
