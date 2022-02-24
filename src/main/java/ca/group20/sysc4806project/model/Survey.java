package ca.group20.sysc4806project.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    private Long id;

    private String name;
    private List<Question> questions;

    public Survey(String name) {
        this.name = name;
        this.questions = new ArrayList<Question>();
    }

    public String getName() {
        return this.name;
    }

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
