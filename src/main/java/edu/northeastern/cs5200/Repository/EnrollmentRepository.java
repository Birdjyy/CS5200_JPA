package edu.northeastern.cs5200.Repository;

import edu.northeastern.cs5200.models.Enrollment;
import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.models.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface EnrollmentRepository extends CrudRepository<Enrollment, Integer> {
    @Query("select enrollment from Enrollment enrollment where enrollment.section = :param")
    public List<Enrollment> findEnrollmentBySection(@Param("param") Section section);

    @Query("select enrollment from Enrollment enrollment where enrollment.student = :param")
    public List<Enrollment> findEnrollmentByStudent(@Param("param") Student student);
}
