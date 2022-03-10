package ca.group20.sysc4806project.model.question;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Objects;

/**
 * Extends Question, for creating a number question
 */
@Entity
@NoArgsConstructor
public class NumberQuestion extends Question {

    private int max;
    private int min;

    public NumberQuestion(String question, int max, int min) {
        super(question);
        this.max = max;
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    /**
     * Converts Object to string
     */
    @Override
    public String toString() {
        return "NumberQuestion{" +
                "max=" + max +
                ", min=" + min +
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
        NumberQuestion num_ques = (NumberQuestion) o;
        return max == num_ques.getMax() && min == num_ques.getMin();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), max, min);
    }
}
