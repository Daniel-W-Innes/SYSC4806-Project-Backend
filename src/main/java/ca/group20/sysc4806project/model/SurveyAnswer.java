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
public class SurveyAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long answerId;

    @ManyToOne(targetEntity = Survey.class)
    @JoinColumn(name="surveyId")
    private Long surveyId;

    @ManyToOne(targetEntity = Question.class)
    @JoinColumn(name="questionId")
    private Long questionId;

    public SurveyAnswer(Long surveyId, Long questionId) {
        this.surveyId = surveyId;
        this.questionId = questionId;
    }

    public Long getAnswerId() {
        return this.answerId;
    }

    public Long getSurveyId() {
        return this.surveyId;
    }

    public Long getQuestionId() {
        return this.questionId;
    }

    @Override
    public String toString() {
        return "SurveyAnswer{" +
                "answerId=" + answerId +
                ", surveyId=" + surveyId +
                ", questionId=" + questionId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SurveyAnswer that = (SurveyAnswer) o;
        return Objects.equals(answerId, that.answerId) && Objects.equals(surveyId, that.surveyId) && Objects.equals(questionId, that.questionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerId, surveyId, questionId);
    }
}
