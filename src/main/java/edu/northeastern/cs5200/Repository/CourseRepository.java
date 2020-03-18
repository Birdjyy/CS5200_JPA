package edu.northeastern.cs5200.Repository;

import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Faculty;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
    @Query("select course from Course course")
    public List<Course> finAllCourses();

    @Query("select course from Course course where course.faculty = :param")
    public List<Course> findCoursesForAuthor(@Param("param") Faculty faculty);
}