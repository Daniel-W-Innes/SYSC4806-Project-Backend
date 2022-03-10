package ca.group20.sysc4806project.model.answer;

import ca.group20.sysc4806project.model.Survey;
import ca.group20.sysc4806project.model.question.Question;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnswerTest {

    private Question test_question;
    private  Survey test_survey;

    @BeforeEach
    public void setUp() throws Exception {
         test_question = new Question("What day is it?");
         test_survey = new Survey("Cool Survey");
    }

    @AfterEach
    public void tearDown() throws Exception {
        test_question = null;
        test_survey = null;
    }

    @Test
    public void setSurvey() {
        TextAnswer test_answer = new TextAnswer();
        test_answer.setSurvey(test_survey);
        assertEquals(test_survey.getId(),test_answer.getSurveyId());
        System.out.println("Answer contains the same Survey!");
    }
    @Test
    public void setQuestion() {
        TextAnswer test_answer = new TextAnswer();
        test_answer.setQuestion(test_question);
        assertEquals(test_question.getId(),test_answer.getQuestionId());
        System.out.println("Answer contains the same Question!");
    }
    @Test
    public void setAnswer(){
        TextAnswer test_answer = new TextAnswer();
        test_answer.setAnswer("Amazing Answer");
        assertEquals("Amazing Answer",test_answer.getAnswer());
        System.out.println("Answer contains the inputted Answer!");
    }

    @Test
    public void compareAnswers(){
        TextAnswer test_answer1 = new TextAnswer();
        test_answer1.setAnswer("Amazing Answer");
        TextAnswer test_answer2 = new TextAnswer();
        test_answer2.setAnswer("Terrible Answer");
        assertEquals(false,test_answer1.equals(test_answer2));
        System.out.println("Answer equals statement works!");
    }
}