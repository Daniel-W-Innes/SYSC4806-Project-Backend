package ca.group20.sysc4806project.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MultipleChoiceQuestion extends Question {

    @ElementCollection
    List<String> options;

    public MultipleChoiceQuestion(Long surveyId, QuestionType type, String question) {
        super(surveyId, type, question);

        this.options = new ArrayList<String>();
    }

    public boolean addOption(String option) {
        if(!this.options.contains(option)) {
            this.options.add(option);
            return true;
        }
        return false;
    }

    public boolean removeOption(String option) {
        return this.options.remove(option);
    }

    public List<String> getOptions() {
        return this.options;
    }
}
