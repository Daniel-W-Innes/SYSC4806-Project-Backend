package ca.group20.sysc4806project.controller;

import ca.group20.sysc4806project.model.Surveyor;
import ca.group20.sysc4806project.repository.SurveyRepo;
import ca.group20.sysc4806project.repository.SurveyorRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import util.ToJson;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static util.ToJson.surveyJson;
import static util.ToJson.surveyorJson;

@SpringBootTest
@AutoConfigureMockMvc
class SurveyorControllerTest {
    private static final  String USERNAME = "username";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String HASHED_PASSWORD = "hashedPassword";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private SurveyorRepo surveyorRepo;

    @Autowired
    private SurveyRepo surveyRepo;

    private final static String controller_url = "/api/v0/surveyors/";

    @AfterEach
    void teardown(){
        surveyorRepo.deleteAll();
        surveyRepo.deleteAll();
    }

    @Test
    void createSurveyor() throws Exception {
        mvc.perform(post(controller_url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(surveyorJson(USERNAME, FIRST_NAME, LAST_NAME, HASHED_PASSWORD)))
                .andExpectAll(
                        status().isCreated(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.username").value(USERNAME),
                        jsonPath("$.firstName").value(FIRST_NAME),
                        jsonPath("$.lastName").value(LAST_NAME),
                        jsonPath("$.hashedPassword").value(HASHED_PASSWORD));
        assertEquals(new Surveyor(USERNAME,FIRST_NAME,LAST_NAME,HASHED_PASSWORD), surveyorRepo.findByUsername(USERNAME));
    }

    @Test
    void getSurveyor() throws Exception {
        surveyorRepo.save(new Surveyor(USERNAME,FIRST_NAME,LAST_NAME,HASHED_PASSWORD));
        mvc.perform(get(controller_url + USERNAME))
                .andExpectAll(
                        status().isOk(),
                        jsonPath("$.username").value(USERNAME),
                        jsonPath("$.firstName").value(FIRST_NAME),
                        jsonPath("$.lastName").value(LAST_NAME),
                        jsonPath("$.hashedPassword").value(HASHED_PASSWORD));
    }

    @Test
    void createSurvey() throws Exception {
        String name = "name";
        String question1 = "question1";
        String question2 = "question2";
        String question3 = "question3";
        String option1 = "option1";
        String option2 = "option2";
        int max = 3;
        int min = 1;
        surveyorRepo.save(new Surveyor(USERNAME,FIRST_NAME,LAST_NAME,HASHED_PASSWORD));
        mvc.perform(post(controller_url + USERNAME + "/surveys")
                .contentType(MediaType.APPLICATION_JSON)
                .content(surveyJson(name, List.of(
                        new ToJson.Question(question1,"SINGLE_SELECTION"),
                        new ToJson.Question(question2,max,min,"MULTI_SELECTION" ),
                        new ToJson.Question(question3,List.of(option1,option2),"RATING" ))
                ))).andExpect(status().isCreated());
    }
}