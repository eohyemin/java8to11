package com.example.java8to11.optional;

import java.util.Optional;
import java.util.function.Predicate;

public class OnlineClass {
    private Integer id;
    private String title;
    private boolean closed;
    private Progress progress;

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Optional<Progress> getProgress() { // 리턴 타입에만 사용
        return Optional.ofNullable(progress);
        // Optional.empty();
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "OnlineClass{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", closed=" + closed +
                '}';
    }
}
