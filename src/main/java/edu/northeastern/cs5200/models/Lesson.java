package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.ui.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String label;

    @OneToMany(mappedBy = "lesson")
    private List<Topic> topics;

    @ManyToOne
    @JsonIgnore
    private Module module;

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Lesson() {
    }
}
