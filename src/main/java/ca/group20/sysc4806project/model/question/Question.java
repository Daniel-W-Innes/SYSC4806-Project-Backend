package ca.group20.sysc4806project.model.question;

import ca.group20.sysc4806project.model.Survey;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long questionId;

    @ManyToOne(targetEntity = Survey.class)
    @JoinColumn(name = "surveyId")
    private Long surveyId;

    private String question;

    public Question(Long surveyId, String question) {
        this.surveyId = surveyId;
        this.question = question;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", surveyId=" + surveyId +
                ", question='" + question + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        if (Objects.equals(questionId, question1.questionId)) return true;
        return Objects.equals(surveyId, question1.surveyId) && Objects.equals(question, question1.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surveyId, question);
    }
}
