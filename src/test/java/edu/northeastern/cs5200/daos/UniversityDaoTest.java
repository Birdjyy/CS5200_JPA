package edu.northeastern.cs5200.daos;

import edu.northeastern.cs5200.Repository.AnswerRepository;
import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Faculty;
import edu.northeastern.cs5200.models.Section;
import edu.northeastern.cs5200.models.Student;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UniversityDaoTest {

    @Autowired
    private UniversityDao universityDao;

    @Autowired
    private AnswerRepository answerRepository;

    @Test
    public void testDao() {
        // Empty database
        universityDao.truncateDatabase();

        // Create Faculties
        Faculty faculty1 = new Faculty();
        faculty1.setFirstName("Alan");
        faculty1.setLastName("Turin");
        faculty1.setOffice("123A");
        faculty1.setTenured(true);

        Faculty faculty2 = new Faculty();
        faculty2.setFirstName("Alan");
        faculty2.setLastName("Turin");
        faculty2.setOffice("123A");
        faculty2.setTenured(true);

        universityDao.createFaculty(faculty1);
        universityDao.createFaculty(faculty2);

        // Create students
        Student student1 = new Student();
        student1.setFirstName("Alice");
        student1.setLastName("Wonderland");
        student1.setGradYear(2020);
        student1.setScholarship(12000);
        universityDao.createStudent(student1);

        Student student2 = new Student();
        student2.setFirstName("Bob");
        student2.setLastName("Hope");
        student2.setGradYear(2021);
        student2.setScholarship(23000);
        universityDao.createStudent(student2);

        Student student3 = new Student();
        student3.setFirstName("Charlie");
        student3.setLastName("Brown");
        student3.setGradYear(2019);
        student3.setScholarship(21000);
        universityDao.createStudent(student3);

        Student student4 = new Student();
        student4.setFirstName("Dan");
        student4.setLastName("Craig");
        student4.setGradYear(2019);
        student4.setScholarship(0);
        universityDao.createStudent(student4);

        Student student5 = new Student();
        student5.setFirstName("Edward");
        student5.setLastName("Scissorhands");
        student5.setGradYear(2022);
        student5.setScholarship(11000);
        universityDao.createStudent(student5);

        Student student6 = new Student();
        student6.setFirstName("Frank");
        student6.setLastName("Herbert");
        student6.setGradYear(2018);
        student6.setScholarship(0);
        universityDao.createStudent(student6);

        Student student7 = new Student();
        student7.setFirstName("Gregory");
        student7.setLastName("Peck");
        student7.setGradYear(2023);
        student7.setScholarship(10000);
        universityDao.createStudent(student7);

        // Create course
        Course course1 = new Course();
        course1.setFaculty(faculty1);
        course1.setLabel("CS1234");
        universityDao.createCourse(course1);

        Course course2 = new Course();
        course2.setFaculty(faculty1);
        course2.setLabel("CS2345");
        universityDao.createCourse(course2);

        Course course3 = new Course();
        course3.setFaculty(faculty2);
        course3.setLabel("CS3456");
        universityDao.createCourse(course3);

        Course course4 = new Course();
        course4.setFaculty(faculty2);
        course4.setLabel("CS4567");
        universityDao.createCourse(course4);

        // Create section
        Section section1 = new Section();
        section1.setTitle("SEC4321");
        section1.setSeats(50);
        section1.setCourse(course1);
        universityDao.createSection(section1);

        Section section2 = new Section();
        section2.setTitle("SEC5432");
        section2.setSeats(50);
        section2.setCourse(course1);
        universityDao.createSection(section2);

        Section section3 = new Section();
        section3.setTitle("SEC6543");
        section3.setSeats(50);
        section3.setCourse(course2);
        universityDao.createSection(section3);

        Section section4 = new Section();
        section4.setTitle("SEC7654");
        section4.setSeats(50);
        section4.setCourse(course3);
        universityDao.createSection(section4);

        // Enroll students in sections
        universityDao.enrollStudentInSection(student1, section1);
        universityDao.enrollStudentInSection(student1, section2);
        universityDao.enrollStudentInSection(student2, section2);
        universityDao.enrollStudentInSection(student3, section3);

        // Validate data
        assert(9==universityDao.findAllUsers().size());
        assert(2==universityDao.findAllFaculty().size());
        assert(7==universityDao.findAllStudents().size());
        assert(4==universityDao.finAllCourses().size());
        assert(4==universityDao.findAllSections().size());

        assert(2==universityDao.findCoursesForAuthor(faculty1).size());
        assert(2==universityDao.findCoursesForAuthor(faculty2).size());

        assert (2==universityDao.findSectionForCourse(course1).size());
        assert (1==universityDao.findSectionForCourse(course2).size());
        assert (1==universityDao.findSectionForCourse(course3).size());

        assert (1==universityDao.findStudentsInSection(section1).size());
        assert (2==universityDao.findStudentsInSection(section2).size());
        assert (1==universityDao.findStudentsInSection(section3).size());

        assert (2==universityDao.findSectionForStudent(student1).size());
        assert (1==universityDao.findSectionForStudent(student2).size());
        assert (1==universityDao.findSectionForStudent(student3).size());
//        for (Section section : universityDao.findAllSections()) {
//            assert (50==section.getSeats());
//        }
        List<Section> sectionList = universityDao.findAllSections();
        assert (49==sectionList.get(0).getSeats());
        assert (48==sectionList.get(1).getSeats());
        assert (49==sectionList.get(2).getSeats());
        assert (50==sectionList.get(3).getSeats());

    }


}