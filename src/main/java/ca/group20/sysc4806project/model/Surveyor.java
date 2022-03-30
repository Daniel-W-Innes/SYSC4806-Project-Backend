package ca.group20.sysc4806project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

/**
 * Surveyor is a person that owns one or multiple surveys
 */
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

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

    public Surveyor(String username, String firstName, String lastName, String hashedPassword) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hashedPassword = hashedPassword;
        this.surveys = new ArrayList<>();
        this.roles = new ArrayList<>();
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
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

    @JsonIgnore
    public String getHashedPassword() {
        return hashedPassword;
    }

    @JsonProperty
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

    /**
     * Converts Object to string
     */
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
        Surveyor surveyor = (Surveyor) o;
        if (Objects.equals(id, surveyor.id)) return true;
        return Objects.equals(username, surveyor.username) && Objects.equals(firstName, surveyor.firstName) && Objects.equals(lastName, surveyor.lastName) && Objects.equals(hashedPassword, surveyor.hashedPassword) && Objects.equals(surveys, surveyor.surveys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, firstName, lastName, hashedPassword, surveys);
    }
}
