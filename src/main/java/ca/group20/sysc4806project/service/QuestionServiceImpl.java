package ca.group20.sysc4806project.service;

import ca.group20.sysc4806project.model.question.Question;
import ca.group20.sysc4806project.repository.QuestionRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepo questionRepo;

    /**
     * Adds a new question to the database
     *
     * @param question question to be added
     * @return newly created question
     */
    @Override
    public Question saveQuestion(Question question) {
        Question newQuestion = questionRepo.save(question);
        log.info(question.getQuestion() + " has been saved");
        return newQuestion;
    }

}
