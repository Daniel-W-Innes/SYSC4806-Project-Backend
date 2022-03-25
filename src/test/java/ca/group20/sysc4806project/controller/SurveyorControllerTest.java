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
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@Order(1)
class SurveyorControllerTest {
    private final static String SURVEYOR_NAME = "Desha";
    private final static String CONTROLLER_URL = "/api/v0/surveyors/";

    @Autowired
    private MockMvc mvc;

    private String test_surveyor, survey_with_questions, text_question, number_question, multiple_choice_question;

    @BeforeEach
    void setUp() {
        text_question= "{\"type\" : \"number\",\"question\": \"question\"}";
        number_question= "{\"type\" : \"text\",\"question\": \"question\",\"max\": 2,\"min\": 1}";
        multiple_choice_question= "{\"type\" : \"multipleChoice\",\"question\": \"question\",\"displayFormat\": \"MULTI_SELECTION\",\"options\": [\"option1\"]}";
        test_surveyor = "{" +
                "\"username\":\"" + SURVEYOR_NAME + "\"" +
                ",\"firstName\":\"" + SURVEYOR_NAME + "\"" +
                ",\"lastName\":\"" + SURVEYOR_NAME + "\"" +
                ",\"hashedPassword\":\"" + "####" + "\"" +
                '}';
        survey_with_questions = "{\"name\" : \"Survey2\", \"questions\": [{\"type\": \"text\",\"question\": \"question\"}]}";
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
    void createSurveyWithQuestions() throws Exception {
        mvc.perform(post(CONTROLLER_URL + SURVEYOR_NAME + "/surveys")
                .contentType(MediaType.APPLICATION_JSON).content(survey_with_questions)).andExpect(status().isCreated());
    }
    @Test
    @Order(4)
    void addQuestions() throws Exception {
        mvc.perform(post(CONTROLLER_URL + "/survey/1/questions")
                .contentType(MediaType.APPLICATION_JSON).content(text_question)).andExpect(status().isCreated());
        mvc.perform(post(CONTROLLER_URL + "/survey/1/questions")
                .contentType(MediaType.APPLICATION_JSON).content(number_question)).andExpect(status().isCreated());
        mvc.perform(post(CONTROLLER_URL + "/survey/1/questions")
                .contentType(MediaType.APPLICATION_JSON).content(multiple_choice_question)).andExpect(status().isCreated());
    }

    @Test
    @Order(6)
    void getSurveys() throws Exception {
        mvc.perform(get(CONTROLLER_URL + SURVEYOR_NAME + "/surveys")).andExpect(status().isOk());
    }

    @Test
    @Order(7)
    void getSurvey() throws Exception {
        mvc.perform(get(CONTROLLER_URL + SURVEYOR_NAME + "/survey")
                .param("name", "survey_1")).andExpect(status().isOk());
    }
}