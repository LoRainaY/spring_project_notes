package com.zaitsava.spring_project_notes.entity;

import javax.persistence.*;

import com.zaitsava.spring_project_notes.entity.User;
import javax.validation.constraints.NotEmpty;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;


    private String description;


    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Message() {
    }

    public Message(String description, String tag, User user) {
        this.author=user;
        this.description = description;
        this.tag = tag;
    }
    public String getAuthorName(){
        return author!=null ? author.getUsername(): "<none>";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
