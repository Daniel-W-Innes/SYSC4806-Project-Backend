package ca.group20.sysc4806project.model;

import javax.persistence.Entity;

@Entity
public class LongAnswerQuestion extends Question {

    String answer; //need?

    public LongAnswerQuestion(Long surveyID, String question) {
        super(surveyID, QuestionType.LONG_ANSWER, question);
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return this.answer;
    }
}
