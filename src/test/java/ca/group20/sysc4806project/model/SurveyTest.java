package ca.group20.sysc4806project.model;

import ca.group20.sysc4806project.model.question.NumberQuestion;
import ca.group20.sysc4806project.model.question.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SurveyTest {
    private Survey test_survey;

    @BeforeEach
    public void setUp() {
        test_survey = new Survey("Cool Survey");
    }

    @Test
    public void addQuestion() {
        Question test_question = new NumberQuestion("What time is it?", 5, 2);
        assertTrue(test_survey.addQuestion(test_question));
    }

    @Test
    public void removeQuestion() {
        Question test_question = new NumberQuestion("What time is it?", 5, 2);
        assertTrue(test_survey.addQuestion(test_question));
        test_survey.removeQuestion(test_question);
        assertFalse(test_survey.hasQuestion(test_question));
    }

}