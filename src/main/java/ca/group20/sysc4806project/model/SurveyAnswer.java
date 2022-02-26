package ca.group20.sysc4806project.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SurveyAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name="answerID")
    private Long id;

    @JoinColumn(name="surveyID")
    @ManyToOne(targetEntity = Survey.class)
    private Long surveyID;

    @JoinColumn(name="questionID")
    @ManyToOne(targetEntity = Question.class)
    private Long questionID;

    private String answer;

    public SurveyAnswer(Long surveyID, Long questionID, String answer) {
        this.surveyID = surveyID;
        this.questionID = questionID;
        this.answer = answer;
    }

    public Long getID() {
        return this.id;
    }

    public Long getSurveyID() {
        return this.surveyID;
    }

    public Long getQuestionID() {
        return this.questionID;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
