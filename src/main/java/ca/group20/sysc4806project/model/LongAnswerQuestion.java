package ca.group20.sysc4806project.model;

public class LongAnswerQuestion extends Question {

    String answer; //need?

    public LongAnswerQuestion(String question) {
        super(QuestionType.LONG_ANSWER, question);
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return this.answer;
    }
}
