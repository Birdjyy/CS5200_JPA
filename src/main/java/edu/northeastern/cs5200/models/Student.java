package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student extends Person{
    private Integer gradYear;
    private long scholarship;

    @OneToMany(mappedBy = "student")
    private List<Answer> answers;

    @OneToMany(mappedBy = "student")
    private List<Enrollment> enrollments;
//    @ManyToMany(mappedBy = "enrolledStudents")
//    @JsonIgnore
//    private List<Section>enrolledSections;

//    public List<Section> getEnrolledSections() {
//        return enrolledSections;
//    }
//
//    public void setEnrolledSections(List<Section> enrolledSections) {
//        this.enrolledSections = enrolledSections;
//    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Integer getGradYear() {
        return gradYear;
    }

    public void setGradYear(Integer gradYear) {
        this.gradYear = gradYear;
    }

    public long getScholarship() {
        return scholarship;
    }

    public void setScholarship(long scholarship) {
        this.scholarship = scholarship;
    }

    public Student() {
    }
}
