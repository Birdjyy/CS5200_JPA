package edu.northeastern.cs5200.Repository;

import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    @Query("select student from Student student")
    public List<Student> findAllStudents();
}