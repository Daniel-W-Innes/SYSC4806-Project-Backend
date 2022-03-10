package ca.group20.sysc4806project.model;

import ca.group20.sysc4806project.model.question.NumberQuestion;
import ca.group20.sysc4806project.model.question.Question;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SurveyTest {

    private Survey test_survey;

    @BeforeEach
    public void setUp() throws Exception {
        test_survey = new Survey("Cool Survey");
    }

    @AfterEach
    public void tearDown() throws Exception {
        test_survey = null;
    }

    @Test
    public void addQuestion(){
        Question test_question = new NumberQuestion("What time is it?",5,2);
        assertEquals(true,test_survey.addQuestion(test_question));
        System.out.println("Success! Successfully added a question!");
    }

    @Test
    public void removeQuestion(){
        Question test_question = new NumberQuestion("What time is it?",5,2);
        assertEquals(true,test_survey.addQuestion(test_question));
        test_survey.removeQuestion(test_question);
        assertEquals(false,test_survey.hasQuestion(test_question));
        System.out.println("Success! Successfully removed a question!");
    }

}