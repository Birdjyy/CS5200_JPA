package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.models.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UniversityDao {
    void truncateDatabase();
    Faculty createFaculty(Faculty faculty);
    Student createStudent(Student student);
    Course createCourse(Course course);
    Section createSection(Section section);
    Course addSectioniToCourse(Section section, Course course);
    Course setAuthorForCourse(Faculty faculty, Course course);
    Boolean enrollStudentInSection(Student student, Section section);
    List<Person> findAllUsers();
    List<Faculty> findAllFaculty();
    List<Student> findAllStudents();
    List<Course> finAllCourses();
    List<Section> findAllSections();
    List<Course> findCoursesForAuthor(Faculty faculty);
    List<Section> findSectionForCourse(Course course);
    List<Student> findStudentsInSection(Section section);
    List<Section> findSectionForStudent(Student student);
}
