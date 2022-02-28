package ca.group20.sysc4806project.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NoArgsConstructor
public class SurveyTextAnswer extends SurveyAnswer { // answer to a long answer question
    private String answer;

    public SurveyTextAnswer(Long surveyId, Long questionId, String answer) {
        super(surveyId, questionId);

        this.answer = answer;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "SurveyTextAnswer{" +
                "answer='" + answer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SurveyTextAnswer that = (SurveyTextAnswer) o;
        return Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), answer);
    }
}
