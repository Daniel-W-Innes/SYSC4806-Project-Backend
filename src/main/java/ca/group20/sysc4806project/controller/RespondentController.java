package ca.group20.sysc4806project.controller;

import ca.group20.sysc4806project.model.answer.Answer;
import ca.group20.sysc4806project.service.AnswerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/v0/respondents")
@RequiredArgsConstructor
@Slf4j
public class RespondentController {

    private final AnswerService answerService;

    @PostMapping("/answer")
    public ResponseEntity<?> create(@Valid @RequestBody Answer answer) {
        Answer newAnswer = answerService.saveAnswer(answer);
        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentContextPath()
                        .path("/api/v0/respondents")
                        .toUriString());
        return ResponseEntity.created(uri).body(newAnswer);
    }
}
