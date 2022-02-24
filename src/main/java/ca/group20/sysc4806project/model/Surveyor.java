package ca.group20.sysc4806project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Surveyor extends User {

    private List<Survey> surveys;

    public Surveyor(String username, String firstName, String lastName, String password) {
        super(username, firstName, lastName, password);

        this.surveys = new ArrayList<Survey>();
    }

    public void addSurvey(Survey s) {
        this.surveys.add(s);
    }

    public List<Survey> getSurveys() {
        return this.surveys;
    }
}
