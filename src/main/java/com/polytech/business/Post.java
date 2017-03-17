package com.polytech.business;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by KHOA on 13-Mar-17.
 */
@Entity
@Table(name = "POST")
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CONTENT")
    private String content;

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

    public String toString() {return content; }
}
