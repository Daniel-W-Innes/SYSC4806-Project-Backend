package ca.group20.sysc4806project.controller;

import ca.group20.sysc4806project.model.Survey;
import ca.group20.sysc4806project.model.Surveyor;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SurveyorControllerTest {

    @Autowired
    private MockMvc mvc;
    final private String surveyor_name = "Desha";
    private String test_surveyor;
    private String survey_1;
    private String survey_2;
    final private String controller_url = "/api/v0/surveyors/";
    final private int HTTP_CREATED =  201;


    @BeforeEach
    void setUp(){
        test_surveyor = "{" +
                "\"username\":\"" + surveyor_name + "\"" +
                ",\"firstName\":\"" + surveyor_name + "\"" +
                ",\"lastName\":\"" + surveyor_name + "\"" +
                ",\"hashedPassword\":\"" + "####" + "\"" +
                '}';
        survey_1 = "{\"name\" : \"Survey1\"}";
        survey_2 = "{\"name\" : \"Survey2\"}";
    }

    @Test
    @Order(1)
    void createSurveyor() throws Exception {
        mvc.perform(post(controller_url).contentType(MediaType.APPLICATION_JSON)
                .content(test_surveyor)).andExpect(status().is(HTTP_CREATED));
    }

    @Test
    @Order(2)
    void getSurveyor() throws Exception{
        mvc.perform(get(controller_url + surveyor_name)).andExpect(status().isOk());
    }

    @Test
    @Order(3)
    void createSurvey() throws Exception{
        mvc.perform(post(controller_url + surveyor_name +"/surveys")
                .contentType(MediaType.APPLICATION_JSON).content(survey_1)).andExpect(status().is(HTTP_CREATED));
        mvc.perform(post(controller_url + surveyor_name +"/surveys")
                .contentType(MediaType.APPLICATION_JSON).content(survey_2)).andExpect(status().is(HTTP_CREATED));
    }

    @Test
    @Order(4)
    void getSurveys() throws Exception{
        mvc.perform(get(controller_url + surveyor_name +"/surveys")).andExpect(status().isOk());
    }

    @Test
    @Order(5)
    void getSurvey() throws Exception{
        mvc.perform(get(controller_url + surveyor_name +"/survey")
                .param("name","survey_1")).andExpect(status().isOk());
    }
}