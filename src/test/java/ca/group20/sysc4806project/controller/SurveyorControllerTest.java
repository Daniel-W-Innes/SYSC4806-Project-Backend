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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static util.ToJson.surveyorJson;

@SpringBootTest
@AutoConfigureMockMvc
class SurveyorControllerTest {

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
        String username = "username";
        String firstName = "firstName";
        String lastName = "lastName";
        String hashedPassword = "hashedPassword";

        mvc.perform(post(controller_url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(surveyorJson(username, firstName, lastName, hashedPassword)))
                .andExpectAll(
                        status().isCreated(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        jsonPath("$.username").value(username),
                        jsonPath("$.firstName").value(firstName),
                        jsonPath("$.lastName").value(lastName),
                        jsonPath("$.hashedPassword").value(hashedPassword));
        assertEquals(new Surveyor(username,firstName,lastName,hashedPassword), surveyorRepo.findByUsername(username));
    }
}