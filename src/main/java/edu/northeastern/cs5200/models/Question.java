package edu.northeastern.cs5200.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String question;
    private Integer points;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    @ManyToOne
    @JsonIgnore
    private QuizWidget quizWidget;

    public QuizWidget getQuizWidget() {
        return quizWidget;
    }

    public void setQuizWidget(QuizWidget quizWidget) {
        this.quizWidget = quizWidget;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Answer> getAnswer() {
        return answers;
    }

    public void setAnswer(List<Answer> answer) {
        this.answers = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Question() {
    }
}
