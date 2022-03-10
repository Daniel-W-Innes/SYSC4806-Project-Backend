package ca.group20.sysc4806project.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Entity
@NoArgsConstructor
public class Surveyor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String firstName;
    private String lastName;
    private String hashedPassword;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "surveyor")
    private List<Survey> surveys;

    public Surveyor(String username, String firstName, String lastName, String hashedPassword) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hashedPassword = hashedPassword;
        this.surveys = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public List<Survey> getSurveys() {
        return surveys;
    }

    public Optional<Survey> getSurvey(String name) {
        return surveys.stream().filter(survey -> survey.getName().equals(name)).findFirst();
    }

    public boolean addSurvey(Survey s) {
         return surveys.add(s);
    }

    public String toJson() {
        return "{" +
                "\"username\":\"" + username + "\"" +
                ",\"firstName\":\"" + firstName + "\"" +
                ",\"lastName\":\"" + lastName + "\"" +
                ",\"hashedPassword\":\"" + hashedPassword + "\"" +
                '}';
    }
    @Override
    public String toString() {
        return "Surveyor{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hashedPassword='" + hashedPassword + '\'' +
                ", surveys=" + surveys +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Surveyor surveyor = (Surveyor) o;
        if (Objects.equals(id, surveyor.id)) return true;
        return Objects.equals(username, surveyor.username) && Objects.equals(firstName, surveyor.firstName) && Objects.equals(lastName, surveyor.lastName) && Objects.equals(hashedPassword, surveyor.hashedPassword) && Objects.equals(surveys, surveyor.surveys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, firstName, lastName, hashedPassword, surveys);
    }
}
