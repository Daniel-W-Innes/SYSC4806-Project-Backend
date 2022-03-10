package ca.group20.sysc4806project.model.question;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuestionTest {

    private MultipleChoiceQuestion mult_question;
    private String question_str;

    @BeforeEach
    public void setUp() throws Exception {
        question_str = "What time is it?";
        mult_question = new MultipleChoiceQuestion(question_str,MultipleChoiceType.MULTI_SELECTION);
    }

    @AfterEach
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