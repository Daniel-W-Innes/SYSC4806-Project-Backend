package ca.group20.sysc4806project.controller;

import ca.group20.sysc4806project.exception.InvalidRoleException;
import ca.group20.sysc4806project.exception.SurveyorAlreadyExistsException;
import ca.group20.sysc4806project.model.Respondent;
import ca.group20.sysc4806project.model.Survey;
import ca.group20.sysc4806project.model.Surveyor;
import ca.group20.sysc4806project.model.answer.Answer;
import ca.group20.sysc4806project.model.question.Question;
import ca.group20.sysc4806project.service.QuestionService;
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
import java.util.ArrayList;
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
    private final QuestionService questionService;

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
        } catch (SurveyorAlreadyExistsException | InvalidRoleException saee) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(saee.getMessage());
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
        Surveyor surveyor = surveyorService.getSurveyor(surveyorName);
        if (surveyor != null) {
            return ResponseEntity.status(HttpStatus.OK).body(surveyor);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Surveyor found with username: " + surveyorName);
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
            if (surveyor != null) {
                survey.setSurveyor(surveyor);
                surveyor.addSurvey(survey);
                Survey newSurvey = surveyService.saveSurvey(survey);
                URI uri = URI.create(
                        ServletUriComponentsBuilder
                                .fromCurrentContextPath()
                                .path("/api/v0/surveyors/" + surveyorName + "/surveys")
                                .toUriString());
                return ResponseEntity.created(uri).body(newSurvey);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Surveyor found with username: " + surveyorName);
            }
        } catch (Exception e) { // add new Exception for Survey already exists or survey already added
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * Add a text question to an existing survey.
     *
     * @param surveyId survey's ID
     * @param question question to save
     * @return the newly created question
     */
    @PostMapping("/survey/{surveyId}/questions")
    public ResponseEntity<?> createQuestion(@PathVariable("surveyId") long surveyId,
                                            @Valid @RequestBody Question question) {
        try {
            Survey survey = surveyService.findSurveyById(surveyId);
            question.setSurvey(survey);
            survey.addQuestion(question);
            Question newQuestion = questionService.saveQuestion(question);
            URI uri = URI.create(
                    ServletUriComponentsBuilder
                            .fromCurrentContextPath()
                            .path("/api/v0/surveyors/survey/" + surveyId + "/questions")
                            .toUriString());
            return ResponseEntity.created(uri).body(newQuestion);
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
            if (surveyor != null) {
                List<Survey> surveys = surveyor.getSurveys();
                return ResponseEntity.status(HttpStatus.OK).body(surveys);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Surveyor found with username: " + surveyorName);
            }
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
            if (surveyor != null) {
                return ResponseEntity.status(HttpStatus.OK).body(surveyor.getSurvey(name));
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Surveyor found with username: " + surveyorName);
            }
        } catch (Exception e) { // add new Exception for Survey already exists or survey already added
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * Using a survey ID, return all answers to all questions of that survey
     * useful if we want to arrange answers by respondent
     *
     * @param surveyId the ID of the survey we want the answers from
     * @return list of lists: each inner list contains all answers for one respondent of the survey
     */
    @GetMapping("/survey/{surveyId}")
    public ResponseEntity<?> getAnswersForSurvey(@PathVariable("surveyId") int surveyId) {
        try {
            Survey survey = surveyService.findSurveyById(surveyId);
            if (survey != null) {
                List<Respondent> respondents = survey.getRespondents();
                List<List<Answer>> answers = new ArrayList<List<Answer>>();
                for(Respondent r : respondents) {
                    answers.add(r.getAnswers());
                }
                return ResponseEntity.status(HttpStatus.OK).body(answers);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No survey found with ID: " + surveyId);
            }
        } catch (Exception e) { // add new Exception for Survey already exists or survey already added
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /**
     * Using a question ID, return all answers to that question
     *
     * @param questionId the question we want the answers from
     * @return
     */
    @GetMapping("/question/{questionId}")
    public ResponseEntity<?> getAnswersForQuestion(@PathVariable("questionId") int questionId) {
        try {
            Question question = questionService.findQuestionById(questionId);

            if (question != null) {
                Survey survey = question.getSurvey();
                List<Respondent> respondents = survey.getRespondents();
                List<Answer> answers = new ArrayList<>();
                for(Respondent r : respondents) {
                    answers.addAll(r.getAnswersToQuestion(question.getId()));
                }
                return ResponseEntity.status(HttpStatus.OK).body(answers);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No question found with ID: " + questionId);
            }
        } catch (Exception e) { // add new Exception for Survey already exists or survey already added
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
