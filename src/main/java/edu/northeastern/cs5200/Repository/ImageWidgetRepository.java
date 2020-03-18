package edu.northeastern.cs5200.Repository;

import edu.northeastern.cs5200.models.ImageWidget;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Repository
public interface ImageWidgetRepository extends CrudRepository<ImageWidget, Integer> {
}