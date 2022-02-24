package ca.group20.sysc4806project.model;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceQuestion extends Question {

    List<String> options;

    public MultipleChoiceQuestion(QuestionType type, String question) {
        super(type, question);

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
