package ca.group20.sysc4806project.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long questionId;

    @ManyToOne(targetEntity = Survey.class)
    @JoinColumn(name="surveyId")
    private Long surveyId;

    private String question;

    public Question(Long surveyId, String question) {
        this.surveyId = surveyId;
        this.question = question;
    }

    public Long getQuestionId() {
        return this.questionId;
    }

    public String getQuestion() {
        return this.question;
    }

    public Long getSurveyId() { return this.surveyId; }

    public void setQuestion(String question) {
        this.question = question;
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
        return questionId.equals(question1.questionId) && surveyId.equals(question1.surveyId) && question.equals(question1.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, surveyId, question);
    }
}
