package ca.group20.sysc4806project.model;

import ca.group20.sysc4806project.model.question.NumberQuestion;
import ca.group20.sysc4806project.model.question.Question;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SurveyTest {

    private Survey test_survey;

    @Before
    public void setUp() throws Exception {
        test_survey = new Survey("Cool Survey");
    }

    @After
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