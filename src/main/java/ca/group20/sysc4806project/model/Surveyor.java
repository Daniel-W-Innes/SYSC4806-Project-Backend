package ca.group20.sysc4806project.model;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="surveyor")
@NoArgsConstructor
@AllArgsConstructor
public class Surveyor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name="surveyorID")
    private Long id;

    private String username;
    private String firstName;
    private String lastName;
    private String hashedPassword;

    @OneToMany(targetEntity=Survey.class, mappedBy="ownerID")
    private List<Survey> surveys;

    public Surveyor(String username, String firstName, String lastName, String hashedPassword) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hashedPassword = hashedPassword;

        this.surveys = new ArrayList<Survey>();
    }

    public Long getID() {
        return this.id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return hashedPassword;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public void addSurvey(Survey s) {
        this.surveys.add(s);
    }

    public List<Survey> getSurveys() {
        return this.surveys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Surveyor user = (Surveyor) o;
        return Objects.equals(username, user.username) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(hashedPassword, user.hashedPassword);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + hashedPassword + '\'' +
                '}';
    }
}
