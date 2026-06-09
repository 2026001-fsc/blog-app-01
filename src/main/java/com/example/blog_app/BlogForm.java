package com.example.blog_app;

public class BlogForm {
    private String title;
    private String text;
    
    public String getText() {
        return text;
    }
    public String getTitle() {
        return title;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
