package com.makersacademy.acebook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;

import lombok.Data;

@Data
@Entity
@Table(name = "POSTS")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Integer user_id;

    public Post() {}

    public Post(String content) {
        this.content = content;
    }
    public String getContent() { return this.content; }
    public void setContent(String content) { this.content = content; }
    public void setUID(Integer user_id) { this.user_id = user_id; }

}
