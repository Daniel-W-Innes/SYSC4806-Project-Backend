package ca.group20.sysc4806project.model;

import ca.group20.sysc4806project.model.question.Question;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long surveyId;

    @ManyToOne(targetEntity = Surveyor.class)
    @JoinColumn(name = "surveyorId")
    private Long surveyorId;

    private String name;

    @OneToMany(targetEntity = Question.class, mappedBy = "surveyId")
    private List<Question> questions;

    public Survey(Long surveyorId, String name) {
        this.name = name;
        this.surveyorId = surveyorId;
        this.questions = new ArrayList<>();
    }

    public Long getSurveyId() {
        return surveyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public Long getSurveyorId() {
        return surveyorId;
    }

    public boolean addQuestion(Question q) {
        return questions.add(q);
    }

    public boolean removeQuestion(Question q) {
        return questions.remove(q);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "surveyId=" + surveyId +
                ", surveyorId=" + surveyorId +
                ", name='" + name + '\'' +
                ", questions=" + questions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Survey survey = (Survey) o;
        return Objects.equals(surveyId, survey.surveyId) && Objects.equals(surveyorId, survey.surveyorId) && Objects.equals(name, survey.name) && Objects.equals(questions, survey.questions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surveyId, surveyorId, name, questions);
    }
}
