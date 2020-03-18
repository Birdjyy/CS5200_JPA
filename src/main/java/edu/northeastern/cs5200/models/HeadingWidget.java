package edu.northeastern.cs5200.models;

import javax.persistence.Entity;

@Entity
public class HeadingWidget extends Widget{
    private Integer size;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public HeadingWidget() {
    }
}
