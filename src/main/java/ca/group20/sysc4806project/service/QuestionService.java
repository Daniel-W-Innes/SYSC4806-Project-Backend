package ca.group20.sysc4806project.service;

import ca.group20.sysc4806project.model.question.Question;

public interface QuestionService {

    Question findQuestionById(long questionId);

    /**
     * Adds a new question to the database
     *
     * @param question question to be added
     * @return newly created question
     */
    Question saveQuestion(Question question);
}
