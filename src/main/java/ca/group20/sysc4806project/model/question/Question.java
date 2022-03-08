package ca.group20.sysc4806project.model.question;

import ca.group20.sysc4806project.model.Survey;
import ca.group20.sysc4806project.model.Surveyor;
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
    private Long questionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "surveyId")
    private Survey survey;

    private String question;

    public Question(String question) {
        this.question = question;
    }

    public void setSurvey(Survey survey) { this.survey = survey; }

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
        return survey.getSurveyId();
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", surveyId=" + getSurveyId() +
                ", question='" + question + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        if (Objects.equals(questionId, question1.questionId)) return true;
        return Objects.equals(getSurveyId(), question1.getSurveyId()) && Objects.equals(question, question1.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSurveyId(), question);
    }
}
