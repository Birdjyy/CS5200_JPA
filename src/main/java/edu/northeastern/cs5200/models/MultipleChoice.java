package edu.northeastern.cs5200.models;

import javax.persistence.Entity;

@Entity
public class MultipleChoice extends Question{
    private String choices;
    private Integer correct;

    public String getChoices() {
        return choices;
    }

    public void setChoices(String choices) {
        this.choices = choices;
    }

    public Integer getCorrect() {
        return correct;
    }

    public void setCorrect(Integer correct) {
        this.correct = correct;
    }

    public MultipleChoice() {
    }
}
