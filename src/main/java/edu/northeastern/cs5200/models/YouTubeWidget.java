package edu.northeastern.cs5200.models;

import javax.persistence.Entity;

@Entity
public class YouTubeWidget extends Widget{
    private String youTubeId;

    public String getYouTubeId() {
        return youTubeId;
    }

    public void setYouTubeId(String youTubeId) {
        this.youTubeId = youTubeId;
    }

    public YouTubeWidget() {
    }
}
