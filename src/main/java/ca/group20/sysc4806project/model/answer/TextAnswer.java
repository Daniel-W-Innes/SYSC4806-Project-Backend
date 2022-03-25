package ca.group20.sysc4806project.model.answer;

import ca.group20.sysc4806project.model.question.TextAnswerable;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.Objects;

/**
 * Extends Answer, for long answer questions
 */
@Entity
@NoArgsConstructor
public class TextAnswer extends Answer { // answer to a long answer question

    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    private TextAnswerable question;

    public TextAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getQuestionId() {
        return question.getId();
    }

    public void setQuestion(TextAnswerable question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "TextAnswer{" +
                "answer='" + answer + '\'' +
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
        if (!(o instanceof TextAnswer)) return false;
        if (!super.equals(o)) return false;
        TextAnswer that = (TextAnswer) o;
        return Objects.equals(answer, that.answer) && Objects.equals(question, that.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), answer, question);
    }
}
