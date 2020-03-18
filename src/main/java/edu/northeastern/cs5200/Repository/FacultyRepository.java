package edu.northeastern.cs5200.Repository;

import edu.northeastern.cs5200.models.Faculty;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Integer> {
    @Query("select faculty from Faculty faculty")
    public List<Faculty> findAllFaculty();
}
