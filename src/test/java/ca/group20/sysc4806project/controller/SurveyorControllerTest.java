package ca.group20.sysc4806project.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SurveyorControllerTest {
    private final static String SURVEYOR_NAME = "Desha";
    private final static String CONTROLLER_URL = "/api/v0/surveyors/";

    @Autowired
    private MockMvc mvc;

    private String test_surveyor;
    private String survey_1;
    private String survey_2;

    @BeforeEach
    void setUp() {
        test_surveyor = "{" +
                "\"username\":\"" + SURVEYOR_NAME + "\"" +
                ",\"firstName\":\"" + SURVEYOR_NAME + "\"" +
                ",\"lastName\":\"" + SURVEYOR_NAME + "\"" +
                ",\"hashedPassword\":\"" + "####" + "\"" +
                '}';
        survey_1 = "{\"name\" : \"Survey1\"}";
        survey_2 = "{\"name\" : \"Survey2\"}";
    }

    @Test
    @Order(1)
    void createSurveyor() throws Exception {
        mvc.perform(post(CONTROLLER_URL).contentType(MediaType.APPLICATION_JSON)
                .content(test_surveyor)).andExpect(status().isCreated());
    }

    @Test
    @Order(2)
    void getSurveyor() throws Exception {
        mvc.perform(get(CONTROLLER_URL + SURVEYOR_NAME)).andExpect(status().isOk());
    }

    @Test
    @Order(3)
    void createSurvey() throws Exception {
        mvc.perform(post(CONTROLLER_URL + SURVEYOR_NAME + "/surveys")
                .contentType(MediaType.APPLICATION_JSON).content(survey_1)).andExpect(status().isCreated());
        mvc.perform(post(CONTROLLER_URL + SURVEYOR_NAME + "/surveys")
                .contentType(MediaType.APPLICATION_JSON).content(survey_2)).andExpect(status().isCreated());
    }

    @Test
    @Order(4)
    void getSurveys() throws Exception {
        mvc.perform(get(CONTROLLER_URL + SURVEYOR_NAME + "/surveys")).andExpect(status().isOk());
    }

    @Test
    @Order(5)
    void getSurvey() throws Exception {
        mvc.perform(get(CONTROLLER_URL + SURVEYOR_NAME + "/survey")
                .param("name", "survey_1")).andExpect(status().isOk());
    }
}