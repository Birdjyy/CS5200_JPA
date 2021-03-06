package edu.northeastern.cs5200.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class Faculty extends Person{
    private String office;
    private Boolean tenured;

    @OneToMany(mappedBy = "faculty")
    private List<Course>courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public Boolean getTenured() {
        return tenured;
    }

    public void setTenured(Boolean tenured) {
        this.tenured = tenured;
    }

    public Faculty() {
    }
}
