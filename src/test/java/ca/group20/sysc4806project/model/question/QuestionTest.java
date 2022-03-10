package ca.group20.sysc4806project.model.question;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionTest {

    private MultipleChoiceQuestion mult_question;
    private String question_str;

    @Before
    public void setUp() throws Exception {
        question_str = "What time is it?";
        mult_question = new MultipleChoiceQuestion(question_str);
    }

    @After
    public void tearDown() throws Exception {
        mult_question = null;
        question_str = null;
    }

    @Test
    public void addOptions(){
        mult_question.addOption("1pm");
        mult_question.addOption("2pm");
        mult_question.addOption("7pm");
        assertEquals(3,mult_question.getOptions().size());
        System.out.println("SUCCESS! Questions can store multiple options!");
    }

    @Test
    public void checkQuestion(){
        assertEquals(question_str,mult_question.getQuestion());
        System.out.println("SUCCESS! Questions value is stored properly");
    }
}