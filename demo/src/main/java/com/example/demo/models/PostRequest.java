package com.example.demo.models;

import java.util.Objects;

public class PostRequest {
    private String title;
    private String content;
    private String tags;
    private boolean published;
    public PostRequest() {
    }


    public PostRequest(String title, String content, String tags, boolean published) {
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.published = published;
    }


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTags() {
        return this.tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public boolean isPublished() {
        return this.published;
    }

    public boolean getPublished() {
        return this.published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PostRequest)) {
            return false;
        }
        PostRequest postRequest = (PostRequest) o;
        return Objects.equals(title, postRequest.title) && Objects.equals(content, postRequest.content) && Objects.equals(tags, postRequest.tags) && published == postRequest.published;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, tags, published);
    }

    @Override
    public String toString() {
        return "{" +
            " title='" + getTitle() + "'" +
            ", content='" + getContent() + "'" +
            ", tags='" + getTags() + "'" +
            ", published='" + isPublished() + "'" +
            "}";
    }

}

   
