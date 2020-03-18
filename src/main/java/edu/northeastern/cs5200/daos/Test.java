package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.Repository.*;
import edu.northeastern.cs5200.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;

import javax.crypto.SecretKey;
import javax.imageio.ImageReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class Test implements UniversityDao{
    @Autowired
    AnswerRepository answerRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    FacultyRepository facultyRepository;
//    @Autowired
//    HeadingWidgetRepository headingWidgetRepository;
//    @Autowired
//    ImageWidgetRepository imageWidgetRepository;
    @Autowired
    LessonRepository lessonRepository;
//    @Autowired
//    ListWidgetRepository listWidgetRepository;
    @Autowired
    ModuleRepository moduleRepository;
//    @Autowired
//    MultipleChoiceRepository multipleChoiceRepository;
//    @Autowired
//    ParagraphWidgetRepository paragraphWidgetRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    QuestionRepository questionRepository;
//    @Autowired
//    QuizWidgetRepository quizWidgetRepository;
    @Autowired
    SectionRepository sectionRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TopicRepository topicRepository;
//    @Autowired
//    TrueFalseRepository trueFalseRepository;
    @Autowired
    WidgetRepository widgetRepository;
    @Autowired
    EnrollmentRepository enrollmentRepository;
//    @Autowired
//    YouTubeWidgetRepository youTubeWidgetRepository;

    public Test() {
    }

    public void truncateDatabase() {
//        imageWidgetRepository.deleteAll();
//        headingWidgetRepository.deleteAll();
//        paragraphWidgetRepository.deleteAll();
//        listWidgetRepository.deleteAll();
//        youTubeWidgetRepository.deleteAll();
        answerRepository.deleteAll();
//        multipleChoiceRepository.deleteAll();
//        trueFalseRepository.deleteAll();
        questionRepository.deleteAll();
//        quizWidgetRepository.deleteAll();
        widgetRepository.deleteAll();
        topicRepository.deleteAll();
        lessonRepository.deleteAll();
        moduleRepository.deleteAll();
        enrollmentRepository.deleteAll();
        studentRepository.deleteAll();
        sectionRepository.deleteAll();
        courseRepository.deleteAll();
        facultyRepository.deleteAll();
        personRepository.deleteAll();

    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Section createSection(Section section) {
        return sectionRepository.save(section);
    }

    public Course addSectioniToCourse(Section section, Course course) {
        Section insertSection = new Section();
        insertSection.setCourse(course);
        insertSection.setSeats(section.getSeats());
        sectionRepository.save(insertSection);
        return course;
    }

    public Course setAuthorForCourse(Faculty faculty, Course course) {
        course.setFaculty(faculty);
        return courseRepository.save(course);
    }

    public Boolean enrollStudentInSection(Student student, Section section) {
        if(section.getSeats() == 0){
            return false;
        }
        else{
            section.setSeats(section.getSeats() - 1);
            Enrollment enrollment = new Enrollment();
            enrollment.setSection(section);
            enrollment.setStudent(student);
            enrollmentRepository.save(enrollment);
            sectionRepository.save(section);
            return true;
        }
    }

    public List<Person> findAllUsers() {
        return personRepository.findAllUsers();
    }

    public List<Faculty> findAllFaculty() {
        return facultyRepository.findAllFaculty();
    }

    public List<Student> findAllStudents() {
        return studentRepository.findAllStudents();
    }

    public List<Course> finAllCourses() {
        return courseRepository.finAllCourses();
    }

    public List<Section> findAllSections() {
        return sectionRepository.findAllSections();
    }

    public List<Course> findCoursesForAuthor(Faculty faculty) {
        return courseRepository.findCoursesForAuthor(faculty);
    }

    public List<Section> findSectionForCourse(Course course) {
        return sectionRepository.findSectionForCourse(course);
    }

    public List<Student> findStudentsInSection(Section section) {
        List<Student> student = new ArrayList<Student>();
        List<Enrollment> enrollment = enrollmentRepository.findEnrollmentBySection(section);
        for (Enrollment value : enrollment) {
            student.add(value.getStudent());
        }
        return student;
    }

    public List<Section> findSectionForStudent(Student student) {
        List<Section> sections = new ArrayList<Section>();
        List<Enrollment> enrollments = enrollmentRepository.findEnrollmentByStudent(student);
        for (Enrollment enrollment : enrollments) {
            sections.add(enrollment.getSection());
        }
        return sections;
    }


}
