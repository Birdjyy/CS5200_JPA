package edu.northeastern.cs5200.models;

import javax.persistence.Entity;

@Entity
public class ListWidget extends Widget{
    private String items;
    Boolean ordered;

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public Boolean getOrdered() {
        return ordered;
    }

    public void setOrdered(Boolean ordered) {
        this.ordered = ordered;
    }

    public ListWidget() {
    }
}
