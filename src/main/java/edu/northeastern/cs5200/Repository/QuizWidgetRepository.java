package edu.northeastern.cs5200.Repository;

import edu.northeastern.cs5200.models.QuizWidget;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface QuizWidgetRepository extends CrudRepository<QuizWidget, Integer> {
}
