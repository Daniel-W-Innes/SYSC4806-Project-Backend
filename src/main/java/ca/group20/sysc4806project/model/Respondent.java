package ca.group20.sysc4806project.model;

import ca.group20.sysc4806project.model.answer.Answer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@NoArgsConstructor
public class Respondent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Survey survey;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "respondent")
    @JsonManagedReference
    private List<Answer> answers_list;

    public Respondent(String test){
        answers_list = new ArrayList<>();

    }
    public Survey getSurvey() {
        return survey;
    }

    public List<Answer> getAnswers() {
        return answers_list;
    }

    public Long getId(){
        return id;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers_list = answers;
    }

    public void addAnswer(Answer answer){
        answers_list.add(answer);
    }

    public void removeAnswer(Answer answer){
        answers_list.add(answer);
    }

    public Boolean compareAnswer(Answer answer){
        for(Answer resp_answer : answers_list){
            if (Objects.equals(resp_answer.getQuestionId(), answer.getQuestionId())){
                if(resp_answer.equals(answer)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Respondent{" +
                "id=" + id +
                ", survey=" + survey +
                ", answers_list=" + answers_list +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Respondent other_respondent = (Respondent) o;
        return Objects.equals(id, other_respondent.getId()) && Objects.equals(survey, other_respondent.getSurvey())
                && Objects.equals(answers_list, other_respondent.getAnswers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, survey.getId(), answers_list);
    }
}
