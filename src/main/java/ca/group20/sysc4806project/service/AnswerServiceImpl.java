package ca.group20.sysc4806project.service;

import ca.group20.sysc4806project.model.answer.Answer;
import ca.group20.sysc4806project.repository.AnswerRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepo answerRepo;

    @Override
    public Answer saveAnswer(Answer answer) {
        return answerRepo.save(answer);
    }
}
