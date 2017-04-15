package com.polytech.business;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by KHOA on 13-Mar-17.
 */
@Entity
@Table(name = "POST")
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "CONTENT")
    private String content;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "post")
    private List<Comment> comments = new ArrayList<Comment>();

    @ManyToOne
    @JoinColumn(name="USERNAME",referencedColumnName = "USERNAME")
    private User user;

    public Post() {}

    public Post(String content){
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {return comments;}

    public void setComments(List<Comment> comments) {this.comments = comments;}

    public long getId() {return id;}

    public User getUser() {return user;}

    public void setUser(User user) {this.user = user;}
}
