package ca.group20.sysc4806project.model.question;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class TextAnswerable extends Question {
    public TextAnswerable(String question) {
        super(question);
    }
}
