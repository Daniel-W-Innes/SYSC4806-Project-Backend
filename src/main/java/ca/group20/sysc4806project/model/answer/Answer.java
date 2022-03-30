package ca.group20.sysc4806project.model.answer;

import ca.group20.sysc4806project.model.Respondent;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

/**
 * Answers are assigned to questions in surveys, a question can have more than one answer
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = TextAnswer.class, name = "text"),
        @JsonSubTypes.Type(value = NumberAnswer.class, name = "number"),
})
public abstract class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Respondent respondent;

    public Long getId() {
        return id;
    }

    public Respondent getRespondent() {
        return respondent;
    }

    public void setRespondent(Respondent respondent) {
        this.respondent = respondent;
    }

    public abstract Long getQuestionId();

    /**
     * Converts Object to string
     */
    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                '}';
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
        if (o == null || getClass() != o.getClass()) return false;
        Answer ans = (Answer) o;
        return Objects.equals(id, ans.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
