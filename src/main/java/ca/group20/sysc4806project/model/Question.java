package ca.group20.sysc4806project.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "questionID", updatable = false, nullable = false)
    private Long id;

    @JoinColumn(name="surveyID")
    @ManyToOne(targetEntity = Survey.class)
    private Long surveyID;

    private QuestionType type;
    private String question;

    public Question(Long surveyID, QuestionType type, String question) {
        this.surveyID = surveyID;
        this.type = type;
        this.question = question;
    }

    public Long getID() {
        return this.id;
    }

    public String getQuestion() {
        return this.question;
    }

    public QuestionType getType() { return this.type; }

    public Long getSurveyID() { return this.surveyID; }

    public void setQuestion(String question) {
        this.question = question;
    }
}
