package ca.group20.sysc4806project.model.answer;

import ca.group20.sysc4806project.model.Survey;
import ca.group20.sysc4806project.model.question.Question;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

/**
 * Answers are assigned to questions in surveys, a question can have more than one answer
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Survey survey;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    public Long getId() {
        return id;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Long getSurveyId() {
        return survey.getId();
    }

    public Long getQuestionId() {
        return question.getId();
    }

    /**
     * Converts Object to string
     */
    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", surveyId=" + getSurveyId() +
                ", questionId=" + getQuestionId() +
                '}';
    }

    /**
     * Compares two objects to see if they are equal
     * @param o the other object
     * @return are they equal, boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer that = (Answer) o;
        if (Objects.equals(id, that.id)) return true;
        return Objects.equals(getSurveyId(), that.getSurveyId()) && Objects.equals(getQuestionId(), that.getQuestionId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getSurveyId(), getQuestionId());
    }
}
