package com.tomek.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Article {

    private String title;
    private String content;
    private String tags;

    public Article(String title, String content, String tags) {
        this.title = title;
        this.content = content;
        this.tags = tags;
    }

    public Article(){}


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
