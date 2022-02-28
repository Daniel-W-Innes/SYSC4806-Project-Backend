package ca.group20.sysc4806project.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Objects;

@NoArgsConstructor
@Entity
public class NumberQuestion extends Question{
    private int max;
    private int min;

    public NumberQuestion(Long surveyId, String question, int max, int min) {
        super(surveyId, question);

        this.max = max;
        this.min = min;
    }

    public int getMax() {
        return this.max;
    }

    public int getMin() {
        return this.min;
    }

    public void setMax() { this.max = max; }

    public void setMin() { this.min = min; }

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
