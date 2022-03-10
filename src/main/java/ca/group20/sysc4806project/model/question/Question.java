package ca.group20.sysc4806project.model.question;

import ca.group20.sysc4806project.model.Survey;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Survey survey;

    private String question;

    public Question(String question) {
        this.question = question;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getSurveyId() {
        return survey.getId();
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", surveyId=" + getSurveyId() +
                ", question='" + question + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question ques = (Question) o;
        if (Objects.equals(id, ques.getId())) return true;
        return Objects.equals(id, ques.getSurveyId()) && Objects.equals(question, ques.getQuestion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSurveyId(), question);
    }
}
