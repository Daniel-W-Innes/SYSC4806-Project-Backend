package ca.group20.sysc4806project.model.question;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
@NoArgsConstructor
public class NumberQuestion extends Question {
    private int max;
    private int min;

    public NumberQuestion(Long surveyId, String question, int max, int min) {
        super(surveyId, question);

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

    @Override
    public String toString() {
        return "NumberQuestion{" +
                "max=" + max +
                ", min=" + min +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NumberQuestion that = (NumberQuestion) o;
        return max == that.max && min == that.min;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), max, min);
    }
}
