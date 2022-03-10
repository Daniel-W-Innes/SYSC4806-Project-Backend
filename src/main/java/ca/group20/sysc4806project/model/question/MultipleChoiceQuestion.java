package ca.group20.sysc4806project.model.question;

import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@NoArgsConstructor
public class MultipleChoiceQuestion extends Question {

    @ElementCollection
    private Set<String> options;

    private MultipleChoiceType type;

    public MultipleChoiceQuestion(String question, MultipleChoiceType type) {
        super(question);
        this.type = type;
        this.options = new HashSet<>();
    }

    public Set<String> getOptions() {
        return options;
    }

    public boolean addOption(String option) {
        return options.add(option);
    }

    public boolean removeOption(String option) {
        return options.remove(option);
    }

    public MultipleChoiceType getType() {
        return type;
    }

    public void setType(MultipleChoiceType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MultipleChoiceQuestion{" +
                "options=" + options +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultipleChoiceQuestion multi_ques = (MultipleChoiceQuestion) o;
        return Objects.equals(options, multi_ques.getOptions())  && Objects.equals(type, multi_ques.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(options, type);
    }
}
