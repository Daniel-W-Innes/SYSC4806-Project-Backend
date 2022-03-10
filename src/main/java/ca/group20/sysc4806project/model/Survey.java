package ca.group20.sysc4806project.model;

import ca.group20.sysc4806project.model.question.Question;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Surveyor surveyor;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "survey")
    private List<Question> questions;

    public Survey(String name) {
        this.name = name;
        this.questions = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setSurveyor(Surveyor surveyor) {
        this.surveyor = surveyor;
    }

    public Long getSurveyorId() {
        return surveyor.getId();
    }

    public List<Question> getQuestions() {
        return questions;
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

    public Boolean hasQuestion(Question question){
        return questions.contains(question);
    }

    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", surveyorId=" + getSurveyorId() +
                ", name='" + name + '\'' +
                ", questions=" + questions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Survey survey = (Survey) o;
        if (Objects.equals(id, survey.getId())) return true;
        return Objects.equals(getSurveyorId(), survey.getSurveyorId()) && Objects.equals(name, survey.getName()) && Objects.equals(questions, survey.getQuestions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getSurveyorId(), name, questions);
    }
}
