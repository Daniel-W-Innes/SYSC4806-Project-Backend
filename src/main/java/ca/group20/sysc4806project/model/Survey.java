package ca.group20.sysc4806project.model;

import ca.group20.sysc4806project.model.question.Question;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A survey stores a list of questions, a surveyor can have multiple surveys
 */
@Entity
@NoArgsConstructor
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Surveyor surveyor;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "survey", cascade = CascadeType.REMOVE)
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

    public boolean addQuestion(Question q) {
        return questions.add(q);
    }

    public boolean removeQuestion(Question q) {
        return questions.remove(q);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Boolean hasQuestion(Question question) {
        return questions.contains(question);
    }

    /**
     * Converts Object to string
     */
    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", surveyorId=" + getSurveyorId() +
                ", name='" + name + '\'' +
                ", questions=" + questions +
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
        Survey survey = (Survey) o;
        if (Objects.equals(id, survey.getId())) return true;
        return Objects.equals(getSurveyorId(), survey.getSurveyorId()) && Objects.equals(name, survey.getName()) && Objects.equals(questions, survey.getQuestions());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getSurveyorId(), name, questions);
    }
}
