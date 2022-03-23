package ca.group20.sysc4806project.repository;

import ca.group20.sysc4806project.model.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {
    Question findById(long questionId);
}
