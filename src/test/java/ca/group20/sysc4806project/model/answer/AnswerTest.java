package ca.group20.sysc4806project.model.answer;

import ca.group20.sysc4806project.model.Survey;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class AnswerTest {

    private Survey test_survey;

    @BeforeEach
    public void setUp() {
        test_survey = new Survey("Cool Survey");
    }

    @Test
    public void setSurvey() {
        TextAnswer test_answer = new TextAnswer();
        test_answer.setSurvey(test_survey);
        assertEquals(test_survey.getId(), test_answer.getSurveyId());
    }

    @Test
    public void setAnswer() {
        TextAnswer test_answer = new TextAnswer();
        test_answer.setAnswer("Amazing Answer");
        assertEquals("Amazing Answer", test_answer.getAnswer());
    }

    @Test
    public void compareAnswers() {
        TextAnswer test_answer1 = new TextAnswer();
        test_answer1.setAnswer("Amazing Answer");
        TextAnswer test_answer2 = new TextAnswer();
        test_answer2.setAnswer("Terrible Answer");
        assertNotEquals(test_answer1, test_answer2);
    }
}