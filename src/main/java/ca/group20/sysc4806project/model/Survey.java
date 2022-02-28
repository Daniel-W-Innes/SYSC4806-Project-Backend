package ca.group20.sysc4806project.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long surveyId;

    @ManyToOne(targetEntity = Surveyor.class)
    @JoinColumn(name="surveyorId")
    private Long surveyorId;

    private String name;

    @OneToMany(targetEntity=Question.class, mappedBy = "surveyId")
    private List<Question> questions;

    public Survey(Long surveyorId, String name) {
        this.name = name;
        this.surveyorId = surveyorId;
        this.questions = new ArrayList<Question>();
    }

    public Long getSurveyId() { return this.surveyId; }

    public String getName() {
        return this.name;
    }

    public Long getSurveyorId() { return this.surveyorId; }

    public void setName(String n) {
        this.name = n;
    }

    public boolean addQuestion(Question q) {
        return this.questions.add(q);
    }

    public boolean removeOption(String q) {
        return this.questions.remove(q);
    }

    public List<Question> getQuestions() {
        return this.questions;
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
