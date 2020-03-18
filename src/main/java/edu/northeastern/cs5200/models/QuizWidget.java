package edu.northeastern.cs5200.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class QuizWidget extends Widget{
    @OneToMany(mappedBy = "quizWidget")
    private List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public QuizWidget() {
    }
}
