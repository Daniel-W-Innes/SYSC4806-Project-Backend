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
public class MultipleChoiceQuestion extends TextAnswerable {

    @ElementCollection
    private Set<String> options;

    private MultipleChoiceType displayFormat;

    public MultipleChoiceQuestion(String question, MultipleChoiceType displayFormat) {
        super(question);
        this.displayFormat = displayFormat;
        this.options = new HashSet<>();
    }

    public MultipleChoiceQuestion(String question, MultipleChoiceType displayFormat, Set<String> options) {
        super(question);
        this.displayFormat = displayFormat;
        this.options = options;
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

    public MultipleChoiceType getDisplayFormat() {
        return displayFormat;
    }

    public void setDisplayFormat(MultipleChoiceType displayFormat) {
        this.displayFormat = displayFormat;
    }

    /**
     * Converts Object to string
     */
    @Override
    public String toString() {
        return "MultipleChoiceQuestion{" +
                "options=" + options +
                ", displayFormat=" + displayFormat +
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
        MultipleChoiceQuestion multi_ques = (MultipleChoiceQuestion) o;
        return Objects.equals(options, multi_ques.getOptions()) && Objects.equals(displayFormat, multi_ques.getDisplayFormat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(options, displayFormat);
    }
}
