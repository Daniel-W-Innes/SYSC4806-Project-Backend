package ca.group20.sysc4806project.controller;

import ca.group20.sysc4806project.model.Survey;
import ca.group20.sysc4806project.model.Surveyor;
import ca.group20.sysc4806project.service.SurveyService;
import ca.group20.sysc4806project.service.SurveyorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * Controllers all calls to the database
 */
@RestController
@RequestMapping("/api/v0/surveyors")
@RequiredArgsConstructor
@Slf4j
public class SurveyorController {

    private final SurveyorService surveyorService;
    private final SurveyService surveyService;

    /**
     * Creates a new surveyor to be added to the database
     *
     * @param surveyor new surveyor to be created
     * @return created surveyor
     */
    @PostMapping("")
    public ResponseEntity<?> create(@Valid @RequestBody Surveyor surveyor) {
        try {
            Surveyor newSurveyor = surveyorService.saveSurveyor(surveyor);
            URI uri = URI.create(
                    ServletUriComponentsBuilder
                            .fromCurrentContextPath()
                            .path("/api/v0/surveyors")
                            .toUriString());
            return ResponseEntity.created(uri).body(newSurveyor);
        } catch (Exception e) { // add new Exception for Surveyor already exists
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * Using a given surveyor's name, return the surveyor matching that name
     *
     * @param surveyorName surveyor's name given as a string
     * @return a surveyor
     */
    @GetMapping("/{surveyorName}")
    public ResponseEntity<?> get(@PathVariable("surveyorName") String surveyorName) {
        try {
            Surveyor surveyor = surveyorService.getSurveyor(surveyorName);
            return ResponseEntity.status(HttpStatus.OK).body(surveyor);
        } catch (Exception e) { // add new exception
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * Creates a survey under a given surveyor's name.
     *
     * @param surveyorName surveyor's name given as a string
     * @param survey       the survey being created
     * @return the newly created survey
     */
    @PostMapping("/{surveyorName}/surveys")
    public ResponseEntity<?> createSurvey(@PathVariable("surveyorName") String surveyorName,
                                          @Valid @RequestBody Survey survey) {
        try {
            Surveyor surveyor = surveyorService.getSurveyor(surveyorName);
            survey.setSurveyor(surveyor);
            surveyor.addSurvey(survey);
            Survey newSurvey = surveyService.saveSurvey(survey);
            URI uri = URI.create(
                    ServletUriComponentsBuilder
                            .fromCurrentContextPath()
                            .path("/api/v0/surveyors/" + surveyorName + "/surveys")
                            .toUriString());
            return ResponseEntity.created(uri).body(newSurvey);
        } catch (Exception e) { // add new Exception for Survey already exists or survey already added
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * Using a given surveyor's name, return the list of surveys assigned to that surveyor
     *
     * @param surveyorName surveyor's name given as a string
     * @return list of surveys
     */
    @GetMapping("/{surveyorName}/surveys")
    public ResponseEntity<?> getSurveys(@PathVariable("surveyorName") String surveyorName) {
        try {
            Surveyor surveyor = surveyorService.getSurveyor(surveyorName);
            List<Survey> surveys = surveyor.getSurveys();
            return ResponseEntity.status(HttpStatus.OK).body(surveys);
        } catch (Exception e) { // add new exception
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * Using a given surveyor's name and a survey name, return the survey with matching name and surveyor name
     *
     * @param surveyorName surveyor's name given as a string
     * @param name         The name of the survey as a string
     * @return a survey
     */
    @GetMapping("/{surveyorName}/survey")
    public ResponseEntity<?> getSurvey(@PathVariable("surveyorName") String surveyorName, @RequestParam String name) {
        try {
            Surveyor surveyor = surveyorService.getSurveyor(surveyorName);
            return ResponseEntity.status(HttpStatus.OK).body(surveyor.getSurvey(name));
        } catch (Exception e) { // add new Exception for Survey already exists or survey already added
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
