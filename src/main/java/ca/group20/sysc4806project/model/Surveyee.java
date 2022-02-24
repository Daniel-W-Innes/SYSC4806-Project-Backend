package ca.group20.sysc4806project.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Surveyee extends User {

    private List<Long> surveysAnswered;//IDs of surveys answered by this participant

    public Surveyee(String username, String firstName, String lastName, String password) {
        super(username, firstName, lastName, password);

        this.surveysAnswered = new ArrayList<Long>();
    }

    public void addSurvey(Long surveyID) {
        this.surveysAnswered.add(surveyID);
    }

    public List<Long> getSurveys() {
        return this.surveysAnswered;
    }
}
