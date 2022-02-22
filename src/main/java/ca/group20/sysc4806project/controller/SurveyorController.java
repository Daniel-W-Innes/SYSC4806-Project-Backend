package ca.group20.sysc4806project.controller;

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

@RestController
@RequestMapping("/api/v0/surveyors")
@RequiredArgsConstructor
@Slf4j
public class SurveyorController {

    private final SurveyorService surveyorService;
    private final SurveyService surveyService;

    @PostMapping("/{surveyorName}/surveys")
    public ResponseEntity<?> createSurvey(@PathVariable("surveyorName") String surveyorName,
                                          @Valid @RequestBody Survey survey) {
        try {
            Surveyor surveyor = surveyorService.getSurveyor(surveyorName);
            Survey newSurvey = surveyService.saveSurvey(survey);
            surveyor.addSurvey(survey);
        } catch (Exception e) { // add new Exception for Survey already exists or survey already added
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v0/surveyors/").toUriString());
        return ResponseEntity.created(uri).body(newSurvey);
    }
}
