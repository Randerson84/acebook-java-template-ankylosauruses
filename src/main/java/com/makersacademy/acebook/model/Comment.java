package com.makersacademy.acebook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "COMMENTS")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private Long postsid;
    private Long usersid;

    public Comment() {}

    public Comment(String message, Long postsid) {
        this.message = message;
        this.postsid = postsid;
    }


    public String getMessage() { return this.message; }
    public void setMessage(String message) { this.message = message; }
    public Long getUsersid() { return this.usersid; }
    public void setUsersid(Long usersid) { this.usersid = usersid; }
    public Long getPostsid() { return this.postsid; }
    public void setPostsid(Long usersid) { this.postsid = usersid; }

}