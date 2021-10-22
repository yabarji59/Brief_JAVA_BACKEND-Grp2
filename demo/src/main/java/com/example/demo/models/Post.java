package com.example.demo.models;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "post")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    
    @Column(name = "title")
    private String title;
    
    @Column(name = "content")
    private String content;
    
    @Column(name = "tags")
    private String tags;
    
    @Column(name = "published")
    private boolean published;

    public Post() {
    }
     
    public Post( String title, String content, String tags, boolean published) {
        
        this.title = title;
        this.content = content;
        this.tags = tags;
        this.published = published;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", title='" + getTitle() + "'" + ", content='" + getContent() + "'"
                + ", tags='" + getTags() + "'" + ", published='" + isPublished() + "'" + "}";
    }
    
}
