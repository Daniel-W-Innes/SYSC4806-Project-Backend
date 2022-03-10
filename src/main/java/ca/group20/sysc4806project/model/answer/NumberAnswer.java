package ca.group20.sysc4806project.model.answer;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
@NoArgsConstructor
public class NumberAnswer extends Answer { // answer to a number question

    private int answer;

    public NumberAnswer(int answer) {
        this.answer = answer;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "NumberAnswer{" +
                "answer=" + answer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NumberAnswer num_ans = (NumberAnswer) o;
        return answer == num_ans.getAnswer();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), answer);
    }
}
