package ca.group20.sysc4806project.model.question;

import ca.group20.sysc4806project.model.Survey;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

/**
 * For creating a question, there can be multiple questions in one survey
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextAnswerable.class, name = "text"),
        @JsonSubTypes.Type(value = NumberQuestion.class, name = "number"),
        @JsonSubTypes.Type(value = MultipleChoiceQuestion.class, name = "multipleChoice")
})
public abstract class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Survey survey;

    private String question;

    public Question(String question) {
        this.question = question;
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

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public Survey getSurvey() {
        return survey;
    }

    /**
     * Converts Object to string
     */
    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", surveyId=" + getSurveyId() +
                ", question='" + question + '\'' +
                '}';
    }

    /**
     * Compares two objects to see if they are equal
     *
     * @param o the other object
     * @return are they equal, boolean
     */
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
