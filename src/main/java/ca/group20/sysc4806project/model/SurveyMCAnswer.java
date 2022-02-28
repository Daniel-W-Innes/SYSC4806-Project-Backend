package ca.group20.sysc4806project.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
@NoArgsConstructor
public class SurveyMCAnswer extends SurveyAnswer { // answer to a MC question
    private String answer; // Selected choice

    public SurveyMCAnswer(Long surveyId, Long questionId, String answer) {
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
        return "SurveyMCAnswer{" +
                "answer='" + answer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SurveyMCAnswer that = (SurveyMCAnswer) o;
        return Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), answer);
    }
}
