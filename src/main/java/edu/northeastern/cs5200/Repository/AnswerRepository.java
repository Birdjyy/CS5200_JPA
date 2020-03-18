package edu.northeastern.cs5200.Repository;

import edu.northeastern.cs5200.models.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/*@Repository*/
public interface AnswerRepository extends CrudRepository<Answer, Integer> {
}
