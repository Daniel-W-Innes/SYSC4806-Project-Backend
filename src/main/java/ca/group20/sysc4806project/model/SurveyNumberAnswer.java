package ca.group20.sysc4806project.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
@NoArgsConstructor
public class SurveyNumberAnswer extends SurveyAnswer { // answer to a number question
    private int answer;

    public SurveyNumberAnswer(Long surveyId, Long questionId, int answer) {
        super(surveyId, questionId);

        this.answer = answer;
    }

    public int getAnswer() {
        return this.answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "SurveyNumberAnswer{" +
                "answer=" + answer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SurveyNumberAnswer that = (SurveyNumberAnswer) o;
        return answer == that.answer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), answer);
    }
}
