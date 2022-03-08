package ca.group20.sysc4806project.model.answer;

import ca.group20.sysc4806project.model.Survey;
import ca.group20.sysc4806project.model.question.Question;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "surveyId")
    private Survey survey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionId")
    private Question question;

    public Long getAnswerId() {
        return answerId;
    }

    public void setSurvey(Survey survey) { this.survey = survey; }

    public void setQuestion(Question question) { this.question = question; }

    public Long getSurveyId() {
        return survey.getSurveyId();
    }

    public Long getQuestionId() {
        return question.getQuestionId();
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", surveyId=" + getSurveyId() +
                ", questionId=" + getQuestionId() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer that = (Answer) o;
        if (Objects.equals(answerId, that.answerId)) return true;
        return Objects.equals(getSurveyId(), that.getSurveyId()) && Objects.equals(getQuestionId(), that.getQuestionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerId, getSurveyId(), getQuestionId());
    }
}
