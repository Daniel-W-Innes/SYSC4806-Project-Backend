package ca.group20.sysc4806project.model.answer;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Objects;

/**
 * Extends Answer, for long answer questions
 */
@Entity
@NoArgsConstructor
public class TextAnswer extends Answer { // answer to a long answer question

    private String answer;

    public TextAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Converts Object to string
     */
    @Override
    public String toString() {
        return "TextAnswer{" +
                "answer='" + answer + '\'' +
                '}';
    }

    /**
     * Compares two objects to see if they are equal
     * @param o the other object
     * @return are they equal, boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TextAnswer text_ans = (TextAnswer) o;
        return Objects.equals(answer, text_ans.getAnswer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), answer);
    }
}
