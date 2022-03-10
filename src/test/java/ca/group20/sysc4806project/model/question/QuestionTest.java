package ca.group20.sysc4806project.model.question;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionTest {

    private MultipleChoiceQuestion multi_question;
    private String question_str;

    @BeforeEach
    public void setUp() {
        question_str = "What time is it?";
        multi_question = new MultipleChoiceQuestion(question_str, MultipleChoiceType.MULTI_SELECTION);
    }


    @Test
    public void addOptions() {
        multi_question.addOption("1pm");
        multi_question.addOption("2pm");
        multi_question.addOption("7pm");
        assertEquals(3, multi_question.getOptions().size());
    }

    @Test
    public void checkQuestion() {
        assertEquals(question_str, multi_question.getQuestion());
    }
}