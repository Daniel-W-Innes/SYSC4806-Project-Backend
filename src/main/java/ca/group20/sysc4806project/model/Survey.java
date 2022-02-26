package ca.group20.sysc4806project.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name="surveyID")
    private Long id;

    @JoinColumn(name="surveyorID")
    @ManyToOne(targetEntity = Surveyor.class)
    private Long ownerID;

    private String name;

    @OneToMany(targetEntity=Question.class, mappedBy="surveyID")
    private List<Question> questions;

    public Survey(Long ownerID, String name) {
        this.name = name;
        this.ownerID = ownerID;
        this.questions = new ArrayList<Question>();
    }

    public Long getID() { return this.id; }

    public String getName() {
        return this.name;
    }

    public Long getOwnerID() { return this.ownerID; }

    public void setName(String n) {
        this.name = n;
    }

    public boolean addQuestion(Question q) {
        if(!this.questions.contains(q)) {
            this.questions.add(q);
            return true;
        }
        return false;
    }

    public boolean removeOption(String q) {
        return this.questions.remove(q);
    }

    public List<Question> getQuestions() {
        return this.questions;
    }
}
