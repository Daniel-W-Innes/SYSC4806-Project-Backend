package ca.group20.sysc4806project.model;

public class Question {
    private QuestionType type;
    private String question;

    public Question(QuestionType type, String question) {
        this.type = type;
        this.question = question;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
