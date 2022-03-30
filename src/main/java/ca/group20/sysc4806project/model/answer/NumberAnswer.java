package ca.group20.sysc4806project.model.answer;

import ca.group20.sysc4806project.model.Respondent;
import ca.group20.sysc4806project.model.question.NumberQuestion;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Objects;

/**
 * Extends Answer, when the answer is for a number question
 */
@Entity
@NoArgsConstructor
public class NumberAnswer extends Answer { // answer to a number question

    private int answer;

    @ManyToOne(fetch = FetchType.LAZY)
    private NumberQuestion question;

    public NumberAnswer(int answer) {
        this.answer = answer;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public Long getQuestionId() {
        return question.getId();
    }

    public void setQuestion(NumberQuestion question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "NumberAnswer{" +
                "answer=" + answer +
                ", question=" + question +
                "} " + super.toString();
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
        if (!(o instanceof NumberAnswer)) return false;
        if (!super.equals(o)) return false;
        NumberAnswer that = (NumberAnswer) o;
        return answer == that.answer && Objects.equals(question, that.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), answer, question);
    }
}
