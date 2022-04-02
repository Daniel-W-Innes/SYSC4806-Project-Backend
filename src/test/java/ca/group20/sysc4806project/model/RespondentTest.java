package ca.group20.sysc4806project.model;

import ca.group20.sysc4806project.model.answer.NumberAnswer;
import ca.group20.sysc4806project.model.question.MultipleChoiceQuestion;
import ca.group20.sysc4806project.model.question.NumberQuestion;
import ca.group20.sysc4806project.model.question.Question;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RespondentTest {
    private Respondent resp_1;
    private Respondent resp_2;
    private Respondent resp_3;
    private NumberQuestion num_quest_0;
    private MultipleChoiceQuestion multi_quest;
    private Survey survey;

    @BeforeEach
    void setUp() {
        survey = new Survey("Cool Survey");
        resp_1 = new Respondent();
        resp_2 = new Respondent();
        resp_3 = new Respondent();
        num_quest_0 = new NumberQuestion("1 out of 5?",0,5);
        survey.addQuestion(num_quest_0);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void compareAnswer() {
        NumberAnswer answer_1 = new NumberAnswer(1);
        answer_1.setQuestion(num_quest_0);
        resp_1.addAnswer(answer_1);
        survey.addRespondents(resp_1);

        NumberAnswer answer_2 = new NumberAnswer(1);
        answer_2.setQuestion(num_quest_0);
        resp_2.addAnswer(answer_2);
        survey.addRespondents(resp_2);

        NumberAnswer answer_3 = new NumberAnswer(3);
        answer_3.setQuestion(num_quest_0);
        resp_3.addAnswer(answer_3);
        survey.addRespondents(resp_3);

        List<Respondent> result = survey.sameAnswerRespondentList(answer_1);

        assertEquals(2,result.size());

        result = survey.sameAnswerRespondentList(answer_3);

        assertEquals(1,result.size());
    }
}