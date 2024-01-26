package com.example.todo;

public class Task {
    private String title;
    private boolean completed;
    private String youtubeLink;

    public Task(String title) {
        this.title = title;
        this.completed = false;
    }

    public Task(String title, String youtubeLink) {
        this.title = title;
        this.completed = false;
        this.youtubeLink = youtubeLink;
    }


    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    @Override
    public String toString() {
        return title;
    }
}