package ca.group20.sysc4806project.controller;

import ca.group20.sysc4806project.model.Survey;
import ca.group20.sysc4806project.model.Surveyor;
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

    @Autowired
    private MockMvc mvc;
    private static String surveyor_name = "Frank";
    private Surveyor test_surveyor;
    private Survey survey_1;
    private Survey survey_2;

    @BeforeEach
    void setUp(){

        test_surveyor = new Surveyor(surveyor_name,surveyor_name,surveyor_name,"####");
        survey_1 = new Survey("Survey_1");
        survey_2 = new Survey("Survey_2");
    }

    @Test
    @Order(1)
    void createSurveyor() throws Exception {
        mvc.perform(post("/api/v0/surveyors").contentType(MediaType.APPLICATION_JSON)
                .content(test_surveyor.toJson())).andExpect(status().is(201));
        System.out.println("Successfully adds Surveyor to Database!");
    }

    @Test
    @Order(2)
    void getSurveyor() throws Exception{
        mvc.perform(get("/api/v0/surveyors/" + test_surveyor.getUsername())).andExpect(status().isOk());
        System.out.println("Successfully gets Surveyor from Database!");
    }

    @Test
    @Order(3)
    void createSurvey() throws Exception{
        mvc.perform(post("/api/v0/surveyors/" + test_surveyor.getUsername() +"/surveys")
                .contentType(MediaType.APPLICATION_JSON).content(survey_1.toJson())).andExpect(status().is(201));
        mvc.perform(post("/api/v0/surveyors/" + test_surveyor.getUsername() +"/surveys")
                .contentType(MediaType.APPLICATION_JSON).content(survey_2.toJson())).andExpect(status().is(201));
        System.out.println("Successfully added two surveys to Surveyor!");

    }

    @Test
    @Order(4)
    void getSurveys() throws Exception{
        mvc.perform(get("/api/v0/surveyors/" + test_surveyor.getUsername() +"/surveys")).andExpect(status().isOk());
        System.out.println("Successfully gets multiple surveys from Database!");

    }

    @Test
    @Order(5)
    void getSurvey() throws Exception{
        mvc.perform(get("/api/v0/surveyors/" + test_surveyor.getUsername() +"/survey")
                .param("name",survey_1.getName())).andExpect(status().isOk());
        System.out.println("Successfully gets multiple surveys from Database!");
    }
}