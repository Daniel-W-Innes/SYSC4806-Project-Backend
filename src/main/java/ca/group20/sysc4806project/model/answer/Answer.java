package ca.group20.sysc4806project.model.answer;

import ca.group20.sysc4806project.model.Survey;
import ca.group20.sysc4806project.model.question.Question;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long answerId;

    @ManyToOne(targetEntity = Survey.class)
    @JoinColumn(name = "surveyId")
    private Long surveyId;

    @ManyToOne(targetEntity = Question.class)
    @JoinColumn(name = "questionId")
    private Long questionId;

    public Answer(Long surveyId, Long questionId) {
        this.surveyId = surveyId;
        this.questionId = questionId;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", surveyId=" + surveyId +
                ", questionId=" + questionId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer that = (Answer) o;
        if (Objects.equals(answerId, that.answerId)) return true;
        return Objects.equals(surveyId, that.surveyId) && Objects.equals(questionId, that.questionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerId, surveyId, questionId);
    }
}
