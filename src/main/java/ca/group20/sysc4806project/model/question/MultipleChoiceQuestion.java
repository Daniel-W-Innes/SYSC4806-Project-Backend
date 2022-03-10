package ca.group20.sysc4806project.model.question;

import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Extends Question, for creating a multiple choice question
 */
@Entity
@NoArgsConstructor
public class MultipleChoiceQuestion extends Question {

    @ElementCollection
    private Set<String> options;

    public MultipleChoiceQuestion(String question) {
        super(question);
        this.options = new HashSet<>();
    }

    public boolean addOption(String option) {
        return options.add(option);
    }

    public boolean removeOption(String option) {
        return options.remove(option);
    }

    public Set<String> getOptions() {
        return options;
    }

    /**
     * Converts Object to string
     */
    @Override
    public String toString() {
        return "MultipleChoiceQuestion{" +
                "options=" + options +
                '}';
    }

    /**
     * Compares two objects to see if they are equal
     * @param o the other object
     * @return are they equal, boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MultipleChoiceQuestion that = (MultipleChoiceQuestion) o;
        return Objects.equals(options, that.options);
    }

    @Override
    public int hashCode() {
        return Objects.hash(options);
    }
}
