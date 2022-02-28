package ca.group20.sysc4806project.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@NoArgsConstructor
@Entity
public class LongAnswerQuestion extends Question {

    public LongAnswerQuestion(Long surveyId, String question) {
        super(surveyId, question);
    }

    @Override
    public String toString() {
        return "LongAnswerQuestion{}";
    }
}
