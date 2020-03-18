package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer seats;
    private String title;

    @ManyToOne
    @JsonIgnore
    private Course course;

    @OneToMany(mappedBy = "section")
    private List<Enrollment> enrollments;

//    @ManyToMany
//    @JoinTable(name = "enrollment",
//    joinColumns = @JoinColumn(name = "section_id", referencedColumnName = "id"),
//    inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName =  "id"))
//    private List<Student>enrolledStudents;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

//    public List<Student> getEnrolledStudents() {
//        return enrolledStudents;
//    }
//
//    public void setEnrolledStudents(List<Student> enrolledStudents) {
//        this.enrolledStudents = enrolledStudents;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Section() {
    }
}
