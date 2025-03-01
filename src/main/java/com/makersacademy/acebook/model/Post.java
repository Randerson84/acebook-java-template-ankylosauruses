package com.makersacademy.acebook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import com.makersacademy.acebook.model.Comment;
import lombok.Data;

import java.util.ArrayList;

@Data
@Entity
@Table(name = "POSTS")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Long user_id;
    private Integer likes;



    public Post() {}

    public Post(String content) {
        this.content = content;
    }
    public String getContent() { return this.content; }
    public void setContent(String content) { this.content = content; }
    public void setUID(Long user_id) { this.user_id = user_id; }

    public Integer getLikes() {return this.likes;}

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}
