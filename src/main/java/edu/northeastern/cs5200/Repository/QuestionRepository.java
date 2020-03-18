package edu.northeastern.cs5200.Repository;

import edu.northeastern.cs5200.models.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface QuestionRepository extends CrudRepository<Question, Integer> {
}
