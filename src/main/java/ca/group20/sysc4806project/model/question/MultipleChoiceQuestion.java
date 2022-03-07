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
    Set<String> options;

    public MultipleChoiceQuestion(Long surveyId, String question) {
        super(surveyId, question);

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

    @Override
    public String toString() {
        return "MultipleChoiceQuestion{" +
                "options=" + options +
                '}';
    }

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
